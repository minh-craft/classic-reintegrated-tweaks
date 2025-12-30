package com.minhcraft.mixin.entity;

import com.minhcraft.config.ModConfig;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ThrownEnderpearl.class)
public abstract class ThrownEnderpearlMixin {

    // set endermite spawn chance to 0
    @ModifyConstant(
            method = "onHit",
            constant = @Constant(floatValue = 0.05F )
    )
    private float crt$setEndermiteChanceToZero(float constant) {
        return 0.0F;
    }

    // Modify Enderpearl teleport self damage
    @ModifyConstant(
            method = "onHit",
            constant = @Constant(floatValue = 5.0F)
    )
    private float crt$modifyEnderpearlDamage(float constant) {
        return ModConfig.enderpearlTeleportDamage;
    }
}
