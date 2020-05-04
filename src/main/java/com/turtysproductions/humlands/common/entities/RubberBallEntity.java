package com.turtysproductions.humlands.common.entities;

import com.turtysproductions.humlands.core.init.EntityTypesInit;
import com.turtysproductions.humlands.core.init.ItemInit;
import com.turtysproductions.humlands.core.init.ParticleInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class RubberBallEntity extends ProjectileItemEntity {
	public RubberBallEntity(EntityType<? extends RubberBallEntity> entity, World world) {
		super(entity, world);
	}

	public RubberBallEntity(World worldIn, LivingEntity throwerIn) {
		super(EntityTypesInit.RUBBER_BALL_ENTITY.get(), throwerIn, worldIn);
	}

	public RubberBallEntity(World worldIn, double x, double y, double z) {
		super(EntityTypesInit.RUBBER_BALL_ENTITY.get(), x, y, z, worldIn);
	}

	protected Item getDefaultItem() {
		return ItemInit.RUBBER_BALL.get();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@OnlyIn(Dist.CLIENT)
	private IParticleData makeParticle() {
		ItemStack itemstack = this.func_213882_k();
		return (IParticleData) (itemstack.isEmpty() ? ParticleInit.DRIPPING_RUBBER
				: new ItemParticleData(ParticleTypes.ITEM, itemstack));
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			IParticleData iparticledata = this.makeParticle();

			for (int i = 0; i < 8; ++i) {
				this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
			}
		}

	}

	protected void onImpact(RayTraceResult result) {
		if (result.getType() == RayTraceResult.Type.ENTITY) {
			Entity entity = ((EntityRayTraceResult) result).getEntity();
			int i = 6;
			entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) i);
		}

		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
			this.remove();
		}

	}
}
