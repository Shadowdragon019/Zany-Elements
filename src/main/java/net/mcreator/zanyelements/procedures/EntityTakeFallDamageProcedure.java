package net.mcreator.zanyelements.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.item.TNTItem;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;
import java.util.HashMap;

@ZanyelementsModElements.ModElement.Tag
public class EntityTakeFallDamageProcedure extends ZanyelementsModElements.ModElement {
	public EntityTakeFallDamageProcedure(ZanyelementsModElements instance) {
		super(instance, 80);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure EntityTakeFallDamage!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure EntityTakeFallDamage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
				: ItemStack.EMPTY).getItem() == new ItemStack(TNTItem.boots, (int) (1)).getItem())) {
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) (entity.getPosX()), (int) ((entity.getPosY()) + (-1)), (int) (entity.getPosZ()),
						(float) 1, Explosion.Mode.BREAK);
			}
			entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) + 0.5), (entity.getMotion().getZ()));
		}
	}

	@SubscribeEvent
	public void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double damagemultiplier = event.getDamageMultiplier();
			double distance = event.getDistance();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("damagemultiplier", damagemultiplier);
			dependencies.put("distance", distance);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
