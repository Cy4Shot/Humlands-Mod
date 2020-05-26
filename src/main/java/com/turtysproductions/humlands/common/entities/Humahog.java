package com.turtysproductions.humlands.common.entities;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.entities.goal.SuckRubberGoal;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Humahog extends GolemEntity implements IRangedAttackMob {
	private static final DataParameter<Boolean> RUBBER_SUCKED = EntityDataManager.createKey(Humahog.class,
			DataSerializers.BOOLEAN);

	private SuckRubberGoal suckRubberGoal = new SuckRubberGoal(this);
	private int timer = 0;

	public Humahog(EntityType<? extends GolemEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(5.0D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.20f);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}

	@Override
	protected void registerGoals() {

		super.registerGoals();
		/*
		 * if (this.isSucked() == false) { this.goalSelector.addGoal(1, new
		 * SuckRubberGoal(this)); // this.targetSelector.addGoal(2, new
		 * MeleeAttackGoal(this, (double)0.20f, // false)); this.goalSelector.addGoal(3,
		 * new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		 * this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this,
		 * PlayerEntity.class, true)); this.targetSelector.addGoal(5, new
		 * NearestAttackableTargetGoal<>(this, Humadillo.class, true));
		 * 
		 * }
		 * 
		 * if (this.isSucked() == true) {
		 * 
		 * this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0f));
		 * this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D,
		 * 1.0f)); this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class,
		 * 6.0f)); this.targetSelector.addGoal(1, new
		 * NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));}
		 */
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0f));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 1.0f));
		this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0f));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(RUBBER_SUCKED, false);
	}

	public void setSucked(boolean rubberSucked) {
		this.dataManager.set(RUBBER_SUCKED, rubberSucked);
	}

	public boolean isSucked() {
		return this.dataManager.get(RUBBER_SUCKED);
	}

	@Override
	protected void updateAITasks() {
		this.timer = this.suckRubberGoal.getSuckingRubberTimer();
		super.updateAITasks();
	}

	@Override
	public void livingTick() {
		if (this.world.isRemote) {
			this.timer = Math.max(0, this.timer - 1);
		}
		super.livingTick();
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 10) {
			this.timer = 40;
		} else {
			super.handleStatusUpdate(id);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public float getHeadRotationPointY(float p_70894_1_) {
		if (this.timer <= 0) {
			return 0.0F;
		} else if (this.timer >= 4 && this.timer <= 36) {
			return 1.0F;
		} else {
			return this.timer < 4 ? ((float) this.timer - p_70894_1_) / 4.0F
					: -((float) (this.timer - 40) - p_70894_1_) / 4.0F;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public float getHeadRotationAngleX(float p_70890_1_) {
		if (this.timer > 4 && this.timer <= 36) {
			float f = ((float) (this.timer - 4) - p_70890_1_) / 32.0F;
			return ((float) Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
		} else {
			return this.timer > 0 ? ((float) Math.PI / 5F) : this.rotationPitch * ((float) Math.PI / 180F);
		}
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 0.7F;
	}

	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
		HumlandsMod.LOGGER.debug("shoot");
		RubberBallEntity rubberball = new RubberBallEntity(this.world, this);
		double d0 = target.getPosYEye() - (double) 1.1F;
		double d1 = target.getPosX() - this.getPosX();
		double d2 = d0 - rubberball.getPosY();
		double d3 = target.getPosZ() - this.getPosZ();
		float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
		rubberball.shoot(d1, d2 + (double) f, d3, 1.6F, 12.0F);
		this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.addEntity(rubberball);
	}

}
