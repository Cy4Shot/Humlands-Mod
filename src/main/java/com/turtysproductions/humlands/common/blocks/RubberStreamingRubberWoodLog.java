package com.turtysproductions.humlands.common.blocks;

import java.util.Random;

import com.turtysproductions.humlands.core.init.ParticleInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RubberStreamingRubberWoodLog extends LogBlock {

	public RubberStreamingRubberWoodLog(MaterialColor verticalColorIn, Properties properties) {
		super(verticalColorIn, properties);
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (worldIn.isRemote) {
			double d0 = (double) pos.getX() + 0.5D;
			double d1 = (double) pos.getY() + 0.6D;
			double d2 = (double) pos.getZ() + 1.0D;

			double d3 = (double) pos.getX() + 0.4D;
			double d4 = (double) pos.getY() + 0.5D;
			double d5 = (double) pos.getZ() - 0.1D;

			double d6 = (double) pos.getX() + 1.0D;
			double d7 = (double) pos.getY() + 0.4D;
			double d8 = (double) pos.getZ() + 0.5D;

			double d9 = (double) pos.getX() - 0.1D;
			double d10 = (double) pos.getY() + 0.6D;
			double d11 = (double) pos.getZ() + 0.5D;

			ClientWorld client = (ClientWorld) worldIn;

			client.addParticle(ParticleInit.DRIPPING_RUBBER.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
			client.addParticle(ParticleInit.DRIPPING_RUBBER.get(), d3, d4, d5, 0.0D, 0.0D, 0.0D);
			client.addParticle(ParticleInit.DRIPPING_RUBBER.get(), d6, d7, d8, 0.0D, 0.0D, 0.0D);
			client.addParticle(ParticleInit.DRIPPING_RUBBER.get(), d9, d10, d11, 0.0D, 0.0D, 0.0D);

		}
	}
}
