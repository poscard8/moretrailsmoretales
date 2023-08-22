package github.poscard8.moretrailsmoretales.init;

import github.poscard8.moretrailsmoretales.MoreTrailsMoreTales;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreTrailsMoreTales.MODID);

    public static final RegistryObject<SmithingTemplateItem> HONOR_TEMPLATE = ITEMS.register("honor_armor_trim_smithing_template", () ->
            SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.tryBuild("moretrailsmoretales","honor")));

    public static final RegistryObject<SmithingTemplateItem> WISDOM_TEMPLATE = ITEMS.register("wisdom_armor_trim_smithing_template", () ->
            SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.tryBuild("moretrailsmoretales","wisdom")));

    public static RegistryObject<Item> IDEA_POTTERY_SHERD = ITEMS.register("idea_pottery_sherd",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIGHTNING_POTTERY_SHERD = ITEMS.register("lightning_pottery_sherd",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WARRIOR_POTTERY_SHERD = ITEMS.register("warrior_pottery_sherd",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<BlockItem> STONE_BASE_ITEM = ITEMS.register("stone_base",
            () -> new BlockItem(ModBlocks.STONE_BASE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> ANDESITE_BASE_ITEM = ITEMS.register("andesite_base",
            () -> new BlockItem(ModBlocks.ANDESITE_BASE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> GRANITE_BASE_ITEM = ITEMS.register("granite_base",
            () -> new BlockItem(ModBlocks.GRANITE_BASE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> DIORITE_BASE_ITEM = ITEMS.register("diorite_base",
            () -> new BlockItem(ModBlocks.DIORITE_BASE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> CALCITE_BASE_ITEM = ITEMS.register("calcite_base",
            () -> new BlockItem(ModBlocks.CALCITE_BASE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> STONE_PILLAR_ITEM = ITEMS.register("stone_pillar",
            () -> new BlockItem(ModBlocks.STONE_PILLAR.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> ANDESITE_PILLAR_ITEM = ITEMS.register("andesite_pillar",
            () -> new BlockItem(ModBlocks.ANDESITE_PILLAR.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> GRANITE_PILLAR_ITEM = ITEMS.register("granite_pillar",
            () -> new BlockItem(ModBlocks.GRANITE_PILLAR.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> DIORITE_PILLAR_ITEM = ITEMS.register("diorite_pillar",
            () -> new BlockItem(ModBlocks.DIORITE_PILLAR.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> CALCITE_PILLAR_ITEM = ITEMS.register("calcite_pillar",
            () -> new BlockItem(ModBlocks.CALCITE_PILLAR.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> CALCITE_BRICKS_ITEM = ITEMS.register("calcite_bricks",
            () -> new BlockItem(ModBlocks.CALCITE_BRICKS.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> CALCITE_BRICK_STAIRS_ITEM = ITEMS.register("calcite_brick_stairs",
            () -> new BlockItem(ModBlocks.CALCITE_BRICK_STAIRS.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> CALCITE_BRICK_SLAB_ITEM = ITEMS.register("calcite_brick_slab",
            () -> new BlockItem(ModBlocks.CALCITE_BRICK_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> CALCITE_BRICK_WALL_ITEM = ITEMS.register("calcite_brick_wall",
            () -> new BlockItem(ModBlocks.CALCITE_BRICK_WALL.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> SUSPICIOUS_DIRT_ITEM = ITEMS.register("suspicious_dirt",
            () -> new BlockItem(ModBlocks.SUSPICIOUS_DIRT.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> GOD_STATUE_BOTTOM_ITEM = ITEMS.register("god_statue_bottom",
            () -> new BlockItem(ModBlocks.GOD_STATUE_BOTTOM.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> GOD_STATUE_TOP_ITEM = ITEMS.register("god_statue_top",
            () -> new BlockItem(ModBlocks.GOD_STATUE_TOP.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> WARRIOR_STATUE_BOTTOM_ITEM = ITEMS.register("warrior_statue_bottom",
            () -> new BlockItem(ModBlocks.WARRIOR_STATUE_BOTTOM.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> WARRIOR_STATUE_TOP_ITEM = ITEMS.register("warrior_statue_top",
            () -> new BlockItem(ModBlocks.WARRIOR_STATUE_TOP.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> PRIESTESS_STATUE_BOTTOM_ITEM = ITEMS.register("priestess_statue_bottom",
            () -> new BlockItem(ModBlocks.PRIESTESS_STATUE_BOTTOM.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> PRIESTESS_STATUE_TOP_ITEM = ITEMS.register("priestess_statue_top",
            () -> new BlockItem(ModBlocks.PRIESTESS_STATUE_TOP.get(), new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> SAMURAI_SPAWN_EGG = ITEMS.register("samurai_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SAMURAI, 0x4D1D05, 0xFAADF8, new Item.Properties()));

}

