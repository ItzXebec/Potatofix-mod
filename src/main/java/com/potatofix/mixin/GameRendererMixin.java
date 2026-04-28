package com.potatofix.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class GameRendererMixin {

    private static final double MAX_ENTITY_RENDER_DISTANCE = 48.0;

    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void onShouldRender(double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        Entity self = (Entity)(Object)this;
        if (self instanceof Player) return;

        Minecraft client = Minecraft.getInstance();
        if (client.player == null) return;

        double dx = client.player.getX() - self.getX();
        double dy = client.player.getY() - self.getY();
        double dz = client.player.getZ() - self.getZ();
        double distSq = dx*dx + dy*dy + dz*dz;

        if (distSq > MAX_ENTITY_RENDER_DISTANCE * MAX_ENTITY_RENDER_DISTANCE) {
            cir.setReturnValue(false);
        }
    }
}
