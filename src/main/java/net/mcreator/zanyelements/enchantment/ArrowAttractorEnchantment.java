
package net.mcreator.zanyelements.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.zanyelements.item.VoudPouchItem;
import net.mcreator.zanyelements.ZanyelementsModElements;

@ZanyelementsModElements.ModElement.Tag
public class ArrowAttractorEnchantment extends ZanyelementsModElements.ModElement {
	@ObjectHolder("zanyelements:arrow_attractor")
	public static final Enchantment enchantment = null;
	public ArrowAttractorEnchantment(ZanyelementsModElements instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("arrow_attractor"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.ALL, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(VoudPouchItem.block, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return false;
		}
	}
}
