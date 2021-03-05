package net.mcreator.zanyelements.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.item.TotemOfExplosivesItem;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;

@ZanyelementsModElements.ModElement.Tag
public class EntityTriesToGriefProcedure extends ZanyelementsModElements.ModElement {
	public EntityTriesToGriefProcedure(ZanyelementsModElements instance) {
		super(instance, 37);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure EntityTriesToGrief!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency x for procedure EntityTriesToGrief!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency y for procedure EntityTriesToGrief!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency z for procedure EntityTriesToGrief!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure EntityTriesToGrief!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof CreeperEntity)) {
			if (((true) == (entity.getPersistentData().getBoolean("explosionDisabled")))) {
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.hasResult())
							_evt.setResult(Event.Result.DENY);
					}
				}
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (64 / 2d), y - (64 / 2d), z - (64 / 2d), x + (64 / 2d), y + (64 / 2d), z + (64 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					{
						AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
						entityiterator.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> _iitemhandlerref.set(capability));
						if (_iitemhandlerref.get() != null) {
							for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
								ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
								if (((itemstackiterator).getItem() == new ItemStack(TotemOfExplosivesItem.block, (int) (1)).getItem())) {
									if (dependencies.get("event") != null) {
										Object _obj = dependencies.get("event");
										if (_obj instanceof Event) {
											Event _evt = (Event) _obj;
											if (_evt.hasResult())
												_evt.setResult(Event.Result.DENY);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityGrief(EntityMobGriefingEvent event) {
		Entity entity = event.getEntity();
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
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
