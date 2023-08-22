package github.poscard8.moretrailsmoretales.mixins;

import github.poscard8.moretrailsmoretales.init.ModPottery;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(DecoratedPotPatterns.class)
public abstract class DecoratedPotPatternsMixin implements ItemsToPotsAccessor {

    @Inject( method = "getResourceKey", at = @At("TAIL") )
    private static ResourceKey<String> addResourceKeyGetter(Item item, CallbackInfoReturnable ci) {
        if (ModPottery.CUSTOM_SHERD_TO_POT_TEXTURE.containsKey(item)) { return ModPottery.CUSTOM_SHERD_TO_POT_TEXTURE.get(item); }
        else { return ItemsToPotsAccessor.get().get(item); }
    }

    @Inject( method = "bootstrap", at = @At("TAIL") )
    private static void addBootstrap(Registry registry, CallbackInfoReturnable ci) {

        Registry.register(registry, ModPottery.IDEA, "idea_pottery_pattern");
        Registry.register(registry, ModPottery.LIGHTNING, "lightning_pottery_pattern");
        Registry.register(registry, ModPottery.WARRIOR, "warrior_pottery_pattern");
    }


}