
package net.mcreator.zanyelements.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;

import net.mcreator.zanyelements.procedures.AncientIronFilledChaliceFoodEatenProcedure;
import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.Map;
import java.util.HashMap;

@ZanyelementsModElements.ModElement.Tag
public class AncientIronFilledChaliceItem extends ZanyelementsModElements.ModElement {
	@ObjectHolder("zanyelements:ancient_iron_filled_chalice")
	public static final Item block = null;
	public AncientIronFilledChaliceItem(ZanyelementsModElements instance) {
		super(instance, 222);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(1f).setAlwaysEdible().build()));
			setRegistryName("ancient_iron_filled_chalice");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 48;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(GoldenChaliceItem.block, (int) (1));
			super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				AncientIronFilledChaliceFoodEatenProcedure.executeProcedure($_dependencies);
			}
			if (itemstack.isEmpty()) {
				return retval;
			} else {
				if (entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity) entity;
					if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
						player.dropItem(retval, false);
				}
				return itemstack;
			}
		}
	}
}
