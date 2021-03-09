
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.item.GoldenChaliceItem;
import net.mcreator.zanyelements.item.EmeraldFilledChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class EmeraldFilledChaliceRBrewingRecipe extends ZanyelementsModElements.ModElement {
	public EmeraldFilledChaliceRBrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 215);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(GoldenChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.EMERALD_BLOCK, (int) (1))), new ItemStack(EmeraldFilledChaliceItem.block, (int) (1)));
	}
}
