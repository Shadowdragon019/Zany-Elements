package net.mcreator.zanyelements.procedures;

@ZanyelementsModElements.ModElement.Tag
public class WaystoneFireOnStructureInstanceGeneratedProcedure extends ZanyelementsModElements.ModElement {

	public WaystoneFireOnStructureInstanceGeneratedProcedure(ZanyelementsModElements instance) {
		super(instance, 192);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency x for procedure WaystoneFireOnStructureInstanceGenerated!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency y for procedure WaystoneFireOnStructureInstanceGenerated!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency z for procedure WaystoneFireOnStructureInstanceGenerated!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure WaystoneFireOnStructureInstanceGenerated!");
			return false;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (((Math.round(Math.random()) == 0)
				|| (ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))).equals(new ResourceLocation("ocean"))))) {
			return (true);
		}
		return (false);

	}

}
