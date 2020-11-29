package net.mcreator.zanyelements.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;

import net.mcreator.zanyelements.ZanyelementsModVariables;
import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class VoudPouchItemInHandTickProcedure extends ZanyelementsModElements.ModElement {
	public VoudPouchItemInHandTickProcedure(ZanyelementsModElements instance) {
		super(instance, 14);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure VoudPouchItemInHandTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure VoudPouchItemInHandTick!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) < (ZanyelementsModVariables.MapVariables.get(world).voidPouchMaxLevel))) {
			((itemstack)).setDisplayName(
					new StringTextComponent((("Void Pouch | Level ") + "" + (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel"))) + ""
							+ (" | ") + "" + (((itemstack).getOrCreateTag().getDouble("consumedEndermen"))) + "" + ("/") + ""
							+ (Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 4))) + "" + (" Consumed Endermen"))));
		} else {
			((itemstack)).setDisplayName(new StringTextComponent(
					(("Void Pouch | Level ") + "" + (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel"))) + "" + (" | ") + ""
							+ (((itemstack).getOrCreateTag().getDouble("consumedEndermenTotal"))) + "" + (" Total Consumed Endermen"))));
		}
	}
}
