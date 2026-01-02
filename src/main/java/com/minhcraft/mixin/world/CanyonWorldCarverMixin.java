package com.minhcraft.mixin.world;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CanyonWorldCarver;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldCarver.class)
public class CanyonWorldCarverMixin {

    @SuppressWarnings("ConstantValue")
    @Inject(method = "getCarveState", at = @At("HEAD"), cancellable = true)
    private void forceAirInsteadOfWater(CarvingContext context, CarverConfiguration config, BlockPos pos, Aquifer aquifer, CallbackInfoReturnable<BlockState> cir) {
        if (!((Object) this instanceof CanyonWorldCarver)) {
            return;
        }

        if (pos.getY() <= config.lavaLevel.resolveY(context)) {
            cir.setReturnValue(Blocks.LAVA.defaultBlockState());
            return;
        }
        cir.setReturnValue(Blocks.AIR.defaultBlockState());
    }
}
