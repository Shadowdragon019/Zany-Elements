
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.zanyelements.item.WorldFilledChaliceItem;
import net.mcreator.zanyelements.item.EmeraldFilledChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class WorldFilledChaliceR2BrewingRecipe extends ZanyelementsModElements.ModElement {
	public WorldFilledChaliceR2BrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 227);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(EmeraldFilledChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Items.DIAMOND, (int) (1))), new ItemStack(WorldFilledChaliceItem.block, (int) (1)));
	}
}
