
package net.mcreator.zanyelements.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.zanyelements.ZanyelementsModElements;

@ZanyelementsModElements.ModElement.Tag
public class TNTItem extends ZanyelementsModElements.ModElement {
	@ObjectHolder("zanyelements:tnt_helmet")
	public static final Item helmet = null;
	@ObjectHolder("zanyelements:tnt_chestplate")
	public static final Item body = null;
	@ObjectHolder("zanyelements:tnt_leggings")
	public static final Item legs = null;
	@ObjectHolder("zanyelements:tnt_boots")
	public static final Item boots = null;
	public TNTItem(ZanyelementsModElements instance) {
		super(instance, 73);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.TNT, (int) (1)), new ItemStack(Items.TNT_MINECART, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "tnt";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "zanyelements:textures/models/armor/tnt__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("tnt_boots"));
	}
}
