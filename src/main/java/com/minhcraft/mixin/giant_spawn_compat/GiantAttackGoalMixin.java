package com.minhcraft.mixin.giant_spawn_compat;

import com.minhcraft.config.ModConfig;
import com.natamus.giantspawn_common_fabric.ai.GiantAttackGoal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GiantAttackGoal.class)
public abstract class GiantAttackGoalMixin extends MeleeAttackGoal {
    public GiantAttackGoalMixin(PathfinderMob mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
        super(mob, speedModifier, followingTargetEvenIfNotSeen);
    }

    @Override
    protected double getAttackReachSqr(LivingEntity attackTarget) {
        return (this.mob.getBbWidth()+ModConfig.giantBoundingBoxAttackRangeIncrease)* 2.0F
                * ((this.mob.getBbWidth()+ModConfig.giantBoundingBoxAttackRangeIncrease) * 2.0F)
                + attackTarget.getBbWidth();
    }
}
