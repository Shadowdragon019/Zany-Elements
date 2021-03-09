
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.item.GoldenChaliceItem;
import net.mcreator.zanyelements.item.CoalFilledChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class CoalFilledChaliceRBrewingRecipe extends ZanyelementsModElements.ModElement {
	public CoalFilledChaliceRBrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 213);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(GoldenChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.COAL_BLOCK, (int) (1))), new ItemStack(CoalFilledChaliceItem.block, (int) (1)));
	}
}
