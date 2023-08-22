package github.poscard8.moretrailsmoretales.init;

import github.poscard8.moretrailsmoretales.MoreTrailsMoreTales;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = MoreTrailsMoreTales.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreTrailsMoreTales.MODID);

    public static final RegistryObject<CreativeModeTab> MY_TAB = TABS.register("moretrailsmoretales",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.moretrailsmoretales"))
                    .icon(ModItems.WISDOM_TEMPLATE.get()::getDefaultInstance)
                    .displayItems((displayParams, output) -> {
                        output.accept(ModItems.STONE_BASE_ITEM.get());
                        output.accept(ModItems.STONE_PILLAR_ITEM.get());
                        output.accept(ModItems.ANDESITE_BASE_ITEM.get());
                        output.accept(ModItems.ANDESITE_PILLAR_ITEM.get());
                        output.accept(ModItems.GRANITE_BASE_ITEM.get());
                        output.accept(ModItems.GRANITE_PILLAR_ITEM.get());
                        output.accept(ModItems.DIORITE_BASE_ITEM.get());
                        output.accept(ModItems.DIORITE_PILLAR_ITEM.get());
                        output.accept(ModItems.CALCITE_BRICKS_ITEM.get());
                        output.accept(ModItems.CALCITE_BRICK_STAIRS_ITEM.get());
                        output.accept(ModItems.CALCITE_BRICK_SLAB_ITEM.get());
                        output.accept(ModItems.CALCITE_BRICK_WALL_ITEM.get());
                        output.accept(ModItems.CALCITE_BASE_ITEM.get());
                        output.accept(ModItems.CALCITE_PILLAR_ITEM.get());
                        output.accept(ModItems.GOD_STATUE_BOTTOM_ITEM.get());
                        output.accept(ModItems.GOD_STATUE_TOP_ITEM.get());
                        output.accept(ModItems.WARRIOR_STATUE_BOTTOM_ITEM.get());
                        output.accept(ModItems.WARRIOR_STATUE_TOP_ITEM.get());
                        output.accept(ModItems.PRIESTESS_STATUE_BOTTOM_ITEM.get());
                        output.accept(ModItems.PRIESTESS_STATUE_TOP_ITEM.get());
                        output.accept(ModItems.HONOR_TEMPLATE.get());
                        output.accept(ModItems.WISDOM_TEMPLATE.get());
                        output.accept(ModItems.IDEA_POTTERY_SHERD.get());
                        output.accept(ModItems.LIGHTNING_POTTERY_SHERD.get());
                        output.accept(ModItems.WARRIOR_POTTERY_SHERD.get());
                        output.accept(ModItems.SUSPICIOUS_DIRT_ITEM.get());
                        output.accept(ModItems.SAMURAI_SPAWN_EGG.get());

                    }).build());


    @SubscribeEvent
    public static void buildExistingTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.getEntries().putAfter(Items.STONE_BUTTON.getDefaultInstance(), ModItems.STONE_PILLAR_ITEM.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.STONE_BUTTON.getDefaultInstance(), ModItems.STONE_BASE_ITEM.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.POLISHED_GRANITE_SLAB.getDefaultInstance(), ModItems.GRANITE_PILLAR_ITEM.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.POLISHED_GRANITE_SLAB.getDefaultInstance(), ModItems.GRANITE_BASE_ITEM.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.POLISHED_DIORITE_SLAB.getDefaultInstance(), ModItems.DIORITE_PILLAR_ITEM.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.POLISHED_DIORITE_SLAB.getDefaultInstance(), ModItems.DIORITE_BASE_ITEM.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.POLISHED_ANDESITE_SLAB.getDefaultInstance(), ModItems.ANDESITE_PILLAR_ITEM.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.POLISHED_ANDESITE_SLAB.getDefaultInstance(), ModItems.ANDESITE_BASE_ITEM.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.getEntries().putAfter(Items.SUSPICIOUS_GRAVEL.getDefaultInstance(), ModItems.SUSPICIOUS_DIRT_ITEM.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(Items.SNORT_POTTERY_SHERD.getDefaultInstance(), ModItems.WARRIOR_POTTERY_SHERD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.SNORT_POTTERY_SHERD.getDefaultInstance(), ModItems.LIGHTNING_POTTERY_SHERD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.SNORT_POTTERY_SHERD.getDefaultInstance(), ModItems.IDEA_POTTERY_SHERD.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE.getDefaultInstance(), ModItems.HONOR_TEMPLATE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE.getDefaultInstance(), ModItems.WISDOM_TEMPLATE.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        } else if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.SAMURAI_SPAWN_EGG.get().getDefaultInstance());
        }

    }

}
