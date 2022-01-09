package coda.arbitrary.client.render;

import coda.arbitrary.Arbitrary;
import coda.arbitrary.common.blockentities.BellOfSuspensionBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BellOfSuspensionRenderer implements BlockEntityRenderer<BellOfSuspensionBlockEntity> {
   public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(Arbitrary.MOD_ID, "bell_of_suspension"), "main");
   private final ModelPart bellBody;

   public BellOfSuspensionRenderer(BlockEntityRendererProvider.Context p_173554_) {
      ModelPart modelpart = p_173554_.bakeLayer(ModelLayers.BELL);
      this.bellBody = modelpart.getChild("bell_body");
   }

   public static LayerDefinition createBodyLayer() {
      MeshDefinition meshdefinition = new MeshDefinition();
      PartDefinition partdefinition = meshdefinition.getRoot();
      PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("bell_body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 7.0F, 6.0F), PartPose.offset(8.0F, 12.0F, 8.0F));
      partdefinition1.addOrReplaceChild("bell_base", CubeListBuilder.create().texOffs(0, 13).addBox(4.0F, 4.0F, 4.0F, 8.0F, 2.0F, 8.0F), PartPose.offset(-8.0F, -12.0F, -8.0F));
      return LayerDefinition.create(meshdefinition, 32, 32);
   }

   public void render(BellOfSuspensionBlockEntity be, float p_112234_, PoseStack stack, MultiBufferSource p_112236_, int p_112237_, int p_112238_) {
      float f = (float)be.time + p_112234_;

      stack.translate(0.0, Mth.sin(f * 0.1F) * 0.1F, 0.0);

      VertexConsumer vertexconsumer = p_112236_.getBuffer(RenderType.endPortal());
      this.bellBody.render(stack, vertexconsumer, p_112237_, p_112238_);
   }
}