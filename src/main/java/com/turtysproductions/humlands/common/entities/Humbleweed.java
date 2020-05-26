package com.turtysproductions.humlands.common.entities;

import java.util.Random;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class Humbleweed extends AmbientEntity {
	private double nextBounce;
	private static double gfs;

	public Humbleweed(EntityType<? extends AmbientEntity> type, World world) {
		super(type, world);
		nextBounce = 0;
		gfs = 0.1d;
	}

	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		this.setMotion(((new Random()).nextFloat() * 2) - 1, this.getMotion().y, ((new Random()).nextFloat() * 2) - 1);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	public void livingTick() {
		super.livingTick();
		if (!this.onGround)
			this.setMotion(this.getMotion().x, this.getMotion().y - gfs, this.getMotion().z);
		if (this.getMotion().y < 0.0D)
			this.setMotion(this.getMotion().mul(1.0D, 0.8D, 1.0D));
		if (nextBounce > 0) {
			this.setMotion(this.getMotion().x, Math.sqrt(nextBounce) / Math.PI, this.getMotion().z);
			nextBounce = 0;
		}

	}

	@Override
	public boolean onLivingFall(float distance, float damageMultiplier) {
		nextBounce = Math.abs(distance) > 1 ? Math.abs(distance) : 0;
		return net.minecraftforge.common.ForgeHooks.onLivingFall(this, distance, damageMultiplier) == null ? false
				: true;
	}

	@Override
	public boolean isInvulnerableTo(DamageSource source) {
		return super.isInvulnerableTo(source) || source.equals(DamageSource.FALL);
	}
}
