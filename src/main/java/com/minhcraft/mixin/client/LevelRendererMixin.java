package com.minhcraft.mixin.client;

import com.minhcraft.config.ModConfig;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = LevelRenderer.class, priority = 1500)
public abstract class LevelRendererMixin {
	@Shadow private @Nullable ClientLevel level;

	@Inject(
			method = "renderClouds",
			at = @At(
					value = "INVOKE",
					target = "Lcom/mojang/blaze3d/vertex/VertexBuffer;drawWithShader(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/client/renderer/ShaderInstance;)V",
					shift = At.Shift.BEFORE))
	public void fog$whiteClouds(PoseStack poseStack, Matrix4f projectionMatrix, float partialTick, double camX, double camY, double camZ, CallbackInfo ci) {
		if (this.level == null
			|| !(level.effects() instanceof DimensionSpecialEffects.OverworldEffects)
			|| level.dimensionType().hasFixedTime()) {
			return;
		}

		// Force clouds to be white
//		RenderSystem.setShaderFogStart(10000F);

		float color = getCloudColor(this.level.getDayTime() % 24000, this.level.getMoonPhase());
		RenderSystem.setShaderFogColor(color, color, color);
	}

	@Unique
	private static float getCloudColor(long worldTime, int moonPhase) {
		// Define the color values
		float dayColor = 1.0f;
		float nightColor = Mth.lerp(
				getMoonPhaseBlendFactor(moonPhase),
				ModConfig.whitenedCloudFullMoonBrightness,
				ModConfig.whitenedCloudNewMoonBrightness);
		float cloudColor;

		if (worldTime < 10000) {
			// Daytime
			cloudColor = dayColor;
		} else if (worldTime < 11000) {
			// Transition starts just after 5:00 PM but still dayColor
			cloudColor = dayColor;
		} else if (worldTime < 13000) {
			// Blend from dayColor to nightColor
			float t = (float) (worldTime - 11000) / 2000;
			cloudColor = Mth.lerp(t, dayColor, nightColor);
		} else if (worldTime < 22000) {
			// Nighttime
			cloudColor = nightColor;
		} else if (worldTime < 23000) {
			// Blend from nightColor to dayColor
			float t = (float) (worldTime - 22000) / 1000;
			cloudColor = Mth.lerp(t, nightColor, dayColor);
		} else {
			// Constant dayColor from 23000 to 24000 ticks
			cloudColor = dayColor;
		}

		cloudColor = 0F;
		return cloudColor;
	}

	@Unique
	private static float getMoonPhaseBlendFactor(int moonPhase) {
		return switch (moonPhase) {
			case 0    -> 0.0f;  // new moon

			case 1, 7 -> 0.25f; // 1/4 moon
			case 2, 6 -> 0.5f;  // 1/2 moon
			case 3, 5 -> 0.75f; // 3/4 moon
			case 4    ->  1.0f; // full moon

			default -> 1.0f;
		};
	}
}
