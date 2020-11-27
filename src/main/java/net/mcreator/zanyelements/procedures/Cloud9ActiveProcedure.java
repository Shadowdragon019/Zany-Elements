package net.mcreator.zanyelements.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.particle.CloudDustParticle;
import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

@ZanyelementsModElements.ModElement.Tag
public class Cloud9ActiveProcedure extends ZanyelementsModElements.ModElement {
	public Cloud9ActiveProcedure(ZanyelementsModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Cloud9Active!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Cloud9Active!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Cloud9Active!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Cloud9Active!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Cloud9Active!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + 0.07), (entity.getMotion().getZ()));
		entity.fallDistance = (float) (0);
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(CloudDustParticle.particle, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), (int) 1, 0.3,
					0.1, 0.3, 0.1);
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (8 / 2d), y - (8 / 2d), z - (8 / 2d), x + (8 / 2d), y + (8 / 2d), z + (8 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if ((!(entity instanceof ItemEntity))) {
					if ((!(entityiterator == entity))) {
						entityiterator.setMotion((entityiterator.getMotion().getX()), ((entityiterator.getMotion().getY()) + 0.1),
								(entityiterator.getMotion().getZ()));
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(CloudDustParticle.particle, (entityiterator.getPosX()), (entityiterator.getPosY()),
									(entityiterator.getPosZ()), (int) 1, 0.3, 0.1, 0.3, 0.1);
						}
					}
				}
			}
		}
	}
}
