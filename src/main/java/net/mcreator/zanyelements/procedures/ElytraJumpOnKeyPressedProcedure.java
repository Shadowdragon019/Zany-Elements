package net.mcreator.zanyelements.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.zanyelements.enchantment.UpliftingEnchantment;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class ElytraJumpOnKeyPressedProcedure extends ZanyelementsModElements.ModElement {
	public ElytraJumpOnKeyPressedProcedure(ZanyelementsModElements instance) {
		super(instance, 249);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure ElytraJumpOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency x for procedure ElytraJumpOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency y for procedure ElytraJumpOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency z for procedure ElytraJumpOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure ElytraJumpOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double xOffset = 0;
		double zOffset = 0;
		if ((x < 0)) {
			xOffset = (double) (-1);
		}
		if ((z < 0)) {
			zOffset = (double) (-1);
		}
		if (((((EnchantmentHelper.getEnchantmentLevel(UpliftingEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY)) != 0))
				&& (!(world.isAirBlock(new BlockPos((int) (x + (xOffset)), (int) (y - 0.1), (int) (z + (zOffset)))))))
				&& (!(((PlayerEntity) entity).isElytraFlying())))) {
			entity.setMotion((entity.getMotion().getX()), (1 + (entity.getMotion().getY())), (entity.getMotion().getZ()));
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).startFallFlying();
			}
		}
	}
}
