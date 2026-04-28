package com.potatofix.mixin;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.Queue;

@Mixin(ParticleEngine.class)
public class ParticleEngineMixin {

    @Shadow
    private Queue<Particle> particlesToAdd;

    private static final int MAX_PARTICLES = 2048;

    @Inject(
        method = "add(Lnet/minecraft/client/particle/Particle;)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void onAddParticle(Particle particle, CallbackInfo ci) {
        if (particlesToAdd != null && particlesToAdd.size() >= MAX_PARTICLES) {
            ci.cancel();
        }
    }
}
