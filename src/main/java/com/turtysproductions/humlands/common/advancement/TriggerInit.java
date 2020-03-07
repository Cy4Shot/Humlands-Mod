package com.turtysproductions.humlands.common.advancement;

import java.util.Map;

import com.google.common.collect.Maps;
import com.turtysproductions.humlands.common.advancement.triggers.FilledVialTrigger;

import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.util.ResourceLocation;

public class TriggerInit {
	
	private static FilledVialTrigger register(FilledVialTrigger filledVialTrigger) {
		return filledVialTrigger;
	}

	private static final Map<ResourceLocation, ICriterionTrigger<?>> REGISTRY = Maps.newHashMap();

	public static final FilledVialTrigger FILLED_VIAL = register(new FilledVialTrigger());

}
