package com.minhcraft.mixin.entity;

import com.minhcraft.config.ModConfig;
import net.minecraft.world.entity.animal.AbstractFish;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(AbstractFish.class)
public abstract class AbstractFishMixin {

    @ModifyConstant(method = "registerGoals", constant = @Constant(floatValue = 8.0F))
    private float modifyPlayerAvoidMaxDistance(float constant) {

        return ModConfig.fishAvoidMaxDistance;
    }

    @ModifyConstant(method = "registerGoals", constant = @Constant(doubleValue = 1.6))
    private double modifyWalkSpeedModifier(double constant) {

        return ModConfig.fishAvoidWalkSpeedMultiplier;
    }

    @ModifyConstant(method = "registerGoals", constant = @Constant(doubleValue = 1.4))
    private double modifySprintSpeedModifier(double constant) {

        return ModConfig.fishAvoidSprintSpeedMultiplier;
    }
}
