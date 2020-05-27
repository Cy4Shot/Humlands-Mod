package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.core.world.biomes.DirtyHumlandsBiome;
import com.turtysproductions.humlands.core.world.biomes.FarHumlandsBiome;
import com.turtysproductions.humlands.core.world.biomes.RubberWoodForestBiome;
import com.turtysproductions.humlands.core.world.biomes.RuinedLandsBiome;
import com.turtysproductions.humlands.core.world.gen.builder.DirtyHumlandsSurfaceBuilder;
import com.turtysproductions.humlands.core.world.gen.builder.FarHumlandsSurfaceBuilder;
import com.turtysproductions.humlands.core.world.gen.builder.RuinedLandsSurfaceBuilder;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
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
					.surfaceBuilder(
							new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
									register("far_humlands_surface",
											new FarHumlandsSurfaceBuilder(
													SurfaceBuilderConfig::deserialize)),
									new SurfaceBuilderConfig(Blocks.RED_SAND.getDefaultState(),
											Blocks.RED_SAND.getDefaultState(),
											Blocks.RED_SANDSTONE.getDefaultState())))
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
	
	public static final RegistryObject<Biome> RUINED_LANDS = BIOMES
			.register("ruined_lands",
					() -> new RuinedLandsBiome(
							new Biome.Builder()
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("ruined_lands_surface",
															new RuinedLandsSurfaceBuilder(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.SAND.getDefaultState(),
															Blocks.SAND.getDefaultState(),
															Blocks.SANDSTONE.getDefaultState())))
									.precipitation(Biome.RainType.NONE).category(Biome.Category.DESERT).depth(0.125F)
									.scale(0.05F).temperature(1000.8F).downfall(0.4F).waterColor(4159204)
									.waterFogColor(329011).parent((String) null)));

	public static final RegistryObject<Biome> RUBBER_WOOD_FOREST = BIOMES.register("rubber_wood_forest",
			() -> new RubberWoodForestBiome(new Biome.Builder().precipitation(RainType.NONE).scale(0.2f)
					.temperature(1.0f).waterColor(0x3f17ad).waterFogColor(0x3f17ad)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.RUBBER_WOOD_FOREST_GRASS.get().getDefaultState(),
									BlockInit.RUBBER_WOOD_FOREST_DIRT.get().getDefaultState(),
									BlockInit.RUBBER_WOOD_FOREST_DIRT.get().getDefaultState()))
					.category(Category.FOREST).depth(0.125f).downfall(0.0f).parent((String) null)));

	public static final BiomeDictionary.Type HUMLANDS = BiomeDictionary.Type.getType("HUMLANDS");

	public static void addBiomeTypes() {

		BiomeDictionary.addTypes(FAR_HUMLANDS.get(), HUMLANDS, BiomeDictionary.Type.HOT);
		BiomeDictionary.addTypes(DIRTY_HUMLANDS.get(), HUMLANDS, BiomeDictionary.Type.PLAINS);
		BiomeDictionary.addTypes(RUBBER_WOOD_FOREST.get(), HUMLANDS, BiomeDictionary.Type.FOREST);
		BiomeDictionary.addTypes(RUINED_LANDS.get(), HUMLANDS, BiomeDictionary.Type.HOT);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}
}
