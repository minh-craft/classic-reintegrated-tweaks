package com.minhcraft.mixin.entity;

import net.minecraft.world.entity.animal.Ocelot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Ocelot.class)
public class OcelotMixin {

    // Set ocelot tame chance -> 1/X
    @ModifyArg(
            method = "mobInteract",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/RandomSource;nextInt(I)I"), index = 0)
    private int injected(int x) {
        return 2;
    }

    // Ocelots don't need to be in a tempted state to be tamed
    @Redirect(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Ocelot$OcelotTemptGoal;isRunning()Z"))
    private boolean injected(Ocelot.OcelotTemptGoal instance) {
        return true;
    }

    // Ocelots don't need to be in a specific distance to be tamed
    @ModifyConstant(method = "mobInteract", constant = @Constant(doubleValue = 9.0))
    private double injected(double constant) {
        return 25.0;
    }

//    // Ocelots won't run away
//    @Inject(
//            method = "reassessTrustingGoals",
//            at = @At("HEAD"),
//            cancellable = true
//    )
//    private void reassessTrustingGoals(CallbackInfo ci) {
//        ci.cancel();
//    }
}
