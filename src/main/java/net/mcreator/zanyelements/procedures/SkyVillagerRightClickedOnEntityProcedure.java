package net.mcreator.zanyelements.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;
import java.util.Iterator;

@ZanyelementsModElements.ModElement.Tag
public class SkyVillagerRightClickedOnEntityProcedure extends ZanyelementsModElements.ModElement {
	public SkyVillagerRightClickedOnEntityProcedure(ZanyelementsModElements instance) {
		super(instance, 241);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure SkyVillagerRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SkyVillagerRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure SkyVillagerRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		double randomMessage = 0;
		if ((new ItemStack(Items.EMERALD, (int) (1))
				.getItem() == ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem())) {
			if (((world instanceof World) ? ((World) world).isDaytime() : false)) {
				if (((entity.getPersistentData().getDouble("avaliableElytras")) != 0)) {
					if ((((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
							.getCount()) >= 16)) {
						entity.getPersistentData().putDouble("avaliableElytras", ((entity.getPersistentData().getDouble("avaliableElytras")) - 1));
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((("<Azure Villager> Thank you for your purchase of a Elytra Rental! I have ") + ""
											+ ((entity.getPersistentData().getDouble("avaliableElytras"))) + "" + (" left."))),
									(false));
						}
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.EMERALD, (int) (1));
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 16,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.world.isRemote && _ent.world.getServer() != null) {
								_ent.world.getServer().getCommandManager().handleCommand(
										_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
										"give @p elytra{Enchantments:[{id:\"zanyelements:elytra_rental\",lvl:1s}]} 1");
							}
						}
						if (sourceentity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) sourceentity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("zanyelements:rent_a_elytra"));
							AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemaningCriteria().iterator();
								while (_iterator.hasNext()) {
									String _criterion = (String) _iterator.next();
									((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
								}
							}
						}
					} else {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent((("<Azure Villager> ") + ""
											+ (((((sourceentity instanceof LivingEntity)
													? ((LivingEntity) sourceentity).getHeldItemMainhand()
													: ItemStack.EMPTY)).getCount()))
											+ "" + (" isn't enough Emeralds, you need 16 Emeralds"))),
									(false));
						}
					}
				} else {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(
								new StringTextComponent(
										("" + ("<Azure Villager> I don't have anymore Elytras left, you're going to have to wait until tommorow!"))),
								(false));
					}
				}
			} else {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(
							new StringTextComponent(
									("" + ("<Azure Villager> Phantoms are fun. Bonk, bonk, bonk. Bonk, bonk, bonk. Get out. I need my sleep."))),
							(false));
				}
			}
		} else if ((new ItemStack(Items.STICK, (int) (1))
				.getItem() == ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem())) {
			randomMessage = (double) Math.round((Math.random() * 2));
			if (((randomMessage) == 0)) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
							("" + ("<Azure Villager> How'd I get here? I ate a Cloud in a Bottle with a chest of supplies, amazed it worked!"))),
							(false));
				}
			} else if (((randomMessage) == 1)) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
							("" + ("<Azure Villager> Why do they call me the 'Azure Villager'? Sky Villager sounds much nicer."))), (false));
				}
			} else if (((randomMessage) == 2)) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(
							new StringTextComponent(("" + ("<Azure Villafer> Why am I a blue blob? Give me decoration!"))), (false));
				}
			}
		} else {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity)
						.sendStatusMessage(new StringTextComponent((("<Azure Villager> Welcome to Elytra Rental Emporium! I have ") + ""
								+ ((entity.getPersistentData().getDouble("avaliableElytras"))) + ""
								+ (" Rental Elytras left and I sell them for 16 emeralds a piece!"))), (false));
			}
		}
	}
}
