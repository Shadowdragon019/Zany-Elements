
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.item.LapisLazuilFilledChaliceItem;
import net.mcreator.zanyelements.item.GoldenChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class LapisLazuliFilledChaliceRBrewingRecipe extends ZanyelementsModElements.ModElement {
	public LapisLazuliFilledChaliceRBrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 217);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(GoldenChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.LAPIS_BLOCK, (int) (1))), new ItemStack(LapisLazuilFilledChaliceItem.block, (int) (1)));
	}
}
