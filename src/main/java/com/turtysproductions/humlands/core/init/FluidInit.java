package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.fluids.FluidFlux;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {

	public static final FluidFlux FLUIDFLUX_FLOWING_FLUX = null;
	public static final FluidFlux FLUIDFLUX_FLUX = null;

	public static class Tags {
		public static final Tag<Fluid> FLUX = new FluidTags.Wrapper(
				new ResourceLocation(HumlandsMod.MOD_ID, "flux_tag"));
	}

	public static final String MODID = "humlands";

	public static final ResourceLocation FLUX_STILL = new ResourceLocation("humlands:blocks/flux_still");
	public static final ResourceLocation FLUX_FLOWING_L = new ResourceLocation("humlands:blocks/flux_flowing");

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MODID);
	public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, MODID);

	public static RegistryObject<FlowingFluid> FLUX_FLUID = FLUIDS.register("flux_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.flux_fluid_properties));
	public static RegistryObject<FlowingFluid> FLUX_FLOWING = FLUIDS.register("flux_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.flux_fluid_properties));

	public static RegistryObject<FlowingFluidBlock> FLUX_BLOCK = BLOCKS.register("flux_block",
			() -> new FlowingFluidBlock(FLUX_FLUID, Block.Properties.create(Material.WATER).doesNotBlockMovement()
					.hardnessAndResistance(100.0F).noDrops()));

	public static final ForgeFlowingFluid.Properties flux_fluid_properties = new ForgeFlowingFluid.Properties(
			FLUX_FLUID, FLUX_FLOWING, FluidAttributes.builder(FLUX_STILL, FLUX_FLOWING_L)).bucket(ItemInit.FULL_VIAL)
					.block(FLUX_BLOCK);
}
