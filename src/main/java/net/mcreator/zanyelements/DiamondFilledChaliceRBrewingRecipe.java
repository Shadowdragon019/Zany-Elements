
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.zanyelements.item.GoldenChaliceItem;
import net.mcreator.zanyelements.item.DiamondFilledChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class DiamondFilledChaliceRBrewingRecipe extends ZanyelementsModElements.ModElement {
	public DiamondFilledChaliceRBrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 214);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(GoldenChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Items.DIAMOND, (int) (1))), new ItemStack(DiamondFilledChaliceItem.block, (int) (1)));
	}
}
