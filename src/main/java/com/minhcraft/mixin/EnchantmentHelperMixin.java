package com.minhcraft.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

    private static int getEnchantmentLevelCumulative(Enchantment enchantment, LivingEntity entity) {
        Iterable<ItemStack> iterable = enchantment.getSlotItems(entity).values();
        if (iterable == null) {
            return 0;
        } else {
            int cumulativeEnchantLevel = 0;

            for (ItemStack itemStack : iterable) {
                cumulativeEnchantLevel += getItemEnchantmentLevel(enchantment, itemStack);
            }

            return cumulativeEnchantLevel;
        }
    }

    @Inject(
            method = "getSneakingSpeedBonus",
            at = @At("HEAD"),
            cancellable = true
    )
    // Allow swift sneak bonus to be cumulative from different equipped armor pieces
    private static void getSneakingSpeedBonus(LivingEntity entity, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(getEnchantmentLevelCumulative(Enchantments.SWIFT_SNEAK, entity) * 0.15F);
        cir.cancel();
    }
}
