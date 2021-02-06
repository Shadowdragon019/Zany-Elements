
package net.mcreator.zanyelements.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.List;
import java.util.Collections;

@ZanyelementsModElements.ModElement.Tag
public class CrackedSnowBricksBlock extends ZanyelementsModElements.ModElement {
	@ObjectHolder("zanyelements:cracked_snow_bricks")
	public static final Block block = null;
	public CrackedSnowBricksBlock(ZanyelementsModElements instance) {
		super(instance, 171);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.SNOW).sound(SoundType.SNOW).hardnessAndResistance(0.4f, 0.4f).lightValue(0).harvestLevel(0)
					.harvestTool(ToolType.SHOVEL));
			setRegistryName("cracked_snow_bricks");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
