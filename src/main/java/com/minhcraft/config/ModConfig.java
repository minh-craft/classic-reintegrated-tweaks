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

    @Entry(isSlider = true, min=0d, max=1d, precision = 100)
    public static double swordRangeIncrease = 0.5d;

    @Entry
    public static boolean disableStraySlowArrows = true;

}
