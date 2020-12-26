package net.mcreator.zanyelements.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.block.CoreCraftingTableBlock;
import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class CraftingCoreBlockAddedProcedure extends ZanyelementsModElements.ModElement {
	public CraftingCoreBlockAddedProcedure(ZanyelementsModElements instance) {
		super(instance, 89);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure CraftingCoreBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure CraftingCoreBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure CraftingCoreBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CraftingCoreBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:crafting_table").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock()))
				&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:crafting_table").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 0)))).getBlock())))
				&& ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:crafting_table").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + (-1))))).getBlock()))
						&& (BlockTags.getCollection()
								.getOrCreate(new ResourceLocation(("forge:crafting_table").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z + 1)))).getBlock()))))
				&& (((BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:crafting_table").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z + (-1))))).getBlock()))
						&& (BlockTags.getCollection()
								.getOrCreate(new ResourceLocation(("forge:crafting_table").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) (z + 1)))).getBlock())))
						&& ((BlockTags.getCollection()
								.getOrCreate(new ResourceLocation(("forge:crafting_table").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) (z + 0)))).getBlock()))
								&& (BlockTags.getCollection()
										.getOrCreate(new ResourceLocation(("forge:crafting_table").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) (z + (-1))))).getBlock())))))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CoreCraftingTableBlock.block.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 0)), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + (-1))), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z + 1)), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) y, (int) (z + (-1))), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) (z + 1)), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) (z + 0)), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + (-1)), (int) y, (int) (z + (-1))), Blocks.AIR.getDefaultState(), 3);
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.power_select")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				world.getWorld().playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.power_select")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
	}
}
