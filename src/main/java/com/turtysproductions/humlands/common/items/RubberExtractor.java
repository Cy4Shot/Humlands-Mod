package com.turtysproductions.humlands.objects.items;
 
import com.turtysproductions.humlands.init.BlockInit;
import com.turtysproductions.humlands.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
 
public class RubberExtractor extends Item
{
 
   
 
 
    public RubberExtractor(Properties properties)
    {
        super(properties);
       
    }
   
    @SuppressWarnings("resource")
    @Override
    public ActionResultType onItemUse(ItemUseContext context)
    {

        if(context.getWorld().getBlockState(context.getPos()).getBlock() == BlockInit.RUBBER_STREAMING_RUBBER_WOOD_LOG.get()) {
            for(ItemStack stack : context.getPlayer().inventory.mainInventory) 
            {
                if(stack.isEmpty()) 
                {
                    context.getPlayer().addItemStackToInventory(new ItemStack(ItemInit.RUBBER.get()));
                   
                                      
                   context.getItem().damageItem(100, context.getPlayer(), (onBroken) -> 
                   {
                   	onBroken.sendBreakAnimation(context.getPlayer().getActiveHand());
                
                   });
                   BlockPos pos = context.getPos();                          
				   context.getWorld().setBlockState(pos, BlockInit.RUBBER_WOOD_LOG.get().getDefaultState());
                   return ActionResultType.SUCCESS;
                   
                
                }
                
            }      
            
        }
        return ActionResultType.FAIL;
           
    }
    
   
     
}
	

