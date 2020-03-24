package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.world.feature.ModBiomeFeatures;

import net.minecraft.world.biome.Biome;

public class RubberStreamingRubberWoodForestBiome extends Biome 
{
	 
	    public RubberStreamingRubberWoodForestBiome(Builder biomeBuilder) 
	   {
	
          super(biomeBuilder);
          
          ModBiomeFeatures.addRubberStreamingRubberTrees(this);
          

	   } 
}
