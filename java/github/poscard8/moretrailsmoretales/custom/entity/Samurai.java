package github.poscard8.moretrailsmoretales.custom.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class Samurai extends AbstractIllager {
    private boolean hostile = false;
    private int hostileCooldown = 0;
    private int age = 0;
    private NearestAttackableTargetGoal hostileGoal = new NearestAttackableTargetGoal<>(this, Player.class, false);

    public Samurai(EntityType<? extends Samurai> type, Level level) {
        super(type, level);
        this.xpReward = 8;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new GetTargetDistanceGoal(this, 3.75F));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.9D, false));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.45D ));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.goalSelector.removeGoal(new ObtainRaidLeaderBannerGoal<>(this));
        this.targetSelector.addGoal(0, (new HurtByTargetGoal(this, Samurai.class)).setAlertOthers());
    }

    @Override
    public void tick() {
        super.tick();
        ++this.age;

        if (this.hostileCooldown < 0) { this.setNeutral(); }
        else { --this.hostileCooldown; }
    }

    public void setHostile() {

        this.hostile = true;
        this.hostileCooldown = 400;
        this.targetSelector.addGoal(1, hostileGoal);

    }

    public void setNeutral() {

        this.hostile = false;
        this.targetSelector.removeGoal(hostileGoal);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, MobSpawnType p_34090_,
                                        @Nullable SpawnGroupData p_34091_, @Nullable CompoundTag p_34092_) {
        this.setPatrolLeader(false);
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_, p_34092_);
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        RandomSource randomsource = p_34088_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_34089_);
        return spawngroupdata;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.45F)
                .add(Attributes.FOLLOW_RANGE, 24.0D)
                .add(Attributes.MAX_HEALTH, 18.0D)
                .add(Attributes.ARMOR, 12.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.5D);

    }

    @Override
    public @NotNull IllagerArmPose getArmPose() {
        return IllagerArmPose.NEUTRAL;
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource p_219149_, DifficultyInstance p_219150_) {
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.AIR));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
    }

    @Override
    public void applyRaidBuffs(int integer, boolean bool) {}

    @Override
    public boolean canJoinRaid() { return false; }

    @Override
    public boolean canJoinPatrol() { return false; }

    @Override
    @Nullable
    public SoundEvent getCelebrateSound() { return null; }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.VINDICATOR_AMBIENT;
    }

    @NotNull
    protected SoundEvent getDeathSound() {
        return SoundEvents.VINDICATOR_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_34103_) {
        return SoundEvents.VINDICATOR_HURT;
    }

    static class GetTargetDistanceGoal extends Goal {
        public Samurai mob;
        private float boundary;
        protected @Nullable Player target;
        protected TargetingConditions targetConditions = TargetingConditions.forCombat().range(24.0D).selector(null);


        public GetTargetDistanceGoal(Samurai mob, float boundary) {
            this.mob = mob;
            this.boundary = boundary;
        }

        protected void findTarget() {
            this.target = this.mob.level().getNearestPlayer(this.targetConditions, this.mob,
                    this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        }

        protected void resetTarget() {
            this.target = null;
            this.findTarget();
        }

        @Override
        public boolean canUse() {
            this.resetTarget();
            return !(this.target == null || this.mob.hostile);
        }

        @Override
        public boolean canContinueToUse() { return !this.mob.hostile; }

        @Override
        public void stop() { this.target = null; }

        @Override
        public void tick() {

            if (this.target != null && this.mob.age > 200 && this.mob.distanceToSqr(this.target) < this.boundary * this.boundary) {
                this.mob.setHostile();
                this.mob.playSound(this.mob.getDeathSound());
            }
        }
    }
}
