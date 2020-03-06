package com.turtysproductions.humlands.common.advancement.triggers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class FilledVialTrigger extends AbstractCriterionTrigger<FilledVialTrigger.Instance> {
	private static final ResourceLocation ID = new ResourceLocation("filled_vial_trigger");

	public ResourceLocation getId() {
		return ID;
	}

	public FilledVialTrigger.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
		ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
		return new FilledVialTrigger.Instance(itempredicate);
	}

	public void trigger(ServerPlayerEntity serverplay, ItemStack stack) {
		this.func_227070_a_(serverplay.getAdvancements(), (p_227037_1_) -> {
			return p_227037_1_.test(stack);
		});
	}

	public static class Instance extends CriterionInstance {
		private final ItemPredicate item;

		public Instance(ItemPredicate item) {
			super(FilledVialTrigger.ID);
			this.item = item;
		}

		public static FilledVialTrigger.Instance forItem(ItemPredicate predicate) {
			return new FilledVialTrigger.Instance(predicate);
		}

		public boolean test(ItemStack stack) {
			return this.item.test(stack);
		}

		public JsonElement serialize() {
			JsonObject jsonobject = new JsonObject();
			jsonobject.add("item", this.item.serialize());
			return jsonobject;
		}
	}
}
