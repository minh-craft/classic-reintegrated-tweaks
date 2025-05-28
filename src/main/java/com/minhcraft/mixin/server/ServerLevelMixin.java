package com.minhcraft.mixin.server;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
    @ModifyVariable(
            method = "tickChunk",
            at = @At(value = "STORE"),
            ordinal = 1
    )
    // Make bl2 return false in tickChunk so that trap skeleton horses don't spawn
    private boolean injected(boolean value) {
        return false;
    }
}
