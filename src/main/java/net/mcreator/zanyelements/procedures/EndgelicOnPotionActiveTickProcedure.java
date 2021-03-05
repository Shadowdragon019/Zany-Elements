package net.mcreator.zanyelements.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.potion.EndgelicPotion;
import net.mcreator.zanyelements.particle.EndDustParticle;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class EndgelicOnPotionActiveTickProcedure extends ZanyelementsModElements.ModElement {
	public EndgelicOnPotionActiveTickProcedure(ZanyelementsModElements instance) {
		super(instance, 85);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure EndgelicOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency x for procedure EndgelicOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency y for procedure EndgelicOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency z for procedure EndgelicOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure EndgelicOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		entity.fallDistance = (float) (0);
		if ((!(world.isAirBlock(new BlockPos((int) x, (int) (y - 0.5), (int) z))))) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(EndgelicPotion.potion);
			}
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(EndDustParticle.particle, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), (int) 1, 0.3,
					0.1, 0.3, 0.1);
		}
	}
}
