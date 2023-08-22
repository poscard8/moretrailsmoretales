package github.poscard8.moretrailsmoretales.init;

import github.poscard8.moretrailsmoretales.MoreTrailsMoreTales;
import github.poscard8.moretrailsmoretales.custom.entity.CustomBrushableBlockEntity;
import github.poscard8.moretrailsmoretales.custom.entity.Samurai;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            MoreTrailsMoreTales.MODID);

    public static final RegistryObject<EntityType<Samurai>> SAMURAI = ENTITIES.register("samurai",
            () -> EntityType.Builder.of(Samurai::new, MobCategory.MONSTER).sized(0.6F, 2.0F)
                    .build(new ResourceLocation(MoreTrailsMoreTales.MODID, "samurai").toString()));


    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
            MoreTrailsMoreTales.MODID);

    public static final RegistryObject<BlockEntityType<CustomBrushableBlockEntity>> SUS_DIRT_BLOCK_ENTITY = BLOCK_ENTITIES.register("custom_brushable_block",
            () -> BlockEntityType.Builder.of(CustomBrushableBlockEntity::new, ModBlocks.SUSPICIOUS_DIRT.get()).build(null));



}
