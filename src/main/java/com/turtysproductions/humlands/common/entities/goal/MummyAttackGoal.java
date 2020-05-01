package com.turtysproductions.humlands.common.entities.goal;

import com.turtysproductions.humlands.common.entities.Mummy;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class MummyAttackGoal extends MeleeAttackGoal {
	private final Mummy mummy;
	private int raiseArmTicks;

	public MummyAttackGoal(Mummy mummyIn, double speedIn, boolean longMemoryIn) {
		super(mummyIn, speedIn, longMemoryIn);
		this.mummy = mummyIn;
	}

	public void startExecuting() {
		super.startExecuting();
		this.raiseArmTicks = 0;
	}

	public void resetTask() {
		super.resetTask();
		this.mummy.setAggroed(false);
	}

	public void tick() {
		super.tick();
		++this.raiseArmTicks;
		if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
			this.mummy.setAggroed(true);
		} else {
			this.mummy.setAggroed(false);
		}

	}
}