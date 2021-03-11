package net.mcreator.zanyelements.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.ZanyelementsModVariables;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class VoidPouchLevelUpRequirmentDecreaseProcedure extends ZanyelementsModElements.ModElement {
	public VoidPouchLevelUpRequirmentDecreaseProcedure(ZanyelementsModElements instance) {
		super(instance, 257);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure VoidPouchLevelUpRequirmentDecrease!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure VoidPouchLevelUpRequirmentDecrease!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity.isSneaking())) {
			ZanyelementsModVariables.MapVariables.get(world).voidPouchLevelUpRequirmentMultiplier = (double) ((ZanyelementsModVariables.MapVariables
					.get(world).voidPouchLevelUpRequirmentMultiplier) - 1);
			ZanyelementsModVariables.MapVariables.get(world).syncData(world);
		} else {
			ZanyelementsModVariables.MapVariables.get(world).voidPouchLevelUpRequirmentMultiplier = (double) ((ZanyelementsModVariables.MapVariables
					.get(world).voidPouchLevelUpRequirmentMultiplier) - 0.1);
			ZanyelementsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
