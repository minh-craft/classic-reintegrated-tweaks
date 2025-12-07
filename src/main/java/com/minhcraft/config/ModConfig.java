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

    @Entry(isSlider = true, min=0f, max=16f, precision = 10)
    public static float fishAvoidMaxDistance = 8.0f;

    @Entry(isSlider = true, min=0.0, max=8.0, precision = 10)
    public static double fishAvoidWalkSpeedMultiplier = 1.6;

    @Entry(isSlider = true, min=0.0, max=8.0, precision = 10)
    public static double fishAvoidSprintSpeedMultiplier = 1.4;

}
