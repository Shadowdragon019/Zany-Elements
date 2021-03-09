
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.item.WorldFilledChaliceItem;
import net.mcreator.zanyelements.item.DiamondFilledChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class WorldFilledChaliceRBrewingRecipe extends ZanyelementsModElements.ModElement {
	public WorldFilledChaliceRBrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 227);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(DiamondFilledChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.EMERALD_BLOCK, (int) (1))), new ItemStack(WorldFilledChaliceItem.block, (int) (1)));
	}
}
