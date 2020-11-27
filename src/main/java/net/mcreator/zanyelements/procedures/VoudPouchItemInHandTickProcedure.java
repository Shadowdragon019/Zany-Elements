package net.mcreator.zanyelements.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;

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
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).setDisplayName(
				new StringTextComponent((("Void Pouch | Level ") + "" + (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel"))) + "" + (" | ")
						+ "" + (((itemstack).getOrCreateTag().getDouble("consumedEndermen"))) + "" + ("/") + ""
						+ (Math.pow(2, (((itemstack).getOrCreateTag().getDouble("pouchCurrentLevel")) + 4))) + "" + (" Consumed Endermen"))));
	}
}
