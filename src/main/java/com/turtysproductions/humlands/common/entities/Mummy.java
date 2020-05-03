package com.turtysproductions.humlands.common.entities;

import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

import com.turtysproductions.humlands.common.entities.goal.MummyAttackGoal;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.ai.goal.BreakBlockGoal;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class Mummy extends CreatureEntity {

	public Mummy(EntityType<? extends CreatureEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public boolean isChild() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	public static boolean isValidLightLevel(IWorld worldIn, BlockPos pos, Random randomIn) {
		return true;
	}

	public static boolean canMonsterSpawnInLight(EntityType<? extends MonsterEntity> type, IWorld worldIn,
			SpawnReason reason, BlockPos pos, Random randomIn) {
		return worldIn.getDifficulty() != Difficulty.PEACEFUL;
	}

	public static boolean canMonsterSpawn(EntityType<? extends MonsterEntity> type, IWorld worldIn, SpawnReason reason,
			BlockPos pos, Random randomIn) {
		return worldIn.getDifficulty() != Difficulty.PEACEFUL;
	}

	public static boolean func_223332_b(EntityType<Mummy> p_223332_0_, IWorld p_223332_1_, SpawnReason reason,
			BlockPos p_223332_3_, Random p_223332_4_) {
		return p_223332_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	public EntitySize getSize(Pose poseIn) {
		return new EntitySize(1.0f, 2.0f, true);
	}

	@Override
	protected ResourceLocation getLootTable() {
		return super.getLootTable();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return super.getDeathSound();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return super.getHurtSound(damageSourceIn);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return super.getAmbientSound();
	}

	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
		return true;
	}

	protected static final IAttribute SPAWN_REINFORCEMENTS_CHANCE = (new RangedAttribute((IAttribute) null,
			"zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).setDescription("Spawn Reinforcements Chance");
	private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
	private static final AttributeModifier BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID,
			"Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);
	private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.createKey(ZombieEntity.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> VILLAGER_TYPE = EntityDataManager.createKey(ZombieEntity.class,
			DataSerializers.VARINT);
	private static final DataParameter<Boolean> DROWNING = EntityDataManager.createKey(ZombieEntity.class,
			DataSerializers.BOOLEAN);
	private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (p_213697_0_) -> {
		return p_213697_0_ == Difficulty.HARD;
	};
	private final BreakDoorGoal breakDoor = new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE);
	private boolean isBreakDoorsTaskSet;
	private int inWaterTime;
	private int drownedConversionTime;

	protected void registerGoals() {
		this.goalSelector.addGoal(4, new Mummy.AttackTurtleEggGoal(this, 1.0D, 3));
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.goalSelector.addGoal(2, new MummyAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::isBreakDoorsTaskSet));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(ZombiePigmanEntity.class));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, 10, true, false,
				TurtleEntity.TARGET_DRY_BABY));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.23F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		this.getAttributes().registerAttribute(SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(
				this.rand.nextDouble() * net.minecraftforge.common.ForgeConfig.SERVER.zombieBaseSummonChance.get());
	}

	protected void registerData() {
		super.registerData();
		this.getDataManager().register(IS_CHILD, false);
		this.getDataManager().register(VILLAGER_TYPE, 0);
		this.getDataManager().register(DROWNING, false);
	}

	public boolean isDrowning() {
		return this.getDataManager().get(DROWNING);
	}

	public boolean isBreakDoorsTaskSet() {
		return this.isBreakDoorsTaskSet;
	}

	public void setBreakDoorsAItask(boolean enabled) {
		if (this.canBreakDoors()) {
			if (this.isBreakDoorsTaskSet != enabled) {
				this.isBreakDoorsTaskSet = enabled;
				((GroundPathNavigator) this.getNavigator()).setBreakDoors(enabled);
				if (enabled)
					this.goalSelector.addGoal(1, this.breakDoor);
				else
					this.goalSelector.removeGoal(this.breakDoor);
			}
		} else if (this.isBreakDoorsTaskSet) {
			this.goalSelector.removeGoal(this.breakDoor);
			this.isBreakDoorsTaskSet = false;
		}

	}

	protected boolean canBreakDoors() {
		return true;
	}

	protected int getExperiencePoints(PlayerEntity player) {
		if (this.isChild())
			this.experienceValue = (int) ((float) this.experienceValue * 2.5F);
		return super.getExperiencePoints(player);
	}

	public void setChild(boolean childZombie) {
		this.getDataManager().set(IS_CHILD, childZombie);
		if (this.world != null && !this.world.isRemote) {
			IAttributeInstance iattributeinstance = this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
			iattributeinstance.removeModifier(BABY_SPEED_BOOST);
			if (childZombie) {
				iattributeinstance.applyModifier(BABY_SPEED_BOOST);
			}
		}

	}

	public void notifyDataManagerChange(DataParameter<?> key) {
		if (IS_CHILD.equals(key)) {
			this.recalculateSize();
		}

		super.notifyDataManagerChange(key);
	}

	protected boolean shouldDrown() {
		return false;
	}

	public void livingTick() {
		this.updateArmSwingProgress();
		this.func_213623_ec();
		if (this.isAlive()) {
			ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
			if (!itemstack.isEmpty() && itemstack.isDamageable()) {
				itemstack.setDamage(itemstack.getDamage() + this.rand.nextInt(2));
				if (itemstack.getDamage() >= itemstack.getMaxDamage()) {
					this.sendBreakAnimation(EquipmentSlotType.HEAD);
					this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
				}
			}
		}

		super.livingTick();
	}

	private void startDrowning(int p_204704_1_) {
		this.drownedConversionTime = p_204704_1_;
		this.getDataManager().set(DROWNING, true);
	}

	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		Item item = itemstack.getItem();
		if (item instanceof SpawnEggItem && ((SpawnEggItem) item).hasType(itemstack.getTag(), this.getType())) {
			if (!this.world.isRemote) {
				ZombieEntity zombieentity = (ZombieEntity) this.getType().create(this.world);
				if (zombieentity != null) {
					zombieentity.setChild(true);
					zombieentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), 0.0F, 0.0F);
					this.world.addEntity(zombieentity);
					if (itemstack.hasDisplayName()) {
						zombieentity.setCustomName(itemstack.getDisplayName());
					}

					if (!player.abilities.isCreativeMode) {
						itemstack.shrink(1);
					}
				}
			}

			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (super.attackEntityFrom(source, amount)) {
			LivingEntity livingentity = this.getAttackTarget();
			if (livingentity == null && source.getTrueSource() instanceof LivingEntity) {
				livingentity = (LivingEntity) source.getTrueSource();
			}
			return true;
		} else {
			return false;
		}
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = super.attackEntityAsMob(entityIn);
		if (flag) {
			float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
			if (this.getHeldItemMainhand().isEmpty() && this.isBurning() && this.rand.nextFloat() < f * 0.3F) {
				entityIn.setFire(2 * (int) f);
			}
		}

		return flag;
	}

	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_ZOMBIE_STEP;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}

	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
			if (this.rand.nextInt(3) == 0)
				this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SWORD));
			else
				this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
		}

	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		if (this.isChild())
			compound.putBoolean("IsBaby", true);

		compound.putBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
		compound.putInt("InWaterTime", this.isInWater() ? this.inWaterTime : -1);
		compound.putInt("DrownedConversionTime", this.isDrowning() ? this.drownedConversionTime : -1);
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.getBoolean("IsBaby"))
			this.setChild(true);

		this.setBreakDoorsAItask(compound.getBoolean("CanBreakDoors"));
		this.inWaterTime = compound.getInt("InWaterTime");
		if (compound.contains("DrownedConversionTime", 99) && compound.getInt("DrownedConversionTime") > -1)
			this.startDrowning(compound.getInt("DrownedConversionTime"));

	}

	public void onKillEntity(LivingEntity entityLivingIn) {
		super.onKillEntity(entityLivingIn);
		if ((this.world.getDifficulty() == Difficulty.NORMAL || this.world.getDifficulty() == Difficulty.HARD)
				&& entityLivingIn instanceof VillagerEntity) {
			if (this.world.getDifficulty() != Difficulty.HARD && this.rand.nextBoolean()) {
				return;
			}

			VillagerEntity villagerentity = (VillagerEntity) entityLivingIn;
			ZombieVillagerEntity zombievillagerentity = EntityType.ZOMBIE_VILLAGER.create(this.world);
			zombievillagerentity.copyLocationAndAnglesFrom(villagerentity);
			villagerentity.remove();
			zombievillagerentity.onInitialSpawn(this.world,
					this.world.getDifficultyForLocation(new BlockPos(zombievillagerentity)), SpawnReason.CONVERSION,
					new Mummy.GroupData(false), (CompoundNBT) null);
			zombievillagerentity.func_213792_a(villagerentity.getVillagerData());
			zombievillagerentity
					.func_223727_a(villagerentity.func_223722_es().serialize(NBTDynamicOps.INSTANCE).getValue());
			zombievillagerentity.func_213790_g(villagerentity.getOffers().write());
			zombievillagerentity.func_213789_a(villagerentity.getXp());
			zombievillagerentity.setChild(villagerentity.isChild());
			zombievillagerentity.setNoAI(villagerentity.isAIDisabled());
			if (villagerentity.hasCustomName()) {
				zombievillagerentity.setCustomName(villagerentity.getCustomName());
				zombievillagerentity.setCustomNameVisible(villagerentity.isCustomNameVisible());
			}

			if (this.isNoDespawnRequired()) {
				zombievillagerentity.enablePersistence();
			}

			zombievillagerentity.setInvulnerable(this.isInvulnerable());
			this.world.addEntity(zombievillagerentity);
			this.world.playEvent((PlayerEntity) null, 1026, new BlockPos(this), 0);
		}

	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return this.isChild() ? 0.93F : 1.74F;
	}

	protected boolean canEquipItem(ItemStack stack) {
		return stack.getItem() == Items.EGG && this.isChild() && this.isPassenger() ? false : super.canEquipItem(stack);
	}

	protected void applyAttributeBonuses(float difficulty) {
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier(
				"Random spawn bonus", this.rand.nextDouble() * (double) 0.05F, AttributeModifier.Operation.ADDITION));
		double d0 = this.rand.nextDouble() * 1.5D * (double) difficulty;
		if (d0 > 1.0D) {
			this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(
					new AttributeModifier("Random zombie-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
		}

		if (this.rand.nextFloat() < difficulty * 0.05F) {
			this.getAttribute(SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Leader zombie bonus",
					this.rand.nextDouble() * 0.25D + 0.5D, AttributeModifier.Operation.ADDITION));
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH)
					.applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D,
							AttributeModifier.Operation.MULTIPLY_TOTAL));
			this.setBreakDoorsAItask(this.canBreakDoors());
		}

	}

	public double getYOffset() {
		return this.isChild() ? 0.0D : -0.45D;
	}

	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		Entity entity = source.getTrueSource();
		if (entity instanceof CreeperEntity) {
			CreeperEntity creeperentity = (CreeperEntity) entity;
			if (creeperentity.ableToCauseSkullDrop()) {
				creeperentity.incrementDroppedSkulls();
				ItemStack itemstack = this.getSkullDrop();
				if (!itemstack.isEmpty()) {
					this.entityDropItem(itemstack);
				}
			}
		}

	}

	protected ItemStack getSkullDrop() {
		return new ItemStack(Items.ZOMBIE_HEAD);
	}

	class AttackTurtleEggGoal extends BreakBlockGoal {
		AttackTurtleEggGoal(CreatureEntity creatureIn, double speed, int yMax) {
			super(Blocks.TURTLE_EGG, creatureIn, speed, yMax);
		}

		public void playBreakingSound(IWorld worldIn, BlockPos pos) {
			worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ENTITY_ZOMBIE_DESTROY_EGG, SoundCategory.HOSTILE,
					0.5F, 0.9F + Mummy.this.rand.nextFloat() * 0.2F);
		}

		public void playBrokenSound(World worldIn, BlockPos pos) {
			worldIn.playSound((PlayerEntity) null, pos, SoundEvents.ENTITY_TURTLE_EGG_BREAK, SoundCategory.BLOCKS, 0.7F,
					0.9F + worldIn.rand.nextFloat() * 0.2F);
		}

		public double getTargetDistanceSq() {
			return 1.14D;
		}
	}

	public class GroupData implements ILivingEntityData {
		public final boolean isChild;

		private GroupData(boolean isChildIn) {
			this.isChild = isChildIn;
		}
	}

	public SoundCategory getSoundCategory() {
		return SoundCategory.HOSTILE;
	}

	protected void func_213623_ec() {
		float f = this.getBrightness();
		if (f > 0.5F) {
			this.idleTime += 2;
		}

	}

	protected boolean isDespawnPeaceful() {
		return true;
	}

	protected SoundEvent getSwimSound() {
		return SoundEvents.ENTITY_HOSTILE_SWIM;
	}

	protected SoundEvent getSplashSound() {
		return SoundEvents.ENTITY_HOSTILE_SPLASH;
	}

	protected SoundEvent getFallSound(int heightIn) {
		return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
	}

	public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
		return 0.5F;
	}

	protected boolean canDropLoot() {
		return true;
	}

	public boolean isPreventingPlayerRest(PlayerEntity playerIn) {
		return true;
	}
}
