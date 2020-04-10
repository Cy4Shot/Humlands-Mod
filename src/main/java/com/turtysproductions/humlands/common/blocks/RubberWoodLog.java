package com.turtysproductions.humlands.common.blocks;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class RubberWoodLog extends LogBlock {

	public RubberWoodLog(MaterialColor verticalColorIn, Properties properties) {
		super(verticalColorIn, properties);
	}

	public static final ItemTags.Wrapper AXE_TAG = new ItemTags.Wrapper(
			new ResourceLocation(HumlandsMod.MOD_ID, "axes"));

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		ItemStack stack = player.getHeldItemMainhand();
		Item item = stack.getItem();

		boolean isInTag = AXE_TAG.contains(item);
		if (isInTag) {
			worldIn.getWorld().setBlockState(pos, BlockInit.STRIPPED_RUBBER_WOOD_LOG.get().getDefaultState());
			stack.damageItem(1, player, (onBroken) -> {
				onBroken.sendBreakAnimation(player.getActiveHand());

			});
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}
}
