package com.turtysproductions.humlands.common.tileentities;

import com.turtysproductions.humlands.core.init.TileEntityTypesInit;
import com.turtysproductions.humlands.common.blocks.TimeCapsule;
import com.turtysproductions.humlands.common.container.TimeCapsuleContainer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import javax.annotation.Nonnull;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;



public class TimeCapsuleTileEntity extends LockableLootTileEntity
{

	
	private NonNullList<ItemStack> contents = NonNullList.withSize(15, ItemStack.EMPTY);
	protected int numPlayersUsing;
	IItemHandlerModifiable items = createHandler();
	private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);
	
	public TimeCapsuleTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
		
	}
	
	public TimeCapsuleTileEntity()
	{
		this(TileEntityTypesInit.TIME_CAPSULE_TILE_ENTITY.get());
	}
	
	@Override
	public int getSizeInventory() 
	{
		return 15;
	}
	
	@Override
	public NonNullList<ItemStack> getItems() 
	{
		
		return this.contents;
	}
	
	@Override
	public void setItems(NonNullList<ItemStack> itemsIn) 
	{
		this.contents = itemsIn;
	}
	
	@Override
	protected ITextComponent getDefaultName() 
	{
		
		return new TranslationTextComponent("container.time_capsule");
	}
	
	@Override
	protected Container createMenu(int id, PlayerInventory player) 
	{
		return new TimeCapsuleContainer(id, player, this);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) 
	{
	
		super.write(compound);
		if(!this.checkLootAndWrite(compound))
		{
			ItemStackHelper.saveAllItems(compound, this.contents);
		}
		return compound;
	}
	
	@Override
	public void read(CompoundNBT compound) {
		
		super.read(compound);
		this.contents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if(this.checkLootAndRead(compound))
		{
			ItemStackHelper.loadAllItems(compound, this.contents);
		}
	}
	
	@SuppressWarnings("unused")
	private void playSound(SoundEvent sound)
	{
		double dx = (double)this.pos.getX() + 0.5D;
		double dy = (double)this.pos.getY() + 0.5D;
		double dz = (double)this.pos.getZ() + 0.5D;
		this.world.playSound((PlayerEntity)null, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
	}
	
	@Override
	public boolean receiveClientEvent(int id, int type) 
	{
	
		if(id == 1)
		{
			this.numPlayersUsing = type;
			return true;
		} 
		else 
		{
			super.receiveClientEvent(id, type);
		}
		return false;
	}
	
	@Override
	public void openInventory(PlayerEntity player) {
		
		if(!player.isSpectator())
		{
			if(this.numPlayersUsing < 0)
			{
				this.numPlayersUsing = 0;
			}
			++this.numPlayersUsing;
			this.onOpenOrClose();
		}
		
	}
	@Override
	public void closeInventory(PlayerEntity player) {
		
		if(!player.isSpectator())
		{
			--this.numPlayersUsing;
			this.onOpenOrClose();
		}
	}
	
	protected void onOpenOrClose()
	{
		Block block = this.getBlockState().getBlock();
		if(block instanceof TimeCapsule)
		{
			this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
			this.world.notifyNeighbors(this.pos, block);
		}
	}
	
	public static int getPlayersUsing(IBlockReader reader, BlockPos pos)
	{
		BlockState state = reader.getBlockState(pos);
		if(state.hasTileEntity())
		{
			TileEntity tileentity = reader.getTileEntity(pos);
					if(tileentity instanceof TimeCapsuleTileEntity)
					{
						return ((TimeCapsuleTileEntity)tileentity).numPlayersUsing;
					}
		          }
		return 0;
		
	}
	
	
	
	public static void swapContents(TimeCapsuleTileEntity tile1, TimeCapsuleTileEntity tile2)
	{
		NonNullList<ItemStack> list = tile1.getItems();
		tile1.setItems(tile2.getItems());
		tile2.setItems(list);
	}
	
	@Override
	public void updateContainingBlockInfo() {
	
		super.updateContainingBlockInfo();
		if(this.itemHandler !=null)
		{
			this.itemHandler.invalidate();
			this.itemHandler = null;
		}
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
		
		if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return itemHandler.cast();
		}
		return super.getCapability(cap, side);
	}
	
	private IItemHandlerModifiable createHandler()
	{
		return new InvWrapper(this);
	}
	
	@Override
	public void remove() 
	{
		super.remove();
		if(itemHandler != null)
		{
			itemHandler.invalidate();
		}
	}
	
}
