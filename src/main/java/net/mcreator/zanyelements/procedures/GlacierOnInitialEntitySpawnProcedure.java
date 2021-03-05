package net.mcreator.zanyelements.procedures;

@ZanyelementsModElements.ModElement.Tag
public class GlacierOnInitialEntitySpawnProcedure extends ZanyelementsModElements.ModElement {

	public GlacierOnInitialEntitySpawnProcedure(ZanyelementsModElements instance) {
		super(instance, 187);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure GlacierOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure GlacierOnInitialEntitySpawn!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");

		double offset = 0;
		if ((world.getDifficulty() == Difficulty.EASY)) {
			offset = (double) 11;
		} else if ((world.getDifficulty() == Difficulty.NORMAL)) {
			offset = (double) 9;
		} else if ((world.getDifficulty() == Difficulty.HARD)) {
			offset = (double) 5;
		}
		if ((Math.round((Math.random() * (offset))) == 0)) {
			if (entity instanceof LivingEntity) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.LEATHER_HELMET, (int) (1)));
				else
					((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
							new ItemStack(Items.LEATHER_HELMET, (int) (1)));
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);

				GlacierOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
			}
		}
		if ((Math.round((Math.random() * (offset))) == 0)) {
			if (entity instanceof LivingEntity) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.LEATHER_CHESTPLATE, (int) (1)));
				else
					((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
							new ItemStack(Items.LEATHER_CHESTPLATE, (int) (1)));
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);

				GlacierOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
			}
		}
		if ((Math.round((Math.random() * (offset))) == 0)) {
			if (entity instanceof LivingEntity) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.LEATHER_LEGGINGS, (int) (1)));
				else
					((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
							new ItemStack(Items.LEATHER_LEGGINGS, (int) (1)));
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);

				GlacierOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
			}
		}
		if ((Math.round((Math.random() * (offset))) == 0)) {
			if (entity instanceof LivingEntity) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(Items.LEATHER_BOOTS, (int) (1)));
				else
					((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
							new ItemStack(Items.LEATHER_BOOTS, (int) (1)));
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);

				GlacierOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
			}
		}

	}

}
