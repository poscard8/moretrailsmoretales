package github.poscard8.moretrailsmoretales.custom.block;

import github.poscard8.moretrailsmoretales.custom.StatueHeight;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class TopStatueBlock extends HorizontalDirectionalBlock {
    protected static final EnumProperty<StatueHeight> HEIGHT = EnumProperty.create("height", StatueHeight.class);

    public TopStatueBlock(BlockBehaviour.Properties property) {
        this(property, StatueHeight.NORMAL);
    }

    public TopStatueBlock(BlockBehaviour.Properties property, StatueHeight height) {
        super(property);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HEIGHT, height));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        def.add(FACING);
        def.add(HEIGHT);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_55928_) {
        return this.defaultBlockState().setValue(FACING, p_55928_.getHorizontalDirection());
    }

    @Override
    @NotNull
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos position, CollisionContext ctx) {
        return heightToShape(state.getValue(HEIGHT));
    }

    private VoxelShape heightToShape(StatueHeight height) {
        return Block.box(4.5D, 0.0D, 4.5D, 11.5D, height.getHeight(), 11.5D);
    }

}



