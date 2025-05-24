package com.minhcraft.mixin.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ZombieAttackGoal.class)
public class ZombieAttackGoalMixin extends MeleeAttackGoal {

    public ZombieAttackGoalMixin(PathfinderMob mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
        super(mob, speedModifier, followingTargetEvenIfNotSeen);
    }

    @Override
    protected double getAttackReachSqr(LivingEntity attackTarget) {
        return (this.mob.getBbWidth()+0.3) * 2.0F * ((this.mob.getBbWidth()+0.3) * 2.0F) + attackTarget.getBbWidth();
    }
}
