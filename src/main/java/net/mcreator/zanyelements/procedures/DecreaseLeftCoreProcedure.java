package net.mcreator.zanyelements.procedures;

import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.function.Supplier;
import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class DecreaseLeftCoreProcedure extends ZanyelementsModElements.ModElement {
	public DecreaseLeftCoreProcedure(ZanyelementsModElements instance) {
		super(instance, 127);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DecreaseLeftCore!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double tally = 0;
		tally = (double) (-1);
		for (int index0 = 0; index0 < (int) (9); index0++) {
			tally = (double) ((tally) + 1);
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) ((tally)))).decrStackSize((int) (1));
							_current.detectAndSendChanges();
						}
					}
				}
			}
		}
	}
}
