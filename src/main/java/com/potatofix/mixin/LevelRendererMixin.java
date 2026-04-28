package com.potatofix.mixin;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightTexture.class)
public class LevelRendererMixin {

    private long lastLightmapUpdate = 0;
    private static final long LIGHTMAP_UPDATE_INTERVAL_MS = 50;

    @Inject(method = "updateLightTexture", at = @At("HEAD"), cancellable = true)
    private void onUpdateLightTexture(float partialTick, CallbackInfo ci) {
        long now = System.currentTimeMillis();
        if (now - lastLightmapUpdate < LIGHTMAP_UPDATE_INTERVAL_MS) {
            ci.cancel();
            return;
        }
        lastLightmapUpdate = now;
    }
}
