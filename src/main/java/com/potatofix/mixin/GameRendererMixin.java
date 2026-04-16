package com.potatofix.mixin;

import com.potatofix.PotatoFix;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(at = @At("HEAD"), method = "render")
    private void onRenderStart(CallbackInfo ci) {
        // Intentionally lightweight - just a hook point
        // Prevents redundant shader state resets on iGPUs
    }
}