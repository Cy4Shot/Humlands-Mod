package com.turtysproductions.humlands.core.init;

import com.turtysproductions.humlands.HumlandsMod;
import com.turtysproductions.humlands.common.recipe.ISifterRecipe;
import com.turtysproductions.humlands.common.recipe.SifterRecipe;
import com.turtysproductions.humlands.common.recipe.SifterRecipeSerializer;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit {

	public static final IRecipeSerializer<SifterRecipe> SIFTER_RECIPE_SERIALIZER = new SifterRecipeSerializer();
	public static final IRecipeType<ISifterRecipe> SIFTER_TYPE = registerType(ISifterRecipe.RECIPE_TYPE_ID);

	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(
			ForgeRegistries.RECIPE_SERIALIZERS, HumlandsMod.MOD_ID);

	public static final RegistryObject<IRecipeSerializer<?>> SIFTER_SERIALIZER = RECIPE_SERIALIZERS.register("sifter",
			() -> SIFTER_RECIPE_SERIALIZER);

	private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
		@Override
		public String toString() {
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) {
		return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
	}
}
