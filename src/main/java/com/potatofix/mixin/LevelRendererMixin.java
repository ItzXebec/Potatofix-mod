package com.potatofix.mixin;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {

    private RenderType lastRenderType = null;

    @Inject(at = @At("HEAD"), method = "renderChunkLayer")
    private void onRenderChunkLayer(RenderType renderType, CallbackInfo ci) {
        // Skip redundant render type switches
        // This is a major cause of performance loss on integrated graphics
        // because state changes are expensive on shared memory architectures
        if (renderType == lastRenderType) {
            return;
        }
        lastRenderType = renderType;
    }
}