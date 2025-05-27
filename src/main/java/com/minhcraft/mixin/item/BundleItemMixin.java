package com.minhcraft.mixin.item;

import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BundleItem.class)
public class BundleItemMixin extends Item {

    public BundleItemMixin(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canFitInsideContainerItems() {
        return false;
    }
}
