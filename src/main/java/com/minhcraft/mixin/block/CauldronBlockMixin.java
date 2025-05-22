package com.minhcraft.mixin.block;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.CauldronBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(CauldronBlock.class)
public class CauldronBlockMixin {
    @ModifyVariable(
            method = "shouldHandlePrecipitation",
            at = @At("HEAD"),
            argsOnly = true
    )
    // change precipitation to none if it's snowing to disable powder snow generation in cauldrons
    private static Biome.Precipitation modifyPrecipitation(Biome.Precipitation value) {
        if (value == Biome.Precipitation.SNOW) {
            return Biome.Precipitation.NONE;
        }
        return value;
    }
}
