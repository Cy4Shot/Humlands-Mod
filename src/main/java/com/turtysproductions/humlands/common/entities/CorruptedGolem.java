package com.turtysproductions.humlands.common.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class CorruptedGolem extends MonsterEntity{

	public CorruptedGolem(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		
	}
	
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setCreateFog(true).setDarkenSky(false);
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
	protected void registerAttributes() {
		
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(0.5D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.2f);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
	}
	
	@Override
	protected void registerGoals() {
		
		super.registerGoals();
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
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

}
