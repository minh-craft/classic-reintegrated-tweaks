package com.minhcraft.mixin.block;

import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnvilBlock.class)
public class AnvilBlockMixin {
    @Inject(
            method = "damage",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void damage(BlockState state, CallbackInfoReturnable<BlockState> cir) {
        cir.setReturnValue(state);
        cir.cancel();
    }
}
