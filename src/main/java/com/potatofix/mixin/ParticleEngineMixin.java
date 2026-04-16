package com.potatofix.mixin;

import net.minecraft.client.particle.ParticleEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleEngine.class)
public class ParticleEngineMixin {

    private static final int MAX_PARTICLES_LOW_END = 2048;
    private int particleCount = 0;

    @Inject(at = @At("HEAD"), method = "tick")
    private void onTick(CallbackInfo ci) {
        // Reset particle count tracker every tick
        particleCount = 0;
    }

    @Inject(at = @At("HEAD"), method = "add(Lnet/minecraft/client/particle/Particle;)V", cancellable = true)
    private void onAddParticle(CallbackInfo ci) {
        // Cap particles on low end hardware to prevent
        // particle explosion lag spikes common on iGPUs
        if (particleCount >= MAX_PARTICLES_LOW_END) {
            ci.cancel();
            return;
        }
        particleCount++;
    }
}