package com.minhcraft.mixin.entity;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Fox.class)
public abstract class FoxMixin {

    // Disable baby foxes from being spawned
    @Inject(
            method = "finalizeSpawn",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Fox;setVariant(Lnet/minecraft/world/entity/animal/Fox$Type;)V")
    )
    private void test(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData spawnData, CompoundTag dataTag, CallbackInfoReturnable<SpawnGroupData> cir, @Local LocalBooleanRef isBabyFoxRef) {
        isBabyFoxRef.set(false);
    }
}
