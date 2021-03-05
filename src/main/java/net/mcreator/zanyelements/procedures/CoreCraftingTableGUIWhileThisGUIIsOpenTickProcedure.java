package net.mcreator.zanyelements.procedures;

@ZanyelementsModElements.ModElement.Tag
public class CoreCraftingTableGUIWhileThisGUIIsOpenTickProcedure extends ZanyelementsModElements.ModElement {

	public CoreCraftingTableGUIWhileThisGUIIsOpenTickProcedure(ZanyelementsModElements instance) {
		super(instance, 92);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency entity for procedure CoreCraftingTableGUIWhileThisGUIIsOpenTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency x for procedure CoreCraftingTableGUIWhileThisGUIIsOpenTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency y for procedure CoreCraftingTableGUIWhileThisGUIIsOpenTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency z for procedure CoreCraftingTableGUIWhileThisGUIIsOpenTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZanyelementsMod.LOGGER.warn("Failed to load dependency world for procedure CoreCraftingTableGUIWhileThisGUIIsOpenTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		double checkNumber = 0;
		double tally = 0;
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putString("outputName", " ");

			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		tally = (double) (-1);
		checkNumber = (double) (-1);
		for (int index0 = 0; index0 < (int) (9); index0++) {
			checkNumber = (double) ((checkNumber) + 1);
			if ((new ItemStack(PhilosophersStoneItem.block, (int) (1)).getItem() == (new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) ((checkNumber)))).getItem())) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("outputName", "9x Philosopher's Shard");

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
		for (int index1 = 0; index1 < (int) (9); index1++) {
			checkNumber = (double) ((checkNumber) + 1);
			if ((new ItemStack(Blocks.IRON_BLOCK, (int) (1)).getItem() == (new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) ((checkNumber)))).getItem())) {
				tally = (double) ((tally) + 1);
			}
			if ((((tally) >= 7) && (new ItemStack(EndstoneShardItem.block, (int) (1)).getItem() == (new Object() {
				public ItemStack getItemStack(int sltid) {
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) _ent).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								return ((Slot) ((Map) invobj).get(sltid)).getStack();
							}
						}
					}
					return ItemStack.EMPTY;
				}
			}.getItemStack((int) (4))).getItem()))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("outputName", "1x Condensed Iron");

					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}

	}

}
