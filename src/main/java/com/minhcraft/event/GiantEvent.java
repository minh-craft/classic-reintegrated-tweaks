package com.minhcraft.event;

import com.minhcraft.config.ModConfig;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.level.Level;

public class GiantEvent {
    public static void onEntityJoin(Level level, Entity entity) {
        if (level.isClientSide) {
            return;
        }

        if (!(entity instanceof Giant giant)) {
            return;
        }

        if (level instanceof ServerLevel serverLevel && serverLevel.getMoonPhase() != 4) {
            giant.discard();
            return;
        }

        giant.getAttribute(Attributes.MAX_HEALTH).setBaseValue(ModConfig.giantMaxHealth);
    }
}
