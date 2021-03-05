package net.mcreator.zanyelements.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.zanyelements.ZanyelementsModElements;
import net.mcreator.zanyelements.ZanyelementsMod;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class VoudPouchItemIsCraftedsmeltedProcedure extends ZanyelementsModElements.ModElement {
	public VoudPouchItemIsCraftedsmeltedProcedure(ZanyelementsModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency itemstack for procedure VoudPouchItemIsCraftedsmelted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		(itemstack).getOrCreateTag().putDouble("consumedEndermen", 0);
		(itemstack).getOrCreateTag().putDouble("consumedEndermenTotal", 0);
		(itemstack).getOrCreateTag().putDouble("pouchCurrentLevel", 0);
	}
}
