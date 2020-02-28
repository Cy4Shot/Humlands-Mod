package com.turtysproductions.humlands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.turtysproductions.humlands.init.BlockInit;
import com.turtysproductions.humlands.item.HumlandsTab;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("humlands")
public class HumlandsMod {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "humlands";
	public static String DIMENSION_PROFILE = "default";
	public static int DIMENSION_ID = 753;

	public HumlandsMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		bus.addListener(this::enqueueIMC);
		bus.addListener(this::processIMC);
		bus.addListener(this::doClientStuff);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	private void doClientStuff(final FMLClientSetupEvent event) {

	}

	private void enqueueIMC(final InterModEnqueueEvent event) {

	}

	private void processIMC(final InterModProcessEvent event) {

	}

	@Mod.EventBusSubscriber(modid = HumlandsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
    	public static void onRegisterItems(final RegistryEvent.Register<Item> event) 
    	{
    		final IForgeRegistry<Item> registry = event.getRegistry();
    		// Automatically register BlockItems for all our Blocks
    		BlockInit.BLOCKS.getEntries().stream()
    				.map(RegistryObject::get)
    				// You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
    				// .filter(block -> needsItemBlock(block))
    				// Register the BlockItem for the block
    				.forEach(block -> {
    					// Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
    					final Item.Properties properties = new Item.Properties().group(HumlandsTab.HUMLANDS);
    					// Create the new BlockItem with the block and it's properties
    					final BlockItem blockItem = new BlockItem(block, properties);
    					// Set the new BlockItem's registry name to the block's registry name
    					blockItem.setRegistryName(block.getRegistryName());
    					// Register the BlockItem
    					registry.register(blockItem);
    				});
    		LOGGER.debug("Registered BlockItems");
    	}
	}
}
