package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.items.FluxVial;
import com.turtysproductions.humlands.common.items.GlintingItem;
import com.turtysproductions.humlands.common.items.ModSpawnEgg;
import com.turtysproductions.humlands.common.items.RubberExtractor;
import com.turtysproductions.humlands.core.tab.HumlandsTab;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
			HumlandsMod.MOD_ID);

	public static final RegistryObject<Item> CARBON_TUBE = ITEMS.register("carbon_tube",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> CARBON_SHEET = ITEMS.register("carbon_sheet",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> DIAMOND_ENCRUSTED_BONE = ITEMS.register("diamond_encrusted_bone",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> ENCHANTED_GUNPOWDER = ITEMS.register("enchanted_gunpowder",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> FILTER = ITEMS.register("filter",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> FLUX_VIAL = ITEMS.register("flux_vial",
			() -> new FluxVial(() -> Fluids.EMPTY, new Item.Properties().group(HumlandsTab.HUMLANDS).maxStackSize(1)));

	public static final RegistryObject<Item> FULL_VIAL = ITEMS.register("full_vial", () -> new FluxVial(
			FluidInit.FLUX_FLUID,
			new Item.Properties().containerItem(ItemInit.FLUX_VIAL.get()).maxStackSize(1).group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> GOLD_BONE = ITEMS.register("gold_bone",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> GOLD_WIRE = ITEMS.register("gold_wire",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> DIAMOND_WIRE = ITEMS.register("diamond_wire",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> DIAMOND_PLATE = ITEMS.register("diamond_plate",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> IRON_WIRE = ITEMS.register("iron_wire",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> IRON_BONE = ITEMS.register("iron_bone",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> IRON_MESH = ITEMS.register("iron_mesh",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> FLUX_CRYSTAL = ITEMS.register("flux_crystal",
			() -> new Item(new Item.Properties().maxStackSize(1).group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> MECHANICAL_ARM = ITEMS.register("mechanical_arm",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> POWERED_SIFTER_BODY = ITEMS.register("powered_sifter_body",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> ROYAL_SLIME = ITEMS.register("royal_slime",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> ROYAL_FLAN = ITEMS.register("royal_flan",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS).food(new Food.Builder().hunger(4)
					.saturation(2.0f).effect(new EffectInstance(Effects.SPEED, 600, 3), 1).build())));

	public static final RegistryObject<Item> ROYAL_FLAN_RAW = ITEMS.register("royal_flan_raw",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> SUPER_ROYAL_SLIME = ITEMS.register("super_royal_slime",
			() -> new GlintingItem(new Item.Properties().group(HumlandsTab.HUMLANDS).rarity(Rarity.EPIC)));

	public static final RegistryObject<Item> SUPER_ROYAL_FLAN = ITEMS.register("super_royal_flan",
			() -> new GlintingItem(new Item.Properties().group(HumlandsTab.HUMLANDS).rarity(Rarity.EPIC)
					.food(new Food.Builder().hunger(8).saturation(4.0f)
							.effect(new EffectInstance(Effects.SPEED, 6000, 5), 1)
							.effect(new EffectInstance(Effects.HEALTH_BOOST), 1).build())));

	public static final RegistryObject<Item> WIRECUTTERS = ITEMS.register("wirecutters",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> SUPER_ROYAL_FLAN_RAW = ITEMS.register("super_royal_flan_raw",
			() -> new GlintingItem(new Item.Properties().group(HumlandsTab.HUMLANDS).rarity(Rarity.EPIC)));

	public static final RegistryObject<Item> UNPOWERED_SIFTER_BODY = ITEMS.register("unpowered_sifter_body",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS)));

	public static final RegistryObject<Item> RUBBER_EXTRACTOR = ITEMS.register("rubber_extractor",
			() -> new RubberExtractor(
					new Item.Properties().group(HumlandsTab.HUMLANDS).maxStackSize(1).maxDamage(500)));

	public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
			() -> new Item(new Item.Properties().group(HumlandsTab.HUMLANDS).maxStackSize(64)));

	public static final RegistryObject<Item> HUMADILLO_SPAWN_EGG = ITEMS.register("humadillo_spawn_egg",
			() -> new ModSpawnEgg(new Item.Properties().group(HumlandsTab.HUMLANDS),
					() -> EntityTypesInit.HUMADILLO.get()));

	public static final RegistryObject<Item> RUBBER_BALL = ITEMS.register("rubber_ball",
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));

	public static final RegistryObject<Item> MUMMY_SPAWN_EGG = ITEMS.register("mummy_spawn_egg",
			() -> new ModSpawnEgg(new Item.Properties().group(HumlandsTab.HUMLANDS),
					() -> EntityTypesInit.MUMMY.get()));
	
	public static final RegistryObject<Item> HUMMBLEWEED_SPAWN_EGG = ITEMS.register("humbleweed_spawn_egg",
			() -> new ModSpawnEgg(new Item.Properties().group(HumlandsTab.HUMLANDS), 
					() -> EntityTypesInit.HUMBLEWEED.get()));
	
	public static final RegistryObject<Item> HUMAHOG_SPAWN_EGG = ITEMS.register("humahog_spawn_egg", 
			() -> new ModSpawnEgg(new Item.Properties().group(HumlandsTab.HUMLANDS), 
					() -> EntityTypesInit.HUMAHOG.get()));
}
