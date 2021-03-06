package net.mcreator.zanyelements.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.zanyelements.enchantment.XpSiphonEnchantment;
import net.mcreator.zanyelements.enchantment.ArrowAttractorEnchantment;
import net.mcreator.zanyelements.enchantment.AnimalConductorEnchantment;
import net.mcreator.zanyelements.ZanyelementsModVariables;
import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;
import java.util.Iterator;

@ZanyelementsModElements.ModElement.Tag
public class VoudPouchItemInHandTickProcedure extends ZanyelementsModElements.ModElement {
	public VoudPouchItemInHandTickProcedure(ZanyelementsModElements instance) {
		super(instance, 31);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure VoudPouchItemInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency itemstack for procedure VoudPouchItemInHandTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure VoudPouchItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) < (ZanyelementsModVariables.MapVariables.get(world).voidPouchMaxLevel))) {
			((itemstack)).setDisplayName(
					new StringTextComponent((("Void Pouch | Level ") + "" + (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel"))) + ""
							+ (" | ") + "" + (((itemstack).getOrCreateTag().getDouble("consumedEndermen"))) + "" + ("/") + ""
							+ (Math.ceil((Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 4))
									* (ZanyelementsModVariables.MapVariables.get(world).voidPouchLevelUpRequirmentMultiplier))))
							+ "" + (" Consumed Endermen"))));
		} else {
			((itemstack)).setDisplayName(new StringTextComponent(
					(("Void Pouch | Level ") + "" + (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel"))) + "" + (" | ") + ""
							+ (((itemstack).getOrCreateTag().getDouble("consumedEndermenTotal"))) + "" + (" Total Consumed Endermen"))));
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("zanyelements:max_void_pouch"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
			if (((((EnchantmentHelper.getEnchantmentLevel(XpSiphonEnchantment.enchantment, (itemstack)) != 0))
					&& ((EnchantmentHelper.getEnchantmentLevel(AnimalConductorEnchantment.enchantment, (itemstack)) != 0)))
					&& ((EnchantmentHelper.getEnchantmentLevel(ArrowAttractorEnchantment.enchantment, (itemstack)) != 0)))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("zanyelements:suprem_max_void_pouch"));
					AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
		}
	}
}
