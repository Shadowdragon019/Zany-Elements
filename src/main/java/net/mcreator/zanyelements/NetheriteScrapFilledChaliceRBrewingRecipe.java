
package net.mcreator.zanyelements;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import net.mcreator.zanyelements.item.NetheriteScrapFilledChaliceItem;
import net.mcreator.zanyelements.item.GoldenChaliceItem;

@ZanyelementsModElements.ModElement.Tag
public class NetheriteScrapFilledChaliceRBrewingRecipe extends ZanyelementsModElements.ModElement {
	public NetheriteScrapFilledChaliceRBrewingRecipe(ZanyelementsModElements instance) {
		super(instance, 218);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(new ItemStack(GoldenChaliceItem.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Items.NETHERITE_SCRAP, (int) (1))),
				new ItemStack(NetheriteScrapFilledChaliceItem.block, (int) (1)));
	}
}
