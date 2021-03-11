package net.mcreator.zanyelements.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.ZanyelementsModVariables;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class VoidPouchMaxLevelDecreaseProcedure extends ZanyelementsModElements.ModElement {
	public VoidPouchMaxLevelDecreaseProcedure(ZanyelementsModElements instance) {
		super(instance, 253);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure VoidPouchMaxLevelDecrease!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure VoidPouchMaxLevelDecrease!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity.isSneaking())) {
			ZanyelementsModVariables.MapVariables
					.get(world).voidPouchMaxLevel = (double) ((ZanyelementsModVariables.MapVariables.get(world).voidPouchMaxLevel) - 10);
			ZanyelementsModVariables.MapVariables.get(world).syncData(world);
		} else {
			ZanyelementsModVariables.MapVariables
					.get(world).voidPouchMaxLevel = (double) ((ZanyelementsModVariables.MapVariables.get(world).voidPouchMaxLevel) - 1);
			ZanyelementsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
