package net.mcreator.zanyelements.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.item.TotemOfTheEndItem;
import net.mcreator.zanyelements.item.TotemOfSupplementaryItem;
import net.mcreator.zanyelements.item.TotemOfShulkingItem;
import net.mcreator.zanyelements.item.TotemOfFluffItem;
import net.mcreator.zanyelements.item.TotemOfExplosivesItem;
import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.HashMap;

@ZanyelementsModElements.ModElement.Tag
public class EntityDiesTotemDropsProcedure extends ZanyelementsModElements.ModElement {
	public EntityDiesTotemDropsProcedure(ZanyelementsModElements instance) {
		super(instance, 82);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EntityDiesTotemDrops!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure EntityDiesTotemDrops!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure EntityDiesTotemDrops!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		double chance = 0;
		chance = (double) 1;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			sourceentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if ((new ItemStack(TotemOfSupplementaryItem.block, (int) (1)).getItem() == (itemstackiterator).getItem())) {
						chance = (double) ((chance) + 1);
					}
				}
			}
		}
		for (int index0 = 0; index0 < (int) ((chance)); index0++) {
			if ((Math.round((Math.random() * 63)) == 0)) {
				if ((entity instanceof CreeperEntity)) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
								new ItemStack(TotemOfExplosivesItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				} else if ((entity instanceof EndermanEntity)) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
								new ItemStack(TotemOfTheEndItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				} else if ((entity instanceof SheepEntity)) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
								new ItemStack(TotemOfFluffItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				} else if ((entity instanceof ShulkerEntity)) {
					if (!world.getWorld().isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
								new ItemStack(TotemOfShulkingItem.block, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
