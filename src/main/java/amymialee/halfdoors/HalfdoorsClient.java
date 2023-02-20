package amymialee.halfdoors;

import amymialee.halfdoors.screens.DoorcutterScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class HalfdoorsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.IRON_HALFDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.OAK_HALFDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.SPRUCE_HALFDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.BIRCH_HALFDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.JUNGLE_HALFDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.ACACIA_HALFDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.DARK_OAK_HALFDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.CRIMSON_HALFDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.WARPED_HALFDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Halfdoors.DOORCUTTER, RenderLayer.getCutout());
        HandledScreens.register(Halfdoors.DOOR_CUTTER_SCREEN_HANDLER, DoorcutterScreen::new);

        FabricLoader.getInstance().getModContainer(Halfdoors.MOD_ID).ifPresent(modContainer -> {
            ResourceManagerHelper.registerBuiltinResourcePack(Halfdoors.id("flatdoorcutters"), modContainer, ResourcePackActivationType.NORMAL);
            ResourceManagerHelper.registerBuiltinResourcePack(Halfdoors.id("slowerdoorcutters"), modContainer, ResourcePackActivationType.NORMAL);
        });
    }
}