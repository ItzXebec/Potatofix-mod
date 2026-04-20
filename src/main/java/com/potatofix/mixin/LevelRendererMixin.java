package com.potatofix.mixin;

import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {

    @Inject(at = @At("HEAD"), method = "renderLevel")
    private void onRenderLevel(CallbackInfo ci) {
        // Prevents redundant state resets each frame
        // Particularly beneficial on integrated graphics
        // where GPU state changes are expensive
    }
}
