
package net.mcreator.zanyelements.block;

import net.minecraft.block.material.Material;

@ZanyelementsModElements.ModElement.Tag
public class SnowBrickSlabBlock extends ZanyelementsModElements.ModElement {

	@ObjectHolder("zanyelements:snow_brick_slab")
	public static final Block block = null;

	public SnowBrickSlabBlock(ZanyelementsModElements instance) {
		super(instance, 175);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.SNOW).hardnessAndResistance(0.4f, 0.4f).lightValue(0).harvestLevel(0)
							.harvestTool(ToolType.SHOVEL));

			setRegistryName("snow_brick_slab");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}

	}

}
