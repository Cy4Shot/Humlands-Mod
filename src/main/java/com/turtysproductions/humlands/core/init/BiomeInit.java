package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.world.biomes.FarHumlandsBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	
	protected static final SurfaceBuilderConfig FAR_HUMLANDS_SURFACE = new SurfaceBuilderConfig(
			Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(),
	Blocks.CLAY.getDefaultState());

	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
			HumlandsMod.MOD_ID);

	public static final RegistryObject<Biome> FAR_HUMLANDS = BIOMES.register("far_humlands",
			() -> new FarHumlandsBiome(new Biome.Builder()
					.surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT,
							FAR_HUMLANDS_SURFACE))
					.precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(0.125F).scale(0.05F)
					.temperature(1000.8F).downfall(0.4F).waterColor(4159204).waterFogColor(329011)
					.parent((String) null)));

	public static final BiomeDictionary.Type HUMLANDS = BiomeDictionary.Type.getType("HUMLANDS");

	public static void addBiomeTypes() {

		BiomeDictionary.addTypes(FAR_HUMLANDS.get(), HUMLANDS, BiomeDictionary.Type.HILLS);
	}
}
