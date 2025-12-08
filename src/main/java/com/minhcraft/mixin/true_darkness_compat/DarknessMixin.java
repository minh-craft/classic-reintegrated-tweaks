package com.minhcraft.mixin.true_darkness_compat;

import com.llamalad7.mixinextras.sugar.Local;
import com.minhcraft.config.ModConfig;
import grondag.darkness.Darkness;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Darkness.class)
public abstract class DarknessMixin {

    @Unique
    private static final float[] CUSTOM_MOON_BRIGHTNESS_BY_PHASE = new float[] {
            ModConfig.fullMoonBrightness,
            ModConfig.threeQuartersMoonBrightness,
            ModConfig.halfMoonBrightness,
            ModConfig.oneQuarterMoonBrightness,
            ModConfig.newMoonBrightness,
            ModConfig.oneQuarterMoonBrightness,
            ModConfig.halfMoonBrightness,
            ModConfig.threeQuartersMoonBrightness
    };

    // Override moon phase darkness setting
    @ModifyArg(method = "skyFactor",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;lerp(FFF)F"),
            index = 1)
    private static float overrideBrightnessPercentage(float brightnessPercentage, @Local(argsOnly = true) Level world) {
        return CUSTOM_MOON_BRIGHTNESS_BY_PHASE[world.getMoonPhase()];
    }
}
