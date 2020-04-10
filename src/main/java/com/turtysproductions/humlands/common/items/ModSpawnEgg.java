package com.turtysproductions.humlands.common.items;

import java.util.function.Supplier;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

public class ModSpawnEgg extends Item {

	private Supplier<EntityType<?>> entityType;

	public ModSpawnEgg(Properties properties, Supplier<EntityType<?>> entityTypeIn) {
		super(properties);
		this.entityType = entityTypeIn;
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		Entity entity = entityType.get().spawn(context.getWorld(), context.getItem(), context.getPlayer(),
				context.getPos().add(0, 1, 0), SpawnReason.SPAWN_EGG, false, false);

		context.getWorld().addEntity(entity);
		return ActionResultType.SUCCESS;
	}
}
