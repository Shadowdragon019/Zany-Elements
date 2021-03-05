package net.mcreator.zanyelements.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;
import java.util.HashMap;

@ZanyelementsModElements.ModElement.Tag
public class CollapzeProcedure extends ZanyelementsModElements.ModElement {
	public CollapzeProcedure(ZanyelementsModElements instance) {
		super(instance, 167);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency x for procedure Collapze!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency y for procedure Collapze!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency z for procedure Collapze!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure Collapze!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double X = 0;
		double Y = 0;
		double Z = 0;
		if (((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:unstable").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) (1 + x), (int) y, (int) z))).getBlock()))
				&& (!(0 == Math.round((Math.random() * 2)))))) {
			world.destroyBlock(new BlockPos((int) (1 + x), (int) y, (int) z), false);
		}
		if (((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:unstable").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) (1 + y), (int) z))).getBlock()))
				&& (!(0 == Math.round((Math.random() * 2)))))) {
			world.destroyBlock(new BlockPos((int) x, (int) (1 + y), (int) z), false);
		}
		if (((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:unstable").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (1 + z)))).getBlock()))
				&& (!(0 == Math.round((Math.random() * 2)))))) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) (1 + z)), false);
		}
		if (((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:unstable").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) ((-1) + x), (int) y, (int) z))).getBlock()))
				&& (!(0 == Math.round((Math.random() * 2)))))) {
			world.destroyBlock(new BlockPos((int) ((-1) + x), (int) y, (int) z), false);
		}
		if (((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:unstable").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) ((-1) + y), (int) z))).getBlock()))
				&& (!(0 == Math.round((Math.random() * 2)))))) {
			world.destroyBlock(new BlockPos((int) x, (int) ((-1) + y), (int) z), false);
		}
		if (((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:unstable").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) ((-1) + z)))).getBlock()))
				&& (!(0 == Math.round((Math.random() * 2)))))) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) ((-1) + z)), false);
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Entity entity = event.getPlayer();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("xpAmount", event.getExpToDrop());
		dependencies.put("x", event.getPos().getX());
		dependencies.put("y", event.getPos().getY());
		dependencies.put("z", event.getPos().getZ());
		dependencies.put("px", entity.getPosX());
		dependencies.put("py", entity.getPosY());
		dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
