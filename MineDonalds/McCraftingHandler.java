package MineDonalds;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class McCraftingHandler implements ICraftingHandler 
{

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		
		if (item.itemID == Main.McWand.itemID)
        {
                player.addStat(Main.wandAchieve, 1);
        }
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
		
	}

}