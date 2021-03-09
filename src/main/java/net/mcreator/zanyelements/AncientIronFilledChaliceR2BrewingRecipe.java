
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.zanyelements.item.IronFilledChaliceItem;
import net.mcreator.zanyelements.item.AncientIronFilledChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class AncientIronFilledChaliceR2BrewingRecipe extends ZanyelementsModElements.ModElement {
	public AncientIronFilledChaliceR2BrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 226);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(IronFilledChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Items.NETHERITE_SCRAP, (int) (1))), new ItemStack(AncientIronFilledChaliceItem.block, (int) (1)));
	}
}
