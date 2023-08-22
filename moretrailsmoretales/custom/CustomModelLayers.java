package github.poscard8.moretrailsmoretales.custom;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;

public class CustomModelLayers extends ModelLayers {
    public static final ModelLayerLocation SAMURAI = register("samurai");

    private static ModelLayerLocation register(String p_171296_) {
        ModelLayerLocation modellayerlocation = createLocation(p_171296_, "main");
        return modellayerlocation;
    }

    private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
        return new ModelLayerLocation(new ResourceLocation("moretrailsmoretales", p_171301_), p_171302_);
    }



}
