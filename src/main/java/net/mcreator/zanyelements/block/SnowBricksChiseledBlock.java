
package net.mcreator.zanyelements.block;

import net.minecraft.block.material.Material;

@ZanyelementsModElements.ModElement.Tag
public class SnowBricksChiseledBlock extends ZanyelementsModElements.ModElement {

	@ObjectHolder("zanyelements:snow_bricks_chiseled")
	public static final Block block = null;

	public SnowBricksChiseledBlock(ZanyelementsModElements instance) {
		super(instance, 173);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.SNOW_BLOCK).sound(SoundType.SNOW).hardnessAndResistance(0.4f, 0.4f).lightValue(0).harvestLevel(0)
							.harvestTool(ToolType.SHOVEL));

			setRegistryName("snow_bricks_chiseled");
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
