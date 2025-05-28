package com.minhcraft.register;

import com.minhcraft.ClassicReintegratedTweaks;
import com.minhcraft.item.RottenLeather;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item ROTTEN_LEATHER = Registry.register(
            BuiltInRegistries.ITEM,
            ClassicReintegratedTweaks.id("rotten_leather"),
            new RottenLeather(new Item.Properties()));

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(content -> {
            content.accept(ROTTEN_LEATHER);
        });
    }
}
