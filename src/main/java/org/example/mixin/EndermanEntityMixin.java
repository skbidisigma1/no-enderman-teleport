package org.example.mixin;

import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {
    @Inject(method = "teleportRandomly", at = @At("HEAD"), cancellable = true)
    private void blockTeleportRandomly(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "teleportTo(Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    private void blockTeleportToEntity(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }

    @Inject(method = "teleportTo(DDD)Z", at = @At("HEAD"), cancellable = true)
    private void blockTeleportToCoords(double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
