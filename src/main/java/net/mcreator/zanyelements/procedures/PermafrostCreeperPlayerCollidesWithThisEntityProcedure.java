package net.mcreator.zanyelements.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.entity.GlacierEntity;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

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
		double xProperOffset = 0;
		double zProperOffset = 0;
		if ((!(world.isRemote()))) {
			if (!entity.world.isRemote())
				entity.remove();
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), (float) 1,
						Explosion.Mode.NONE);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new GlacierEntity.CustomEntity(GlacierEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(((x + 1) + (xProperOffset)), y, ((z + 1) + (zProperOffset)), world.getRandom().nextFloat() * 360F,
						0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new GlacierEntity.CustomEntity(GlacierEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(((x + (-1)) + (xProperOffset)), y, ((z + (-1)) + (zProperOffset)),
						world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			xOffset = (double) 2;
			yOffset = (double) 0;
			zOffset = (double) 2;
			if ((x < 0)) {
				xProperOffset = (double) (-1);
			}
			if ((z < 0)) {
				zProperOffset = (double) (-1);
			}
			for (int index0 = 0; index0 < (int) (3); index0++) {
				for (int index1 = 0; index1 < (int) (2); index1++) {
					if ((world.isAirBlock(
							new BlockPos((int) ((x + (xOffset)) + (xProperOffset)), (int) (y + (yOffset)), (int) ((z + 1) + (zProperOffset)))))) {
						world.setBlockState(
								new BlockPos((int) ((x + (xOffset)) + (xProperOffset)), (int) (y + (yOffset)), (int) ((z + 1) + (zProperOffset))),
								Blocks.PACKED_ICE.getDefaultState(), 3);
					}
					if ((world.isAirBlock(
							new BlockPos((int) ((x + (xOffset)) + (xProperOffset)), (int) (y + (yOffset)), (int) (z + (zProperOffset)))))) {
						world.setBlockState(
								new BlockPos((int) ((x + (xOffset)) + (xProperOffset)), (int) (y + (yOffset)), (int) (z + (zProperOffset))),
								Blocks.PACKED_ICE.getDefaultState(), 3);
					}
					if ((world.isAirBlock(
							new BlockPos((int) ((x + (xOffset)) + (xProperOffset)), (int) (y + (yOffset)), (int) ((z - 1) + (zProperOffset)))))) {
						world.setBlockState(
								new BlockPos((int) ((x + (xOffset)) + (xProperOffset)), (int) (y + (yOffset)), (int) ((z - 1) + (zProperOffset))),
								Blocks.PACKED_ICE.getDefaultState(), 3);
					}
					if ((world.isAirBlock(
							new BlockPos((int) ((x + 1) + (xProperOffset)), (int) (y + (yOffset)), (int) ((z + (zOffset)) + (zProperOffset)))))) {
						world.setBlockState(
								new BlockPos((int) ((x + 1) + (xProperOffset)), (int) (y + (yOffset)), (int) ((z + (zOffset)) + (zProperOffset))),
								Blocks.PACKED_ICE.getDefaultState(), 3);
					}
					if ((world.isAirBlock(
							new BlockPos((int) (x + (xProperOffset)), (int) (y + (yOffset)), (int) ((z + (zOffset)) + (zProperOffset)))))) {
						world.setBlockState(
								new BlockPos((int) (x + (xProperOffset)), (int) (y + (yOffset)), (int) ((z + (zOffset)) + (zProperOffset))),
								Blocks.PACKED_ICE.getDefaultState(), 3);
					}
					if ((world.isAirBlock(
							new BlockPos((int) ((x - 1) + (xProperOffset)), (int) (y + (yOffset)), (int) ((z + (zOffset)) + (zProperOffset)))))) {
						world.setBlockState(
								new BlockPos((int) ((x - 1) + (xProperOffset)), (int) (y + (yOffset)), (int) ((z + (zOffset)) + (zProperOffset))),
								Blocks.PACKED_ICE.getDefaultState(), 3);
					}
					xOffset = (double) ((xOffset) * (-1));
					zOffset = (double) ((zOffset) * (-1));
				}
				yOffset = (double) ((yOffset) + 1);
			}
		}
	}
}
