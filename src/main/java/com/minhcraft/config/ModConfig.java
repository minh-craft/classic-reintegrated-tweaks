package com.minhcraft.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class ModConfig extends MidnightConfig {

    @Entry(isSlider = true, min=20, max=200)
    public static int giantMaxHealth = 45;

    @Entry(isSlider = true, min=0, max=20)
    public static int cakeMaxAbsorptionHearts = 8;

    @Entry(isSlider = true, min=0f, max=1.5f, precision = 100)
    public static float skeletonArrowVelocityDecrease = 0.5f;

    @Entry(isSlider = true, min=-1f, max=1f, precision = 100)
    public static float spiderBoundingBoxAttackRangeIncrease = 0f;

    @Entry(isSlider = true, min=-1f, max=1f, precision = 100)
    public static float caveSpiderBoundingBoxAttackRangeIncrease = 0f;

    @Entry(isSlider = true, min=0f, max=1f, precision = 100)
    public static float zombieBoundingBoxAttackRangeIncrease = 0.3f;

    @Entry(isSlider = true, min=-3f, max=1f, precision = 100)
    public static float giantBoundingBoxAttackRangeIncrease = -1.3f;

    @Entry
    public static boolean giantDespawnInSunlight = true;

    @Entry(isSlider = true, min=1, max=11)
    public static int giantDespawnWhenSkyDarkenLessThan = 11;

    @Entry(isSlider = true, min=0d, max=1d, precision = 100)
    public static double swordRangeIncrease = 0.5d;

    @Entry
    public static boolean disableStraySlowArrows = true;

    @Entry
    public static boolean disableOcelotAvoidingPlayer = false;

    @Entry(isSlider = true, min=0f, max=16f, precision = 10)
    public static float ocelotAvoidMaxDistance = 8.0f;

    @Entry(isSlider = true, min=50, max=5000)
    public static int endGatewayRadius = 96;

    @Entry(isSlider = true, min=0, max=256)
    public static int endGatewayHeight = 75;

    @Entry(isSlider = true, min=0.0F, max=1.0F)
    public static float fullMoonBrightness = 1.0F;

    @Entry(isSlider = true, min=0.0F, max=1.0F)
    public static float threeQuartersMoonBrightness = 0.88F;

    @Entry(isSlider = true, min=0.0F, max=1.0F)
    public static float halfMoonBrightness = 0.75F;

    @Entry(isSlider = true, min=0.0F, max=1.0F)
    public static float oneQuarterMoonBrightness = 0.5F;

    @Entry(isSlider = true, min=0.0F, max=1.0F)
    public static float newMoonBrightness = 0.0F;

    @Entry(isSlider = true, min=0.0F, max=1.0F)
    public static float nightVisionModifier = 0.25F;

    @Entry(isSlider = true, min=0.0F, max=2.0F)
    public static float endDimensionLightMapBrightnessModifier = 0.8F;

    @Entry(isSlider = true, min=0.0F, max=0.2F, precision = 1000)
    public static float trueDarknessMinimumLightLevel = 0.01F;

    @Entry(isSlider = true, min=0, max=11)
    public static int roundRobinMaximumDeductedLightLevel = 11;

    @Entry(isSlider = true, min=1.0F, max=3.0F, precision = 100)
    public static float scaleTrueDarknessGamma = 1.0F;

    @Entry(isSlider = true, min=1.0F, max=10.0F, precision = 100)
    public static float crossbowShootingPower = 3.15F;

    @Entry(isSlider = true, min=10, max=25)
    public static int crossbowChargeDuration = 25;
}
