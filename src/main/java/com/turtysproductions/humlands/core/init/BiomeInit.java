package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.world.biomes.DirtyHumlandsBiome;
import com.turtysproductions.humlands.core.world.biomes.FarHumlandsBiome;
import com.turtysproductions.humlands.core.world.biomes.builders.DirtyHumlandsSurfaceBuilder;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

	protected static final SurfaceBuilderConfig FAR_HUMLANDS_SURFACE = new SurfaceBuilderConfig(
			Blocks.RED_SAND.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), Blocks.CLAY.getDefaultState());

	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
			HumlandsMod.MOD_ID);

	public static final RegistryObject<Biome> FAR_HUMLANDS = BIOMES.register("far_humlands",
			() -> new FarHumlandsBiome(new Biome.Builder()
					.surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT,
							FAR_HUMLANDS_SURFACE))
					.precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(0.125F).scale(0.05F)
					.temperature(1000.8F).downfall(0.4F).waterColor(4159204).waterFogColor(329011)
					.parent((String) null)));

	public static final RegistryObject<Biome> DIRTY_HUMLANDS = BIOMES
			.register("dirty_humlands",
					() -> new DirtyHumlandsBiome(
							new Biome.Builder()
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("dirty_humlands_surface",
															new DirtyHumlandsSurfaceBuilder(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(0.125F)
									.scale(0.05F).temperature(1000.8F).downfall(0.4F).waterColor(4159204)
									.waterFogColor(329011).parent((String) null)));

	public static final BiomeDictionary.Type HUMLANDS = BiomeDictionary.Type.getType("HUMLANDS");

	public static void addBiomeTypes() {

		BiomeDictionary.addTypes(FAR_HUMLANDS.get(), HUMLANDS, BiomeDictionary.Type.HILLS);
		BiomeDictionary.addTypes(DIRTY_HUMLANDS.get(), HUMLANDS, BiomeDictionary.Type.HILLS);
	}

	@SuppressWarnings("unchecked")
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}
}
