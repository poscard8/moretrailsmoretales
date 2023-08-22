package github.poscard8.moretrailsmoretales.client.renderer;

import github.poscard8.moretrailsmoretales.MoreTrailsMoreTales;
import github.poscard8.moretrailsmoretales.custom.CustomModelLayers;
import github.poscard8.moretrailsmoretales.custom.entity.Samurai;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SamuraiRenderer extends IllagerRenderer<Samurai> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MoreTrailsMoreTales.MODID,
            "textures/entity/samurai/samurai.png");

    public SamuraiRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new IllagerModel<>(ctx.bakeLayer(CustomModelLayers.SAMURAI)), 0.5F);
        this.addLayer(new ItemInHandLayer<>(this, ctx.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(Samurai p_114482_) {
        return TEXTURE;
    }
}
