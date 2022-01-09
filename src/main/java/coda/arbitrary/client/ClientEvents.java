package coda.arbitrary.client;

import coda.arbitrary.Arbitrary;
import coda.arbitrary.client.render.AcornCapArmorRenderer;
import coda.arbitrary.client.render.BellOfSuspensionRenderer;
import coda.arbitrary.common.items.AcornCapArmorItem;
import coda.arbitrary.registry.ArbitraryBlockEntities;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.finsandtails.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = Arbitrary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        BlockEntityRenderers.register(ArbitraryBlockEntities.BELL_OF_SUSPENSION.get(), BellOfSuspensionRenderer::new);

        ForgeHooksClient.registerLayerDefinition(BellOfSuspensionRenderer.MODEL_LAYER, BellOfSuspensionRenderer::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenders(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(AcornCapArmorItem.class, new AcornCapArmorRenderer());
    }
}
