
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.item.LapisLazuilFilledChaliceItem;
import net.mcreator.zanyelements.item.BlueQuartzFilledChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class BlueQuartzFilledChaliceR2BrewingRecipe extends ZanyelementsModElements.ModElement {
	public BlueQuartzFilledChaliceR2BrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 225);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(LapisLazuilFilledChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.QUARTZ_BLOCK, (int) (1))), new ItemStack(BlueQuartzFilledChaliceItem.block, (int) (1)));
	}
}
