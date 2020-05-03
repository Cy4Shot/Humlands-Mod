package com.turtysproductions.humlands.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Humbleweed extends AmbientEntity {

	public Humbleweed(EntityType<? extends AmbientEntity> type, World world) {
		super(type, world);
	}

	@Override
	public void livingTick() {
		super.livingTick();
		Vec3d vec3d = this.getMotion();
		if (!this.onGround && vec3d.y < 0.0D)
			this.setMotion(vec3d.mul(1.0D, 0.6D, 1.0D));
	}

	@Override
	public boolean onLivingFall(float distance, float damageMultiplier) {
		boolean flag = super.onLivingFall(distance, damageMultiplier);
		if (distance > 1.0f)
			this.setMotion(this.getMotion().getX(), Math.sqrt(distance), this.getMotion().getZ());
		this.setMoveVertical((float) Math.sqrt(distance));
		float f = this.getJumpUpwardsMotion();
		if (this.isPotionActive(Effects.JUMP_BOOST)) {
			f += 0.1F * (float) (this.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1);
		}

		Vec3d vec3d = this.getMotion();
		this.setMotion(vec3d.x, (double) f, vec3d.z);
		if (this.isSprinting()) {
			float f1 = this.rotationYaw * ((float) Math.PI / 180F);
			this.setMotion(this.getMotion().add((double) (-MathHelper.sin(f1) * 0.2F), 0.0D,
					(double) (MathHelper.cos(f1) * 0.2F)));
		}

		this.isAirBorne = true;
		net.minecraftforge.common.ForgeHooks.onLivingJump(this);
		return flag;
	}
}
