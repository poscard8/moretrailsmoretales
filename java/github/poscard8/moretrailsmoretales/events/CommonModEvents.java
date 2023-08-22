package github.poscard8.moretrailsmoretales.events;

import github.poscard8.moretrailsmoretales.MoreTrailsMoreTales;
import github.poscard8.moretrailsmoretales.custom.entity.Samurai;
import github.poscard8.moretrailsmoretales.init.ModEntities;
import github.poscard8.moretrailsmoretales.init.ModPottery;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = MoreTrailsMoreTales.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CommonModEvents {

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SAMURAI.get(), Samurai.createAttributes().build());
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) { ModPottery.init(); }

}
