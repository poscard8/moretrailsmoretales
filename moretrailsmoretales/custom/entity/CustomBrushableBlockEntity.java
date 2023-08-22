package github.poscard8.moretrailsmoretales.custom.entity;

import github.poscard8.moretrailsmoretales.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CustomBrushableBlockEntity extends BrushableBlockEntity {

    public CustomBrushableBlockEntity(BlockPos pos, BlockState state) { super(pos, state); }

    @Override
    public BlockEntityType<?> getType() { return ModEntities.SUS_DIRT_BLOCK_ENTITY.get(); }

}
