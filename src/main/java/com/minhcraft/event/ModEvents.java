package com.minhcraft.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class ModEvents {
    public static void init() {
        ServerEntityEvents.ENTITY_LOAD.register((Entity entity, ServerLevel world) -> {
            GiantEvent.onEntityJoin(world, entity);
        });
    }
}
