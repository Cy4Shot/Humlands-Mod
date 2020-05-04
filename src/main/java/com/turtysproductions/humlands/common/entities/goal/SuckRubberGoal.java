package com.turtysproductions.humlands.common.entities.goal;

import java.util.EnumSet;
import java.util.function.Predicate;

import com.turtysproductions.humlands.common.entities.Humahog;
import com.turtysproductions.humlands.core.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SuckRubberGoal extends Goal
{
	private static final Predicate<BlockState> IS_RUBBER_WOOD_LOG_STREAMING_RUBBER = BlockStateMatcher.forBlock(BlockInit.RUBBER_STREAMING_RUBBER_WOOD_LOG.get());
	   //private final MobEntity rubberSuckerEntity;
	   private final World entityWorld;
	   private int suckingRubberTimer = 0;
	   private Humahog humahog;
	   
	   

	   public SuckRubberGoal(Humahog humahogIn) {
	      this.humahog = humahogIn;
	      this.entityWorld = humahog.world;
	      this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
	   }

	   
	   public boolean shouldExecute() {
	      if (this.humahog.getRNG().nextInt(this.humahog.isChild() ? 50 : 1000) != 0) 
	      {
	         return false;
	      } 
	      else
	      {
	         BlockPos blockpos = new BlockPos(this.humahog);
	         if (IS_RUBBER_WOOD_LOG_STREAMING_RUBBER.test(this.entityWorld.getBlockState(blockpos))) 
	         {
	            return true;
	         } 
	         else 
	         {
	            return this.entityWorld.getBlockState(blockpos.south()).getBlock() == BlockInit.RUBBER_STREAMING_RUBBER_WOOD_LOG.get();
	         }
	      }
	   }

	   public void startExecuting() 
	   {
	      this.suckingRubberTimer = 40;
	      this.entityWorld.setEntityState(this.humahog, (byte)10);
	      this.humahog.getNavigator().clearPath();
	   }

	   public void resetTask() 
	   {
	      this.suckingRubberTimer = 0;
	   }


	   public boolean shouldContinueExecuting() 
	   {
	      return this.suckingRubberTimer > 0;
	   }


	   public int getSuckingRubberTimer() 
	   {
	      return this.suckingRubberTimer;
	   }


	   public void tick() 
	   {
	      this.suckingRubberTimer = Math.max(0, this.suckingRubberTimer - 1);
	      if (this.suckingRubberTimer == 4) 
	      {
	         BlockPos blockpos = new BlockPos(this.humahog);
	         if (IS_RUBBER_WOOD_LOG_STREAMING_RUBBER.test(this.entityWorld.getBlockState(blockpos))) 
	         {
	            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.humahog)) 
	            {
	               this.entityWorld.destroyBlock(blockpos, false);
	            }

	         
	         } 
	         else 
	         {
	            BlockPos blockpos1 = blockpos.south();
	            if (this.entityWorld.getBlockState(blockpos1).getBlock() == BlockInit.RUBBER_STREAMING_RUBBER_WOOD_LOG.get()) 
	            {
	               if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.humahog)) 
	               {
	                  this.entityWorld.playEvent(2001, blockpos1, Block.getStateId(BlockInit.RUBBER_STREAMING_RUBBER_WOOD_LOG.get().getDefaultState()));
	                  this.entityWorld.setBlockState(blockpos1, BlockInit.RUBBER_WOOD_LOG.get().getDefaultState(), 2);
	                  humahog.setSucked(true);
	                  
	                  
	               }

	               
	            }
	         }

	      }
	   }
}
