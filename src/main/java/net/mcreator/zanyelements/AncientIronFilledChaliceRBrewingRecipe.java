
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.item.NetheriteScrapFilledChaliceItem;
import net.mcreator.zanyelements.item.AncientIronFilledChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class AncientIronFilledChaliceRBrewingRecipe extends ZanyelementsModElements.ModElement {
	public AncientIronFilledChaliceRBrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 226);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(NetheriteScrapFilledChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.IRON_BLOCK, (int) (1))), new ItemStack(AncientIronFilledChaliceItem.block, (int) (1)));
	}
}
