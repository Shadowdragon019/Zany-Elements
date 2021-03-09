
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.item.RedstoneFilledChaliceItem;
import net.mcreator.zanyelements.item.GoldenChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class RedstoneFilledChaliceRBrewingRecipe extends ZanyelementsModElements.ModElement {
	public RedstoneFilledChaliceRBrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 220);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(GoldenChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.REDSTONE_BLOCK, (int) (1))), new ItemStack(RedstoneFilledChaliceItem.block, (int) (1)));
	}
}
