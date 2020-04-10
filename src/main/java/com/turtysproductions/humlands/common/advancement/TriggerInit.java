package com.turtysproductions.humlands.common.advancement;

import com.turtysproductions.humlands.common.advancement.triggers.FilledVialTrigger;

public class TriggerInit {

	private static FilledVialTrigger register(FilledVialTrigger filledVialTrigger) {
		return filledVialTrigger;
	}

	public static final FilledVialTrigger FILLED_VIAL = register(new FilledVialTrigger());
}
