package github.poscard8.moretrailsmoretales.events;


import github.poscard8.moretrailsmoretales.MoreTrailsMoreTales;
import github.poscard8.moretrailsmoretales.client.renderer.CustomBrushableBlockRenderer;
import github.poscard8.moretrailsmoretales.client.renderer.SamuraiRenderer;
import github.poscard8.moretrailsmoretales.custom.CustomModelLayers;
import github.poscard8.moretrailsmoretales.init.ModEntities;
import net.minecraft.client.model.IllagerModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreTrailsMoreTales.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SAMURAI.get(), SamuraiRenderer::new);
        event.registerBlockEntityRenderer(ModEntities.SUS_DIRT_BLOCK_ENTITY.get(), CustomBrushableBlockRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CustomModelLayers.SAMURAI, IllagerModel::createBodyLayer);
    }
}
