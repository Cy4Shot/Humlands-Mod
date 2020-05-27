package com.turtysproductions.humlands.common.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class Centipede extends CreatureEntity 
{

	public Centipede(EntityType<? extends CreatureEntity> type, World worldIn) 
	{
		
		super(type, worldIn);
	}

	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		this.targetSelector.addGoal(1, new MeleeAttackGoal(this, 1.0f, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0f));
	}
	
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.4F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
	}
	
	
}
