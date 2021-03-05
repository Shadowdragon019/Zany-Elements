package net.mcreator.zanyelements.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.zanyelements.enchantment.XpSiphonEnchantment;
import net.mcreator.zanyelements.enchantment.ArrowAttractorEnchantment;
import net.mcreator.zanyelements.enchantment.AnimalConductorEnchantment;
import net.mcreator.zanyelements.ZanyelementsModVariables;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

@ZanyelementsModElements.ModElement.Tag
public class VoudPouchRightClickedInAirProcedure extends ZanyelementsModElements.ModElement {
	public VoudPouchRightClickedInAirProcedure(ZanyelementsModElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure VoudPouchRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency itemstack for procedure VoudPouchRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency x for procedure VoudPouchRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency y for procedure VoudPouchRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency z for procedure VoudPouchRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure VoudPouchRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 2)) / 2d),
									y - (Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 2)) / 2d),
									z - (Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 2)) / 2d),
									x + (Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 2)) / 2d),
									y + (Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 2)) / 2d),
									z + (Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 2)) / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if ((entityiterator instanceof ItemEntity)) {
					{
						Entity _ent = entityiterator;
						_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.enderman.teleport")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.enderman.teleport")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				} else if ((entityiterator instanceof EndermanEntity)) {
					if (!entityiterator.world.isRemote())
						entityiterator.remove();
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.scream")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.scream")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if ((((itemstack).getOrCreateTag()
							.getDouble("pouchCurrentLevel")) < (ZanyelementsModVariables.MapVariables.get(world).voidPouchMaxLevel))) {
						(itemstack).getOrCreateTag().putDouble("consumedEndermen",
								(((itemstack).getOrCreateTag().getDouble("consumedEndermen")) + 1));
					}
					(itemstack).getOrCreateTag().putDouble("consumedEndermenTotal",
							(((itemstack).getOrCreateTag().getDouble("consumedEndermenTotal")) + 1));
				} else if (((entityiterator instanceof ExperienceOrbEntity)
						&& ((EnchantmentHelper.getEnchantmentLevel(XpSiphonEnchantment.enchantment, (itemstack)) != 0)))) {
					{
						Entity _ent = entityiterator;
						_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				} else if (((entityiterator instanceof ArrowEntity)
						&& ((EnchantmentHelper.getEnchantmentLevel(ArrowAttractorEnchantment.enchantment, (itemstack)) != 0)))) {
					{
						Entity _ent = entityiterator;
						_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				} else if (((entityiterator instanceof AnimalEntity)
						&& ((EnchantmentHelper.getEnchantmentLevel(AnimalConductorEnchantment.enchantment, (itemstack)) != 0)))) {
					{
						Entity _ent = entityiterator;
						_ent.setPositionAndUpdate((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
									_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
				}
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("consumedEndermen")) >= Math.pow(2,
				(((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 4)))) {
			(itemstack).getOrCreateTag().putDouble("consumedEndermen", (((itemstack).getOrCreateTag().getDouble("consumedEndermen"))
					- Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 4))));
			(itemstack).getOrCreateTag().putDouble("pouchCurrentLevel", (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 1));
		}
	}
}
