package github.poscard8.moretrailsmoretales.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import github.poscard8.moretrailsmoretales.custom.entity.CustomBrushableBlockEntity;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;


public class CustomBrushableBlockRenderer implements BlockEntityRenderer<CustomBrushableBlockEntity> {
    private final ItemRenderer itemRenderer;

    public CustomBrushableBlockRenderer(BlockEntityRendererProvider.Context context) { this.itemRenderer = context.getItemRenderer(); }

    public void render(CustomBrushableBlockEntity Blockentity, float f, PoseStack poseStack, MultiBufferSource src, int a, int b) {
        if (Blockentity.getLevel() != null) {
            int i = Blockentity.getBlockState().getValue(BlockStateProperties.DUSTED);
            if (i > 0) {
                Direction direction = Blockentity.getHitDirection();
                if (direction != null) {
                ItemStack itemstack = Blockentity.getItem();
                    if (!itemstack.isEmpty()) {
                        poseStack.pushPose();
                        poseStack.translate(0.0F, 0.5F, 0.0F);
                        float[] afloat = this.getTranslation(direction, i);
                        poseStack.translate(afloat[0], afloat[1], afloat[2]);
                        poseStack.mulPose(Axis.YP.rotationDegrees(75.0F));
                        boolean flag = direction == Direction.EAST || direction == Direction.WEST;
                        poseStack.mulPose(Axis.YP.rotationDegrees((float)((flag ? 90 : 0) + 11)));
                        poseStack.scale(0.5F, 0.5F, 0.5F);
                        int j = LevelRenderer.getLightColor(Blockentity.getLevel(), Blockentity.getBlockState(),
                            Blockentity.getBlockPos().relative(direction));
                        this.itemRenderer.renderStatic(itemstack, ItemDisplayContext.FIXED, j, OverlayTexture.NO_OVERLAY,
                            poseStack, src, Blockentity.getLevel(), 0);
                        poseStack.popPose();
                        }
                    }
                }
            }
        }

        public final float[] getTranslation(Direction direction, int dustedLevel) {
            float[] fs = new float[]{0.5F, 0.0F, 0.5F};
            float f = (float)dustedLevel / 10.0F * 0.75F;
            switch (direction) {
                case EAST:
                    fs[0] = 0.73F + f;
                    break;
                case WEST:
                    fs[0] = 0.25F - f;
                    break;
                case UP:
                    fs[1] = 0.25F + f;
                    break;
                case DOWN:
                    fs[1] = -0.23F - f;
                    break;
                case NORTH:
                    fs[2] = 0.25F - f;
                    break;
                case SOUTH:
                    fs[2] = 0.73F + f;
            }
            return fs;
        }

}
