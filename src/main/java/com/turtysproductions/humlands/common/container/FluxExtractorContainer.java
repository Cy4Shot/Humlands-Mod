package com.turtysproductions.humlands.common.container;

import java.util.Objects;

import com.turtysproductions.humlands.common.container.slot.HumlandsSpecifiedItemSlot;
import com.turtysproductions.humlands.common.tileentities.FluxExtractorTileEntity;
import com.turtysproductions.humlands.core.init.BlockInit;
import com.turtysproductions.humlands.core.init.ContainerTypesInit;
import com.turtysproductions.humlands.core.init.ItemInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FluxExtractorContainer extends Container {
	public FluxExtractorTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;
	public final IIntArray furnaceData;

	public FluxExtractorContainer(ContainerType<?> containerType, int windowId, World world, BlockPos pos,
			PlayerInventory playerInventory, PlayerEntity player, IIntArray fields,
			FluxExtractorTileEntity tileEntity) {

		super(ContainerTypesInit.FLUX_EXTRACTOR_CONTAINER.get(), windowId);
		this.tileEntity = tileEntity;
		this.furnaceData = tileEntity.getFurnaceData();
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		int slotSizePlus2 = 18;
		int startPlayerInvX = 8;
		int startPlayerInvY = 17 * 7 - 35;

		this.addSlot(new HumlandsSpecifiedItemSlot((IInventory) tileEntity, 0, 56, 17, ItemInit.FLUX_CRYSTAL.get()));
		this.addSlot(new HumlandsSpecifiedItemSlot((IInventory) tileEntity, 1, 56, 53, ItemInit.FLUX_VIAL.get()));
		this.addSlot(new FurnaceResultSlot(playerInventory.player, (IInventory) tileEntity, 2, 116, 35));

		// Inventory
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column,
						startPlayerInvX + (column * slotSizePlus2), startPlayerInvY + (row * slotSizePlus2)));
			}
		}
		int hotbarY = startPlayerInvY + (startPlayerInvY / 2) + 16;
		for (int column = 0; column < 9; ++column) {
			this.addSlot(new Slot(playerInventory, column, startPlayerInvX + (column * slotSizePlus2), hotbarY));
		}

		assertIntArraySize(this.furnaceData, 4);
		this.trackIntArray(this.furnaceData);
	}

	public FluxExtractorContainer(ContainerType<?> containerType, int windowId, World world, BlockPos pos,
			PlayerInventory playerInventory, PlayerEntity player, FluxExtractorTileEntity tileentity) {
		this(containerType, windowId, world, pos, playerInventory, player, new IntArray(4), tileentity);
	}

	public FluxExtractorContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory,
			PlayerEntity player) {
		this(ContainerTypesInit.FLUX_EXTRACTOR_CONTAINER.get(), windowId, world, pos, playerInventory, player,
				new IntArray(4), (FluxExtractorTileEntity) world.getTileEntity(pos));
	}

	private static FluxExtractorTileEntity getTileEntity(final PlayerInventory playerInventory,
			final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInvetory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof FluxExtractorTileEntity)
			return (FluxExtractorTileEntity) tileAtPos;
		throw new IllegalStateException("TileEntity is not correct!" + tileAtPos);
	}

	public FluxExtractorContainer(final int windowIn, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(ContainerTypesInit.FLUX_EXTRACTOR_CONTAINER.get(), windowIn, playerInventory.player.world,
				data.readBlockPos(), playerInventory, playerInventory.player, getTileEntity(playerInventory, data));
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.FLUX_EXTRACTOR.get());
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			if (index < 36) {
				if (!this.mergeItemStack(stack1, 15, this.inventorySlots.size(), true))
					return ItemStack.EMPTY;
			} else if (!this.mergeItemStack(stack1, 0, 15, false))
				return ItemStack.EMPTY;
			if (stack1.isEmpty())
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();
		}
		return stack;
	}
}
