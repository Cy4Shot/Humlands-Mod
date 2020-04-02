package com.turtysproductions.humlands.core.world.biomes;

import com.turtysproductions.humlands.core.world.feature.ModBiomeFeatures;

import net.minecraft.world.biome.Biome;

public class RubberWoodForestBiome extends Biome {

	public RubberWoodForestBiome(Builder biomeBuilder) 
	{
	        //The higher the number, the rarer the feature will be
		super(biomeBuilder);
		ModBiomeFeatures.addPonds(this, 70);
		ModBiomeFeatures.addRubberTrees(this, 40);
		ModBiomeFeatures.addLumberMills(this, 200);
                
          
          
           
	   } 
	    //Selects sky color, returns the hex color
	    @Override
	    public int getSkyColor() 
	    {
	    return 0xaa9aee;
	    }
	    
	}
}
