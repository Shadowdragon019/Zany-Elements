package net.mcreator.zanyelements.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.ZanyelementsModVariables;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class VoidPouchSizeMultiplierIncreaseProcedure extends ZanyelementsModElements.ModElement {
	public VoidPouchSizeMultiplierIncreaseProcedure(ZanyelementsModElements instance) {
		super(instance, 254);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure VoidPouchSizeMultiplierIncrease!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure VoidPouchSizeMultiplierIncrease!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity.isSneaking())) {
			ZanyelementsModVariables.MapVariables
					.get(world).voidPouchSizeMultiplier = (double) ((ZanyelementsModVariables.MapVariables.get(world).voidPouchSizeMultiplier) + 1);
			ZanyelementsModVariables.MapVariables.get(world).syncData(world);
		} else {
			ZanyelementsModVariables.MapVariables
					.get(world).voidPouchSizeMultiplier = (double) ((ZanyelementsModVariables.MapVariables.get(world).voidPouchSizeMultiplier) + 0.1);
			ZanyelementsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
