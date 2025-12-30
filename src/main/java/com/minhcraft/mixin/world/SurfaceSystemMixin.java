package com.minhcraft.mixin.world;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.minhcraft.config.ModConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.BlockColumn;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SurfaceSystem.class)
public abstract class SurfaceSystemMixin {

//    @Final
//    @Shadow
//    private NormalNoise icebergSurfaceNoise;
//
//    @Final
//    @Shadow
//    private NormalNoise icebergPillarNoise;
//
//    @Final
//    @Shadow
//    private NormalNoise icebergPillarRoofNoise;
//
//    @Final
//    @Shadow
//    private int seaLevel;
//
//    @Final
//    @Shadow
//    private PositionalRandomFactory noiseRandom;
//
//    private static final BlockState PACKED_ICE = Blocks.PACKED_ICE.defaultBlockState();
//    private static final BlockState SNOW_BLOCK = Blocks.SNOW_BLOCK.defaultBlockState();


    // Disable giant icebergs from generating in frozen oceans (still generate in deep frozen oceans)
    @ModifyExpressionValue(
            method = "buildSurface",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Holder;is(Lnet/minecraft/resources/ResourceKey;)Z", ordinal = 1)
    )
    private boolean crt$disableFrozenOceanGiantIceberg(boolean original) {
        return ModConfig.disableFrozenOceanGiantIceberg ? false : original;
    }

    // Modify iceberg scaling variable which affects iceberg height
    // Larger values = larger height
    @ModifyConstant(
            method = "frozenOceanExtension",
            constant = @Constant(doubleValue = 1.2)
    )
    private double crt$modifyIcebergScalingVariableOne(double constant) {
        return ModConfig.icebergScalingVariableOne;
    }

    // Modify iceberg scaling variable which affects iceberg height
    // Larger values = larger height
    @ModifyConstant(
            method = "frozenOceanExtension",
            constant = @Constant(doubleValue = 14.0)
    )
    private double crt$modifyIcebergScalingVariableTwo(double constant) {
        return ModConfig.icebergScalingVariableTwo;
    }

//    @Inject(
//            method = "frozenOceanExtension",
//            at = @At("HEAD"),
//            cancellable = true
//    )
//    private void test(int minSurfaceLevel, Biome biome, BlockColumn blockColumn, BlockPos.MutableBlockPos topWaterPos, int x, int z, int height, CallbackInfo ci) {
//        double d = 1.28;
//        double e = Math.min(Math.abs(this.icebergSurfaceNoise.getValue(x, 0.0, z) * 8.25), this.icebergPillarNoise.getValue(x * 1.28, 0.0, z * 1.28) * 15.0);
//        if (!(e <= 1.8)) {
//            double f = 1.17;
//            double g = 1.5;
//            double h = Math.abs(this.icebergPillarRoofNoise.getValue(x * 1.17, 0.0, z * 1.17) * 1.5);
//            double i = Math.min(e * e * 1.4, Math.ceil(h * 40.0) + 18.0);
//            if (biome.shouldMeltFrozenOceanIcebergSlightly(topWaterPos.set(x, 63, z))) {
//                i -= 2.0;
//            }
//
//            double j;
//            if (i > 2.0) {
//                j = this.seaLevel - i - 7.0;
//                i += this.seaLevel;
//            } else {
//                i = 0.0;
//                j = 0.0;
//            }
//
//            double k = i;
//            RandomSource randomSource = this.noiseRandom.at(x, 0, z);
//            int l = 2 + randomSource.nextInt(4);
//            int m = this.seaLevel + 18 + randomSource.nextInt(10);
//            int n = 0;
//
//            for (int o = Math.max(height, (int)i + 1); o >= minSurfaceLevel; o--) {
//                if (blockColumn.getBlock(o).isAir() && o < (int)k && randomSource.nextDouble() > 0.01
//                        || blockColumn.getBlock(o).is(Blocks.WATER) && o > (int)j && o < this.seaLevel && j != 0.0 && randomSource.nextDouble() > 0.15) {
//                    if (n <= l && o > m) {
//                        blockColumn.setBlock(o, SNOW_BLOCK);
//                        n++;
//                    } else {
//                        blockColumn.setBlock(o, PACKED_ICE);
//                    }
//                }
//            }
//        }
//        ci.cancel();
//    }
}
