package net.mcreator.zanyelements.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class OliveTreeOnStructureInstanceGeneratedProcedure extends ZanyelementsModElements.ModElement {
	public OliveTreeOnStructureInstanceGeneratedProcedure(ZanyelementsModElements instance) {
		super(instance, 101);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency x for procedure OliveTreeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency y for procedure OliveTreeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency z for procedure OliveTreeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure OliveTreeOnStructureInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double treeSelect = 0;
		treeSelect = (double) Math.round((Math.random() * 2));
		if (((treeSelect) == 0)) {
			if (world instanceof World && !world.isRemote()) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("zanyelements", "olive_tree_1"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		} else if (((treeSelect) == 1)) {
			if (world instanceof World && !world.isRemote()) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("zanyelements", "olive_tree_2"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		} else if (((treeSelect) == 2)) {
			if (world instanceof World && !world.isRemote()) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("zanyelements", "olive_tree_3"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
	}
}
