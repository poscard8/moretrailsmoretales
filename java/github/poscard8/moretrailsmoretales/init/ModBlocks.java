package github.poscard8.moretrailsmoretales.init;

import github.poscard8.moretrailsmoretales.MoreTrailsMoreTales;
import github.poscard8.moretrailsmoretales.custom.StatueHeight;
import github.poscard8.moretrailsmoretales.custom.block.BottomStatueBlock;
import github.poscard8.moretrailsmoretales.custom.block.NonGravityBrushableBlock;
import github.poscard8.moretrailsmoretales.custom.block.TopStatueBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreTrailsMoreTales.MODID);

    public static final RegistryObject<RotatedPillarBlock> STONE_BASE = BLOCKS.register("stone_base",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .strength(2, 8)
                    .requiresCorrectToolForDrops()
                    .lightLevel((blockState) -> 1)));

    public static final RegistryObject<RotatedPillarBlock> ANDESITE_BASE = BLOCKS.register("andesite_base",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(STONE_BASE.get())));

    public static final RegistryObject<RotatedPillarBlock> GRANITE_BASE = BLOCKS.register("granite_base",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(STONE_BASE.get())
                    .mapColor(MapColor.TERRACOTTA_PINK)));

    public static final RegistryObject<RotatedPillarBlock> DIORITE_BASE = BLOCKS.register("diorite_base",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(STONE_BASE.get())
                    .mapColor(MapColor.TERRACOTTA_WHITE)));

    public static final RegistryObject<RotatedPillarBlock> CALCITE_BASE = BLOCKS.register("calcite_base",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(DIORITE_BASE.get())));

    public static final RegistryObject<RotatedPillarBlock> STONE_PILLAR = BLOCKS.register("stone_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .strength((float) 3/2, 6)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<RotatedPillarBlock> ANDESITE_PILLAR = BLOCKS.register("andesite_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .strength((float) 3/2, 6)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<RotatedPillarBlock> GRANITE_PILLAR = BLOCKS.register("granite_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_PINK)
                    .strength((float) 3/2, 6)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<RotatedPillarBlock> DIORITE_PILLAR = BLOCKS.register("diorite_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .strength((float) 3/2, 6)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<RotatedPillarBlock> CALCITE_PILLAR = BLOCKS.register("calcite_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .strength((float) 3/2, 6)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CALCITE_BRICKS = BLOCKS.register("calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(CALCITE_PILLAR.get())));

    public static final RegistryObject<StairBlock> CALCITE_BRICK_STAIRS = BLOCKS.register("calcite_brick_stairs",
            () -> new StairBlock(CALCITE_BRICKS.get()::defaultBlockState,
                    BlockBehaviour.Properties.copy(CALCITE_PILLAR.get())));

    public static final RegistryObject<SlabBlock> CALCITE_BRICK_SLAB = BLOCKS.register("calcite_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(CALCITE_PILLAR.get())));

    public static final RegistryObject<WallBlock> CALCITE_BRICK_WALL = BLOCKS.register("calcite_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(CALCITE_PILLAR.get()).forceSolidOn()));

    public static final RegistryObject<NonGravityBrushableBlock> SUSPICIOUS_DIRT = BLOCKS.register("suspicious_dirt",
            () -> new NonGravityBrushableBlock(Blocks.DIRT, BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .pushReaction(PushReaction.DESTROY), SoundEvents.GRASS_STEP, SoundEvents.GRASS_BREAK));

    public static final RegistryObject<BottomStatueBlock> GOD_STATUE_BOTTOM = BLOCKS.register("god_statue_bottom",
            () -> new BottomStatueBlock(BlockBehaviour.Properties.copy(CALCITE_PILLAR.get()).strength(1, 2)));

    public static final RegistryObject<TopStatueBlock> GOD_STATUE_TOP = BLOCKS.register("god_statue_top",
            () -> new TopStatueBlock(BlockBehaviour.Properties.copy(GOD_STATUE_BOTTOM.get()), StatueHeight.TALL));

    public static final RegistryObject<BottomStatueBlock> WARRIOR_STATUE_BOTTOM = BLOCKS.register("warrior_statue_bottom",
            () -> new BottomStatueBlock(BlockBehaviour.Properties.copy(GOD_STATUE_BOTTOM.get())));

    public static final RegistryObject<TopStatueBlock> WARRIOR_STATUE_TOP = BLOCKS.register("warrior_statue_top",
            () -> new TopStatueBlock(BlockBehaviour.Properties.copy(GOD_STATUE_BOTTOM.get())));

    public static final RegistryObject<BottomStatueBlock> PRIESTESS_STATUE_BOTTOM = BLOCKS.register("priestess_statue_bottom",
            () -> new BottomStatueBlock(BlockBehaviour.Properties.copy(GOD_STATUE_BOTTOM.get())));

    public static final RegistryObject<TopStatueBlock> PRIESTESS_STATUE_TOP = BLOCKS.register("priestess_statue_top",
            () -> new TopStatueBlock(BlockBehaviour.Properties.copy(GOD_STATUE_BOTTOM.get()), StatueHeight.SHORT));


}
