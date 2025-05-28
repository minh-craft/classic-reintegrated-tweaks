package com.minhcraft.mixin.entity;

import com.minhcraft.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Giant.class)
public class GiantMixin extends Monster {

    protected GiantMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GIANT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.GIANT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GIANT_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.2F, 0.7F);
    }
}
