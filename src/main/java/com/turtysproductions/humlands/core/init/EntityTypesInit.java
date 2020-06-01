package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.entities.Centipede;
import com.turtysproductions.humlands.common.entities.Humadillo;
import com.turtysproductions.humlands.common.entities.Humahog;
import com.turtysproductions.humlands.common.entities.Humbleweed;
import com.turtysproductions.humlands.common.entities.Mummy;
import com.turtysproductions.humlands.common.entities.RubberBallEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypesInit {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			HumlandsMod.MOD_ID);

	public static final RegistryObject<EntityType<Humadillo>> HUMADILLO = ENTITY_TYPES.register("humadillo",
			() -> EntityType.Builder.<Humadillo>create(Humadillo::new, EntityClassification.CREATURE).size(0.9f, 0.5f)
					.build(new ResourceLocation(HumlandsMod.MOD_ID, "humadillo").toString()));

	public static final RegistryObject<EntityType<Mummy>> MUMMY = ENTITY_TYPES.register("mummy",
			() -> EntityType.Builder.<Mummy>create(Mummy::new, EntityClassification.MISC).size(0.9f, 2.0f)
					.build(new ResourceLocation(HumlandsMod.MOD_ID, "mummy").toString()));

	public static final RegistryObject<EntityType<Humbleweed>> HUMBLEWEED = ENTITY_TYPES.register("humbleweed",
			() -> EntityType.Builder.<Humbleweed>create(Humbleweed::new, EntityClassification.AMBIENT).size(0.9f, 0.9f)
					.build(new ResourceLocation(HumlandsMod.MOD_ID, "humbleweed").toString()));

	public static final RegistryObject<EntityType<Humahog>> HUMAHOG = ENTITY_TYPES.register("humahog",
			() -> EntityType.Builder.<Humahog>create(Humahog::new, EntityClassification.MONSTER).size(0.8f, 0.8f)
					.build(new ResourceLocation(HumlandsMod.MOD_ID, "humahog").toString()));

	public static final RegistryObject<EntityType<RubberBallEntity>> RUBBER_BALL_ENTITY = ENTITY_TYPES.register(
			"rubber_ball_entity",
			() -> EntityType.Builder.<RubberBallEntity>create(RubberBallEntity::new, EntityClassification.MISC)
					.disableSummoning().size(0.9f, 1.3f)
					.build(new ResourceLocation(HumlandsMod.MOD_ID, "rubber_ball_entity").toString()));
	
	public static final RegistryObject<EntityType<Centipede>> CENTIPEDE = ENTITY_TYPES.register("centipede",
			() -> EntityType.Builder.<Centipede>create(Centipede::new, EntityClassification.CREATURE).size(2.5f, 0.5f)
					.build(new ResourceLocation(HumlandsMod.MOD_ID, "centipede").toString()));
}
