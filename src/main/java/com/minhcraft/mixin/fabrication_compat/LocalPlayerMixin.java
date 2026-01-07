package com.minhcraft.mixin.fabrication_compat;

import com.minhcraft.config.ModConfig;
import com.unascribed.fabrication.interfaces.SetCrawling;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin {

    @Inject(method = "aiStep", at = @At("TAIL"))
    private void crawlToSwim(CallbackInfo ci) {
        if (!ModConfig.crawlKeyTriggersSwimming) return;

        LocalPlayer self = (LocalPlayer) (Object) this;
        if (!(self instanceof SetCrawling crawlable)) return;

        if (crawlable.fabrication$isCrawling() && self.isInWater()) {
            self.setSprinting(true);
        }
    }
}
