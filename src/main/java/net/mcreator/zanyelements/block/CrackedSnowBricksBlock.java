
package net.mcreator.zanyelements.block;

import net.minecraft.block.material.Material;

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
			super(

					Block.Properties.create(Material.SNOW_BLOCK).sound(SoundType.SNOW).hardnessAndResistance(0.4f, 0.4f).lightValue(0).harvestLevel(0)
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
