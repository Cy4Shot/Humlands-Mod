package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.tileentities.FluxExtractorTileEntity;
import com.turtysproductions.humlands.common.tileentities.TimeCapsuleTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, HumlandsMod.MOD_ID);

	public static final RegistryObject<TileEntityType<TimeCapsuleTileEntity>> TIME_CAPSULE_TILE_ENTITY = TILE_ENTITY_TYPES
			.register("time_capsule_tile_entity", () -> TileEntityType.Builder
					.create(TimeCapsuleTileEntity::new, BlockInit.TIME_CAPSULE.get()).build(null));
	
	public static final RegistryObject<TileEntityType<FluxExtractorTileEntity>> FLUX_EXTRACTOR_TILE_ENTITY = TILE_ENTITY_TYPES
			.register("flux_extractor_tile_entity", () -> TileEntityType.Builder
					.create(FluxExtractorTileEntity::new, BlockInit.FLUX_EXTRACTOR.get()).build(null));
}
