
package net.mcreator.zanyelements.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.zanyelements.block.CharcoalBlockBlock;
import net.mcreator.zanyelements.ZanyelementsModElements;

@ZanyelementsModElements.ModElement.Tag
public class CharcoalBlockFFuel extends ZanyelementsModElements.ModElement {
	public CharcoalBlockFFuel(ZanyelementsModElements instance) {
		super(instance, 54);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(CharcoalBlockBlock.block, (int) (1)).getItem())
			event.setBurnTime(16000);
	}
}
