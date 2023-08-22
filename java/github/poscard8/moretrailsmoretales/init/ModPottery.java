package github.poscard8.moretrailsmoretales.init;


import github.poscard8.moretrailsmoretales.MoreTrailsMoreTales;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.Map;


public class ModPottery {
    public static Map<Item, ResourceKey<String>> CUSTOM_SHERD_TO_POT_TEXTURE;

    public static final ResourceKey<String> IDEA = ResourceKey.create(Registries.DECORATED_POT_PATTERNS,
            new ResourceLocation(MoreTrailsMoreTales.MODID, "idea_pottery_pattern"));

    public static final ResourceKey<String> LIGHTNING = ResourceKey.create(Registries.DECORATED_POT_PATTERNS,
            new ResourceLocation(MoreTrailsMoreTales.MODID, "lightning_pottery_pattern"));

    public static final ResourceKey<String> WARRIOR = ResourceKey.create(Registries.DECORATED_POT_PATTERNS,
            new ResourceLocation(MoreTrailsMoreTales.MODID, "warrior_pottery_pattern"));

    public static void init() {
        CUSTOM_SHERD_TO_POT_TEXTURE = Map.of(ModItems.IDEA_POTTERY_SHERD.get(), IDEA,
                ModItems.LIGHTNING_POTTERY_SHERD.get(), LIGHTNING, ModItems.WARRIOR_POTTERY_SHERD.get(), WARRIOR);
    }


}
