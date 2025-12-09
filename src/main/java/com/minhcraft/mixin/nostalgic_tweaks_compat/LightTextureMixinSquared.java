package com.minhcraft.mixin.nostalgic_tweaks_compat;

import com.bawnorton.mixinsquared.TargetHandler;
import mod.adrenix.nostalgic.mixin.tweak.candy.world_lighting.LightTextureMixin;
import mod.adrenix.nostalgic.tweak.factory.TweakFlag;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = LightTexture.class, priority = 1500)
public abstract class LightTextureMixinSquared {

//    // Make NT think old light color setting is disabled in this method
//    @TargetHandler(
//            mixin="mod.adrenix.nostalgic.mixin.tweak.candy.world_lighting.LightTextureMixin",
//            name="nt_world_lighting$setLightmapIndexes"
//    )
//    @Redirect(
//            method = "@MixinSquared:Handler",
//            at = @At(
//                    value = "INVOKE",
//                    target = "Lmod/adrenix/nostalgic/tweak/factory/TweakFlag;get()Ljava/lang/Object;",
//                    ordinal = 1),
//            remap = false)
//    private static Object oldLightColorSettingOverride$nt_world_lighting$setLightmapIndexes(TweakFlag instance) {
//        return false;
//    }

//    // Make NT think old light color setting is disabled in this method
//    @TargetHandler(
//            mixin="mod.adrenix.nostalgic.mixin.tweak.candy.world_lighting.LightTextureMixin",
//            name="nt_world_lighting$modifyGetBrightness"
//    )
//    @Redirect(
//            method = "@MixinSquared:Handler",
//            at = @At(
//                    value = "INVOKE",
//                    target = "Lmod/adrenix/nostalgic/tweak/factory/TweakFlag;get()Ljava/lang/Object;",
//                    ordinal = 0),
//            remap = false)
//    private static Object oldLightColorSettingOverride$nt_world_lighting$modifyGetBrightness(TweakFlag instance) {
//        return false;
//    }

//    // Make NT think old light color setting is disabled in this method
//    @TargetHandler(
//            mixin="mod.adrenix.nostalgic.mixin.tweak.candy.world_lighting.LightTextureMixin",
//            name="nt_world_lighting$onBeforeLightmapUpload"
//    )
//    @Redirect(
//            method = "@MixinSquared:Handler",
//            at = @At(
//                    value = "INVOKE",
//                    target = "Lmod/adrenix/nostalgic/tweak/factory/TweakFlag;get()Ljava/lang/Object;",
//                    ordinal = 1),
//            remap = false)
//    private static Object oldLightColorSettingOverride$nt_world_lighting$onBeforeLightmapUpload(TweakFlag instance) {
//        return false;
//    }
}
