package com.turtysproductions.humlands.common.items;

import com.turtysproductions.humlands.common.entities.Humadillo;
import com.turtysproductions.humlands.core.init.EntityTypesInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

public class HumadilloSpawnEgg extends Item {

	public HumadilloSpawnEgg(Properties properties) {
		super(properties);

	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		EntityType<Humadillo> humadillo = EntityTypesInit.HUMADILLO.get();

		Entity humadillo1 = humadillo.spawn(context.getWorld(), context.getItem(), context.getPlayer(),
				context.getPos().add(0, 1, 0), SpawnReason.SPAWN_EGG, false, false);

		context.getWorld().addEntity(humadillo1);
		return ActionResultType.SUCCESS;
	}

}
