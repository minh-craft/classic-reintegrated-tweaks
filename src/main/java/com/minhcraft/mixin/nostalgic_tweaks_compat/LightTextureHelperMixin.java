package com.minhcraft.mixin.nostalgic_tweaks_compat;

import mod.adrenix.nostalgic.helper.candy.light.LightTextureHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightTextureHelper.class)
public class LightTextureHelperMixin {

//    // Make NT think round robin is disabled in this method
//    @Redirect(
//            method = "getSkylightSubtracted",
//            at = @At(value = "INVOKE", target = "Lmod/adrenix/nostalgic/tweak/factory/TweakFlag;get()Ljava/lang/Object;", ordinal = 0))
//    private static Object roundRobinRelightSettingOverride$getSkylightSubtracted(TweakFlag instance) {
//        return false;
//    }

//    // Make NT think round robin is disabled in this method
//    @Redirect(
//            method = "getLightmapBrightness",
//            at = @At(value = "INVOKE", target = "Lmod/adrenix/nostalgic/tweak/factory/TweakFlag;get()Ljava/lang/Object;", ordinal = 0),
//            remap = false)
//    private static Object roundRobinRelightSettingOverride$getLightmapBrightness(TweakFlag instance) {
//        return false;
//    }

//    @ModifyVariable(method = "setGrayscaleTexture", at = @At("STORE"), ordinal = 0)
//    private static double overrideGammaSetting$setGrayscaleTexture(double x) {
//        return x + 1000;
//    }
//
//    @ModifyVariable(method = "getLightmapBrightness", at = @At("STORE"), ordinal = 0, remap = false)
//    private static double overrideGammaSetting$getLightmapBrightness(double x) {
//        return x + 1000;
//    }

//    @ModifyConstant(method = "getSkylightSubtracted", constant = @Constant(floatValue = 0.5F))
//    private static float injected(float constant) {
//        return 0.2F;
//    }

//    // Override minimum sky light level
//    // Higher values = brighter night time
//    // Affects Nostalgic Tweak's old lighting color setting
//    @ModifyConstant(method = "getSkylightSubtracted", constant = @Constant(floatValue = 4.0F))
//    private static float overrideMinimumSkyLightLevel(float constant) {
//        return 6.0F; // TODO make this configurable
//    }

//    @Inject(method = "getSkylightSubtracted", at = @At("HEAD"), cancellable = true)
//    private static void overrideGetSkylightSubtracted(ClientLevel level, CallbackInfoReturnable<Integer> cir) {
//        int skyDarken = (int)( ( 1 - level.getSkyDarken(1.0F)) * 9.0f);
//        cir.setReturnValue(skyDarken);
//        cir.cancel();
//    }
}
