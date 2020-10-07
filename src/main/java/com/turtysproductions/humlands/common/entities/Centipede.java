package com.turtysproductions.humlands.common.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class Centipede extends CreatureEntity 
{
	
	public int chargeAttackTimer = 0;

	public Centipede(EntityType<? extends CreatureEntity> type, World worldIn) 
	{
		
		super(type, worldIn);
	}
	
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS)).setCreateFog(true).setDarkenSky(true);
	public void readAdditional(CompoundNBT compound) {
	      super.readAdditional(compound);
	      if (this.hasCustomName()) {
	         this.bossInfo.setName(this.getDisplayName());
	      }

	   }

	   public void setCustomName(@Nullable ITextComponent name) 
	   {
	      super.setCustomName(name);
	      this.bossInfo.setName(this.getDisplayName());
	   }

	@Override
	protected void registerGoals() 
	{
		  this.goalSelector.addGoal(6, new Centipede.ChargeAttackGoal(this));
	      this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
	      this.goalSelector.addGoal(4, new Centipede.AttackGoal(this));
	      this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	      this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
	      this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	      this.targetSelector.addGoal(2, new Centipede.TargetGoal<>(this, PlayerEntity.class));
	      this.targetSelector.addGoal(3, new Centipede.TargetGoal<>(this, IronGolemEntity.class));
	}
	
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.3F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
	}
	
	@Override
	protected void updateAITasks() {
		
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
	
	public void addTrackingPlayer(ServerPlayerEntity player) {
	      super.addTrackingPlayer(player);
	      this.bossInfo.addPlayer(player);
	   }
	public void removeTrackingPlayer(ServerPlayerEntity player) {
	      super.removeTrackingPlayer(player);
	      this.bossInfo.removePlayer(player);
	   }
	
	static class AttackGoal extends MeleeAttackGoal 
	{
	      public AttackGoal(Centipede centipede) 
	      {
	         super(centipede, 1.0D, true);
	      }
	}
	
	static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> 
	{
	      public TargetGoal(Centipede centipede, Class<T> classTarget) 
	      {
	         super(centipede, classTarget, true);
	      }
	}
	
	static class ChargeAttackGoal extends MeleeAttackGoal
	{

		private Centipede centipede;
		
		public ChargeAttackGoal(Centipede creature)
		{
			super(creature, 1.0D, true);
			centipede = creature;
		}
		
		@Override
		public void startExecuting() 
		{
			centipede.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.0f);
			centipede.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(10.0f);
			centipede.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15.0f);
			centipede.chargeAttackTimer = 100;
		}	
		
		public void tick() {
			super.tick();
			if (centipede.chargeAttackTimer > 0) {
				centipede.chargeAttackTimer--;
				if (centipede.chargeAttackTimer == 0) {
					centipede.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.3F);
					centipede.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
					centipede.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
					

				}
			}
		}
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) 
	{
		return 0.5F;
	}
	
	@Override
	public boolean isNonBoss() 
	{
		return false;
	}
	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) 
	{
		
		return false;
	}
	
	
}
