package github.poscard8.moretrailsmoretales.custom.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BottomStatueBlock extends HorizontalDirectionalBlock {
    protected static final VoxelShape BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);
    protected static final VoxelShape TOP = Block.box(4.5D, 2.0D, 4.5D, 11.5D, 16.0D, 11.5D);
    private static final VoxelShape SHAPE = Shapes.or(BASE, TOP);

    public BottomStatueBlock(BlockBehaviour.Properties p_52591_) {
        super(p_52591_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51468_) {
        p_51468_.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_55928_) {
        return this.defaultBlockState().setValue(FACING, p_55928_.getHorizontalDirection());
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }
}

