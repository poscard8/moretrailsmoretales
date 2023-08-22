package github.poscard8.moretrailsmoretales.custom.block;

import github.poscard8.moretrailsmoretales.custom.entity.CustomBrushableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NonGravityBrushableBlock extends BrushableBlock {
    private static final IntegerProperty DUSTED = BlockStateProperties.DUSTED;
    private final Block turnsInto;
    private final SoundEvent brushSound;
    private final SoundEvent brushCompletedSound;

    public NonGravityBrushableBlock(Block p_277629_, BlockBehaviour.Properties p_277373_, SoundEvent p_278060_, SoundEvent p_277352_) {
        super(p_277629_, p_277373_, p_278060_, p_277352_);
        this.turnsInto = p_277629_;
        this.brushSound = p_278060_;
        this.brushCompletedSound = p_277352_;
        this.registerDefaultState(this.stateDefinition.any().setValue(DUSTED, 0));
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState blockState) { return new CustomBrushableBlockEntity(pos, blockState); }

    @Override
    public void tick(BlockState p_222945_, ServerLevel p_222946_, BlockPos p_222947_, RandomSource p_222948_) {
        BlockEntity blockentity = p_222946_.getBlockEntity(p_222947_);
        if (blockentity instanceof BrushableBlockEntity brushableblockentity) {
            brushableblockentity.checkReset();
        }
    }

    @Override
    public void animateTick(BlockState p_277390_, Level p_277525_, BlockPos p_278107_, RandomSource p_277574_) {}

    @Override
    public @NotNull Block getTurnsInto() { return turnsInto; }

    @Override
    public @NotNull SoundEvent getBrushSound() { return brushSound; }

    @Override
    public @NotNull SoundEvent getBrushCompletedSound() { return brushCompletedSound; }


}