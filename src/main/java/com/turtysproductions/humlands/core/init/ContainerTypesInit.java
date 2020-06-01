package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.container.FluxExtractorContainer;
import com.turtysproductions.humlands.common.container.TimeCapsuleContainer;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
			ForgeRegistries.CONTAINERS, HumlandsMod.MOD_ID);

	public static final RegistryObject<ContainerType<TimeCapsuleContainer>> TIME_CAPSULE_CONTAINER = CONTAINER_TYPES
			.register("time_capsule", () -> IForgeContainerType.create(TimeCapsuleContainer::new));

	@SuppressWarnings("resource")
	public static final RegistryObject<ContainerType<FluxExtractorContainer>> FLUX_EXTRACTOR_CONTAINER = CONTAINER_TYPES
			.register("flux_extractor", () -> IForgeContainerType.create((windowId, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				return new FluxExtractorContainer(windowId, Minecraft.getInstance().world, pos, inv,
						Minecraft.getInstance().player);
			}));
}
