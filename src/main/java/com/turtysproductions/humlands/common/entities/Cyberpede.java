package com.turtysproductions.humlands.common.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class Cyberpede extends AbstractChestedHorseEntity

{
	private static final DataParameter<Boolean> STORAGE_MODULE_EQUIPPED = EntityDataManager.createKey(Cyberpede.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> FIRE_RESISTANCE_MODULE_EQUIPPED = EntityDataManager.createKey(Cyberpede.class,
			DataSerializers.BOOLEAN);
	
	
	public net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;
	public Inventory cyberpedeChest;

	public Cyberpede(EntityType<? extends AbstractChestedHorseEntity> type, World worldIn) 
	{
		super(type, worldIn);
		
	}
	
	@Override
	public double getMountedYOffset() {
		
		return 0.7f;
	}
	
	@Override
	public boolean canBeLeashedTo(PlayerEntity player) {
		return true;
	}

	@Override
	protected boolean canBeRidden(Entity entityIn) {
		return true;
	}

	@Override
	protected void registerGoals() 
	{
		super.registerGoals();
		
	}
	
	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3f);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		
		
	}
	
	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(STORAGE_MODULE_EQUIPPED, false);
		this.dataManager.register(FIRE_RESISTANCE_MODULE_EQUIPPED, false);
	}
	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) 
	{
		return false;
	}
	
	public void setStorageModuleEquipped(boolean storageModuleEquipped) {
		this.dataManager.set(STORAGE_MODULE_EQUIPPED, storageModuleEquipped);
	}

	public boolean isStorageModuleEquipped() {
		return this.dataManager.get(STORAGE_MODULE_EQUIPPED);
	}

	public void setFireResistanceModuleEquipped(boolean fireRestistanceModuleEquipped) {
		this.dataManager.set(FIRE_RESISTANCE_MODULE_EQUIPPED, fireRestistanceModuleEquipped);
	}

	public boolean isFireResistanceModuleEquipped() {
		return this.dataManager.get(FIRE_RESISTANCE_MODULE_EQUIPPED);
	}
	
	
	
	         
	
	}
	
	

