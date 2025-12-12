package com.minhcraft.mixin.arrow_module;

import com.minhcraft.config.ModConfig;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CrossbowItem.class)
public class CrossbowItemMixin {

    // Override shooting power - default is 3.15
    @Inject(
            method = "getShootingPower",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void overrideShootingPower(ItemStack crossbowStack, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(ModConfig.crossbowShootingPower);
        cir.cancel();
    }

    // Override charge duration - default is 25
    @Inject(
            method = "getChargeDuration",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void overrideChargeDuration(ItemStack crossbowStack, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(ModConfig.crossbowChargeDuration);
        cir.cancel();
    }
}
