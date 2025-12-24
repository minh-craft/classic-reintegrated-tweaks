package com.minhcraft.mixin.entity;

import com.minhcraft.config.ModConfig;
import net.minecraft.world.entity.animal.goat.Goat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Goat.class)
public abstract class GoatMixin {

    @ModifyConstant(
            method = "finalizeSpawn",
            constant = @Constant(doubleValue = 0.02)
    )
    private double modifyScreamingGoatChance(double constant) {

        return ModConfig.screamingGoatChance;
    }
}
