package com.turtysproductions.humlands.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GlintingItem extends Item {
	   public GlintingItem(Item.Properties p_i50045_1_) {
		      super(p_i50045_1_);
		   }
		   public boolean hasEffect(ItemStack stack) {
		      return true;
		   }
		}