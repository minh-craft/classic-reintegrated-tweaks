package com.minhcraft.mixin.nostalgic_tweaks_compat;

import mod.adrenix.nostalgic.helper.candy.light.NostalgicDataLayer;
import mod.adrenix.nostalgic.tweak.factory.TweakFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NostalgicDataLayer.class)
public class NostalgicDataLayerMixin {

//    // Make NT think round robin is disabled in this method
//    @Redirect(
//            method = "getLightValue",
//            at = @At(value = "INVOKE", target = "Lmod/adrenix/nostalgic/tweak/factory/TweakFlag;get()Ljava/lang/Object;", ordinal = 1))
//    private static Object roundRobinRelightSettingOverride(TweakFlag instance) {
//        return false;
//    }
}
