package net.mcreator.zanyelements.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class OliveTreeOnStructureInstanceGeneratedProcedure extends ZanyelementsModElements.ModElement {
	public OliveTreeOnStructureInstanceGeneratedProcedure(ZanyelementsModElements instance) {
		super(instance, 101);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure OliveTreeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure OliveTreeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure OliveTreeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure OliveTreeOnStructureInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double treeSelect = 0;
		treeSelect = (double) Math.round((Math.random() * 2));
		if (((treeSelect) == 0)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("zanyelements", "olive_tree_1"));
				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((treeSelect) == 1)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("zanyelements", "olive_tree_2"));
				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((treeSelect) == 2)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("zanyelements", "olive_tree_3"));
				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		}
	}
}