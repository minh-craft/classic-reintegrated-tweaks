package com.minhcraft.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RottenLeather extends Item {
    public RottenLeather(Properties properties) {
        super(properties);
    }

//    @Override
//    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
//        // default white text
//        tooltipComponents.add(Component.translatable("item.classic-reintegrated-tweaks.rotten_leather.tooltip").withStyle(ChatFormatting.GRAY));
//        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
//    }
}
