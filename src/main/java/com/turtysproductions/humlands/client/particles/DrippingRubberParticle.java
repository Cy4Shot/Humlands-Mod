package com.turtysproductions.humlands.client.particles;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DrippingRubberParticle extends SpriteTexturedParticle {

	public DrippingRubberParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn,
			double ySpeedIn, double speedIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, speedIn);
		float f = this.rand.nextFloat() * 0.1F + 0.2F;
		this.particleRed = f;
		this.particleGreen = f;
		this.particleBlue = f;
		this.setSize(0.04F, 0.04F);
		this.particleScale *= this.rand.nextFloat() * 0.6F + 0.5F;
		this.motionX = 0;
		this.motionZ = 0;
		this.motionY *= 0.02;
		this.maxAge = 20;

	}

	public void tick() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (this.maxAge-- <= 0 || this.particleAlpha <= 0.1F) {
			this.setExpired();
		} else {
			this.move(this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.99D;
			this.motionY *= 0.99D;
			this.motionZ *= 0.99D;
			this.width *= 0.9D;
			this.height *= 3.6D;
			if (this.maxAge > 10) {
				this.particleAlpha *= MathHelper.clamp(particleAlpha, 0.97D, 1.0D) * 0.98;
			}
		}
	}

	@Override
	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	// Particle factory
	@OnlyIn(Dist.CLIENT)
	public static class FACTORY implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public FACTORY(IAnimatedSprite spriteSetIn) {
			this.spriteSet = spriteSetIn;
		}

		public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z,
				double xSpeed, double ySpeed, double zSpeed) {
			DrippingRubberParticle particle = new DrippingRubberParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
			// Color randomizer
			float random = worldIn.rand.nextFloat();
			if (random < 0.25F) {
				particle.setColor((float) 0xFF / 0xFF, (float) 0xFD / 0xFF, (float) 0xE0 / 0xFF);
			} else if (random < 0.7F) {
				particle.setColor((float) 0xFF / 0xFF, (float) 0xFD / 0xFF, (float) 0xE0 / 0xFF);
			} else if (random < 0.85F) {
				particle.setColor((float) 0xFF / 0xFF, (float) 0xFD / 0xFF, (float) 0xE0 / 0xFF);
			} else {
				particle.setColor((float) 0xFF / 0xFF, (float) 0xFD / 0xFF, (float) 0xE0 / 0xFF);
			}

			particle.selectSpriteRandomly(spriteSet);
			particle.setAlphaF(1.0F - worldIn.rand.nextFloat() * 0.1F);
			return particle;
		}
	}
}
