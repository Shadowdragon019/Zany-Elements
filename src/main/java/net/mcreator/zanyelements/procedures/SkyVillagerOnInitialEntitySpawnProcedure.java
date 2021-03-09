package net.mcreator.zanyelements.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class SkyVillagerOnInitialEntitySpawnProcedure extends ZanyelementsModElements.ModElement {
	public SkyVillagerOnInitialEntitySpawnProcedure(ZanyelementsModElements instance) {
		super(instance, 239);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure SkyVillagerOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("avaliableElytras", Math.round(((Math.random() * 2) + 3)));
	}
}
