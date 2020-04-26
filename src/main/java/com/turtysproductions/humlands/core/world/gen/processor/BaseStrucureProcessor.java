package com.turtysproductions.humlands.core.world.gen.processor;

import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.Template.BlockInfo;

public class BaseStrucureProcessor extends StructureProcessor {

	private final BlockState blockstate;

	public BaseStrucureProcessor(BlockState blockstate) {
		this.blockstate = blockstate;
	}
	
	@Override
	public BlockInfo process(IWorldReader worldReaderIn, BlockPos pos, BlockInfo p_215194_3_, BlockInfo blockInfo,
			PlacementSettings placementSettingsIn) {
		return blockInfo.state.getBlock().equals(Blocks.AIR) ? new BlockInfo(pos, blockstate, null) : blockInfo;
	}

	@Override
	protected IStructureProcessorType getType() {
		return IStructureProcessorType.NOP;
	}

	@Override
	protected <T> Dynamic<T> serialize0(DynamicOps<T> ops) {
		return new Dynamic<>(ops, BlockState.serialize(ops, blockstate).getValue());
	}

}
