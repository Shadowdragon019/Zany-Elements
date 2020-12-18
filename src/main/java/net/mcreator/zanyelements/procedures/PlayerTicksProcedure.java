package net.mcreator.zanyelements.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.potion.EndgelicPotion;
import net.mcreator.zanyelements.item.TotemOfTheEndItem;
import net.mcreator.zanyelements.item.TotemOfFluffItem;
import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;

@ZanyelementsModElements.ModElement.Tag
public class PlayerTicksProcedure extends ZanyelementsModElements.ModElement {
	public PlayerTicksProcedure(ZanyelementsModElements instance) {
		super(instance, 82);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PlayerTicks!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PlayerTicks!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PlayerTicks!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PlayerTicks!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PlayerTicks!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if ((((itemstackiterator).getItem() == new ItemStack(TotemOfTheEndItem.block, (int) (1)).getItem()) && ((-63) > y))) {
						{
							Entity _ent = entity;
							_ent.setPositionAndUpdate(x, 255, z);
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, 255, z, _ent.rotationYaw, _ent.rotationPitch,
										Collections.emptySet());
							}
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(EndgelicPotion.potion, (int) 1200, (int) 0));
					}
					if (((itemstackiterator).getItem() == new ItemStack(TotemOfFluffItem.block, (int) (1)).getItem())) {
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (64 / 2d), y - (64 / 2d), z - (64 / 2d), x + (64 / 2d), y + (64 / 2d), z + (64 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (((0 == Math.round((Math.random() * 100))) && (entityiterator instanceof SheepEntity))) {
									if (!world.getWorld().isRemote) {
										ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), (entityiterator.getPosX()),
												(entityiterator.getPosY()), (entityiterator.getPosZ()), new ItemStack(Blocks.WHITE_WOOL, (int) (1)));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
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
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
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
}
