package com.minhcraft.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Stray.class)
public abstract class StrayMixin extends AbstractSkeleton {

    protected StrayMixin(EntityType<? extends AbstractSkeleton> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(
            method = "getArrow",
            at = @At("HEAD"),
            cancellable = true
    )
    // Make strays not shoot slow effect arrows
    private void getArrow(ItemStack arrowStack, float velocity, CallbackInfoReturnable<AbstractArrow> cir) {
        cir.setReturnValue(super.getArrow(arrowStack, velocity));
        cir.cancel();
    }
}
