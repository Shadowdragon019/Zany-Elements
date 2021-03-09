
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.item.RedstoneFilledChaliceItem;
import net.mcreator.zanyelements.item.BlackcoalFilledChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class BlackcoalFilledChaliceR2BrewingRecipe extends ZanyelementsModElements.ModElement {
	public BlackcoalFilledChaliceR2BrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 228);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(RedstoneFilledChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.COAL_BLOCK, (int) (1))), new ItemStack(BlackcoalFilledChaliceItem.block, (int) (1)));
	}
}
