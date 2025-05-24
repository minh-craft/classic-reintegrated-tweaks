package com.minhcraft.mixin.entity;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.world.entity.monster.Spider$SpiderAttackGoal")
public class SpiderAttackGoalMixin {
    @Inject(
            method = "getAttackReachSqr",
            at = @At("RETURN"),
            cancellable = true
    )
    // Increase
    private void crt$injectGetAttackReachSqr(LivingEntity attackTarget, CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(cir.getReturnValue()+1.0f);
    }
}
