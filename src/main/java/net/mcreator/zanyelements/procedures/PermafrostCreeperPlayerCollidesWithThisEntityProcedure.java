package net.mcreator.zanyelements.procedures;

@ZanyelementsModElements.ModElement.Tag
public class PermafrostCreeperPlayerCollidesWithThisEntityProcedure extends ZanyelementsModElements.ModElement {

	public PermafrostCreeperPlayerCollidesWithThisEntityProcedure(ZanyelementsModElements instance) {
		super(instance, 190);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure PermafrostCreeperPlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency x for procedure PermafrostCreeperPlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency y for procedure PermafrostCreeperPlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency z for procedure PermafrostCreeperPlayerCollidesWithThisEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure PermafrostCreeperPlayerCollidesWithThisEntity!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		double yOffset = 0;
		double xOffset = 0;
		double zOffset = 0;
		if (!entity.world.isRemote)
			entity.remove();
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), (float) 1,
					Explosion.Mode.NONE);
		}
		xOffset = (double) 2;
		yOffset = (double) 0;
		zOffset = (double) 2;
		for (int index0 = 0; index0 < (int) (3); index0++) {
			for (int index1 = 0; index1 < (int) (2); index1++) {
				if ((world.isAirBlock(new BlockPos((int) (x + (xOffset)), (int) (y + (yOffset)), (int) (z + 1))))) {
					world.setBlockState(new BlockPos((int) (x + (xOffset)), (int) (y + (yOffset)), (int) (z + 1)),
							Blocks.FROSTED_ICE.getDefaultState(), 3);
				}
				if ((world.isAirBlock(new BlockPos((int) (x + (xOffset)), (int) (y + (yOffset)), (int) z)))) {
					world.setBlockState(new BlockPos((int) (x + (xOffset)), (int) (y + (yOffset)), (int) z), Blocks.FROSTED_ICE.getDefaultState(), 3);
				}
				if ((world.isAirBlock(new BlockPos((int) (x + (xOffset)), (int) (y + (yOffset)), (int) (z - 1))))) {
					world.setBlockState(new BlockPos((int) (x + (xOffset)), (int) (y + (yOffset)), (int) (z - 1)),
							Blocks.FROSTED_ICE.getDefaultState(), 3);
				}
				if ((world.isAirBlock(new BlockPos((int) (x + 1), (int) (y + (yOffset)), (int) (z + (zOffset)))))) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) (y + (yOffset)), (int) (z + (zOffset))),
							Blocks.FROSTED_ICE.getDefaultState(), 3);
				}
				if ((world.isAirBlock(new BlockPos((int) x, (int) (y + (yOffset)), (int) (z + (zOffset)))))) {
					world.setBlockState(new BlockPos((int) x, (int) (y + (yOffset)), (int) (z + (zOffset))), Blocks.FROSTED_ICE.getDefaultState(), 3);
				}
				if ((world.isAirBlock(new BlockPos((int) (x - 1), (int) (y + (yOffset)), (int) (z + (zOffset)))))) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) (y + (yOffset)), (int) (z + (zOffset))),
							Blocks.FROSTED_ICE.getDefaultState(), 3);
				}
				xOffset = (double) ((xOffset) * (-1));
				zOffset = (double) ((zOffset) * (-1));
			}
			yOffset = (double) ((yOffset) + 1);
		}

	}

}
