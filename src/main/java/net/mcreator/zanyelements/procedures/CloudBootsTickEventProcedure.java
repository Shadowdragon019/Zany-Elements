package net.mcreator.zanyelements.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zanyelements.potion.Cloud9Potion;
import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.Map;

@ZanyelementsModElements.ModElement.Tag
public class CloudBootsTickEventProcedure extends ZanyelementsModElements.ModElement {
	public CloudBootsTickEventProcedure(ZanyelementsModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CloudBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Cloud9Potion.potion, (int) 60, (int) 0, (false), (false)));
	}
}
