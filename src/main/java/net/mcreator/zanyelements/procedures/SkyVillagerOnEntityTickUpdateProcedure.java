package net.mcreator.zanyelements.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class SkyVillagerOnEntityTickUpdateProcedure extends ZanyelementsModElements.ModElement {
	public SkyVillagerOnEntityTickUpdateProcedure(ZanyelementsModElements instance) {
		super(instance, 240);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure SkyVillagerOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure SkyVillagerOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world instanceof World) ? ((World) world).isDaytime() : false)) {
			if ((!(entity.getPersistentData().getBoolean("isDay")))) {
				entity.getPersistentData().putDouble("avaliableElytras",
						((entity.getPersistentData().getDouble("avaliableElytras")) + (1 + Math.round(Math.random()))));
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(new StringTextComponent("I have more stock!"), ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent(("" + ((entity.getPersistentData().getDouble("avaliableElytras"))))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
			}
			entity.getPersistentData().putBoolean("isDay", (true));
		} else {
			entity.getPersistentData().putBoolean("isDay", (false));
		}
	}
}
