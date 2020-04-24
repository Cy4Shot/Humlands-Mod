package com.turtysproductions.humlands.common.entities;

import javax.annotation.Nullable;

import com.turtysproductions.humlands.core.init.EntityTypesInit;
import com.turtysproductions.humlands.core.init.SoundInit;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Humadillo extends TameableEntity {
	private static final DataParameter<Boolean> CLOSED = EntityDataManager.createKey(Humadillo.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> RIDDEN = EntityDataManager.createKey(Humadillo.class,
			DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.BROWN_MUSHROOM, Items.RED_MUSHROOM);
	private EntitySize size = new EntitySize(1.0f, 1.0f, true);

	public int timer = 0;

	public Humadillo(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void registerGoals() {

		super.registerGoals();

		this.goalSelector.addGoal(1, new Humadillo.AvoidEntityGoal(this, CreeperEntity.class, 24.0F, 1.5D, 1.5D));
		this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 5.0f));

	}

	@Override
	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.3F);
		if (this.isTamed()) {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		} else {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		}
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.20f);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(CLOSED, false);
		this.dataManager.register(RIDDEN, false);
	}

	public void setTamed(boolean tamed) {
		super.setTamed(tamed);
		if (tamed) {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
			this.setHealth(20.0F);
		} else {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		}

		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	// When the timer's over, the humadillo is out of his shell, the timer lasts 20
	// seconds,
	// in which he will have resistance, movement speed set to zero and he will be
	// in his shell.
	@Override
	protected void damageEntity(DamageSource damageSrc, float damageAmount) {

		this.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 400, 1, false, false));
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0f);
		this.setClosed(true);
		timer = 400;
	}

	public void tick() {
		super.tick();
		if (timer > 0) {
			timer--;
			if (timer == 0) {
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20f);
				this.setClosed(false);

			}
		}
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		Humadillo entity = new Humadillo(EntityTypesInit.HUMADILLO.get(), this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		entity.setGlowing(true);
		return entity;

	}

	@Override
	public boolean canBeLeashedTo(PlayerEntity player) {
		return true;
	}

	@Override
	protected boolean canBeRidden(Entity entityIn) {
		return true;
	}

	public void setClosed(boolean closed) {
		this.dataManager.set(CLOSED, closed);
	}

	public boolean isClosed() {
		return this.dataManager.get(CLOSED);
	}

	public void setRidden(boolean ridden) {
		this.dataManager.set(RIDDEN, ridden);
	}

	public boolean isRidden() {
		return this.dataManager.get(RIDDEN);
	}

	// Checks if the player right clicks the Humadillo with a mushroom, and if he
	// does, the entity is tamed and rideable.
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {

		ItemStack stack = player.getHeldItem(hand);
		Item item = stack.getItem();
		if (item == Items.BROWN_MUSHROOM) {
			this.setRidden(true);
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D,
					this.getPosZRandom(1.0D), d0, d1, d2);
			world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D,
					this.getPosZRandom(1.0D), d0, d1, d2);
			return true;
		}

		if (item == Items.RED_MUSHROOM) {
			this.setRidden(true);
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D,
					this.getPosZRandom(1.0D), d0, d1, d2);
			world.addParticle(ParticleTypes.HEART, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D,
					this.getPosZRandom(1.0D), d0, d1, d2);
			return true;
		}

		if (this.isRidden() == true && !this.isBeingRidden()) {
			if (!this.world.isRemote) {
				player.startRiding(this);
				return true;
			}
		}
		return false;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();

		if (entity instanceof PlayerEntity) {
			return true;
		}
		return false;
	}

	// Took the travel method from vanilla so i'm not entirely understanding it.
	public void travel(Vec3d p_213352_1_) {
		if (this.isAlive()) {
			Entity entity = this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
			if (this.isBeingRidden() && this.canBeSteered()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.renderYawOffset = this.rotationYaw;
				this.rotationYawHead = this.rotationYaw;
				this.stepHeight = 1.0F;
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

				if (this.canPassengerSteer()) {
					float f = (float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue() * 0.25f;

					this.setAIMoveSpeed(f);
					super.travel(new Vec3d(0.0D, 0.0D, 1.0D));
					this.newPosRotationIncrements = 0;
				} else {
					this.setMotion(Vec3d.ZERO);
				}

				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.getPosX() - this.prevPosX;
				double d0 = this.getPosZ() - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F) {
					f1 = 1.0F;
				}

				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
			} else {
				this.stepHeight = 0.5F;
				this.jumpMovementFactor = 0.02F;
				super.travel(p_213352_1_);
			}
		}
	}

	// Sets the height at which the player will be when he's riding.
	public double getMountedYOffset() {

		{
			return (double) this.size.height * 0.50D;
		}
	}

	class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.entity.ai.goal.AvoidEntityGoal<T> {
		@SuppressWarnings("unused")
		private final Humadillo humadillo;

		public AvoidEntityGoal(Humadillo humadilloIn, Class<T> p_i47251_3_, float p_i47251_4_, double p_i47251_5_,
				double p_i47251_7_) {
			super(humadilloIn, p_i47251_3_, p_i47251_4_, p_i47251_5_, p_i47251_7_);
			this.humadillo = humadilloIn;
		}
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.HUMADILLO_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.HUMADILLO_HURT.get();
	}

}
