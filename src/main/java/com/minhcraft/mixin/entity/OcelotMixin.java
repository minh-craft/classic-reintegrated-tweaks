package com.minhcraft.mixin.entity;

import com.minhcraft.config.ModConfig;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Ocelot.class)
public class OcelotMixin {

    // Set ocelot tame chance -> 1/X
    @ModifyArg(
            method = "mobInteract",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/RandomSource;nextInt(I)I"), index = 0)
    private int injected(int x) {
        return 2;
    }

    // Ocelots don't need to be in a tempted state to be tamed
    @Redirect(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Ocelot$OcelotTemptGoal;isRunning()Z"))
    private boolean injected(Ocelot.OcelotTemptGoal instance) {
        return true;
    }

    // Ocelots don't need to be in a specific distance to be tamed
    @ModifyConstant(method = "mobInteract", constant = @Constant(doubleValue = 9.0))
    private double modifyTameDistance(double constant) {
        return 25.0;
    }

    // Turn ocelot into cat when tamed
    // Copied from https://github.com/Partonetrain/ocelotfix
    // With a fix to prevent multiple cats from spawning from one tamed ocelot (injecting this code before sidedSuccess() instead of putting it at all returns)
    @Inject(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/InteractionResult;sidedSuccess(Z)Lnet/minecraft/world/InteractionResult;"))
    private void ocelotfix_spawnCat(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        Ocelot ocelot = (Ocelot)(Object)this;
        if(ocelot.isTrusting())
        {
            Level level = ocelot.level();

            if (!level.isClientSide){
                Cat cat = (Cat) EntityType.CAT.create((ServerLevel) level);

                cat.tame(player); //this sets owner UUID
                cat.setPos(ocelot.position());

                cat.setOrderedToSit(true);
                cat.level().broadcastEntityEvent(cat, (byte)7);
                cat.setPersistenceRequired();

                cat.finalizeSpawn((ServerLevel) level, level.getCurrentDifficultyAt(ocelot.getOnPos()), MobSpawnType.NATURAL, (SpawnGroupData)null, (CompoundTag)null);

                cat.moveTo(ocelot.getOnPos().above(), ocelot.getYRot(), ocelot.getXRot()); //this is needed to set rotation for some reason. setXRot doesn't work

                ((ServerLevel) level).addFreshEntityWithPassengers(cat);
                ocelot.remove(Entity.RemovalReason.DISCARDED);
            }
        }
    }

    // Ocelots won't run away
    @Inject(
            method = "reassessTrustingGoals",
            at = @At("HEAD"),
            cancellable = true
    )
    private void reassessTrustingGoals(CallbackInfo ci) {
        if (ModConfig.disableOcelotAvoidingPlayer) {
            ci.cancel();
        }
    }

    // adjust ocelot avoid distance
    @ModifyConstant(method = "reassessTrustingGoals", constant = @Constant(floatValue = 16.0f))
    private float modifyAvoidMaxDistance(float constant) {
        return ModConfig.ocelotAvoidMaxDistance;
    }
}
