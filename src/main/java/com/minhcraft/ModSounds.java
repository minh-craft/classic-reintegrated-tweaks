package com.minhcraft;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {

    public static SoundEvent GIANT_DEATH = register("entity.giant.death");
    public static SoundEvent GIANT_HURT = register("entity.giant.hurt");
    public static SoundEvent GIANT_AMBIENT = register("entity.giant.ambient");

    public static void init() {
    }

    public static SoundEvent register(String name) {
        return Registry.register(
                BuiltInRegistries.SOUND_EVENT,
                ClassicReintegratedTweaks.id(name),
                SoundEvent.createVariableRangeEvent(ClassicReintegratedTweaks.id(name)));
    }
}
