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
		if (item.itemID == Main.BigMac.itemID)
        {
                player.addStat(Main.macAchieve, 1);
        }
		if (item.itemID == Main.CheeseBurger.itemID)
        {
                player.addStat(Main.cheeseAchieve, 1);
        }
		if (item.itemID == Main.BurgerButtom.itemID)
        {
                player.addStat(Main.breadAchieve, 1);
        }
		if (item.itemID == Main.BurgerTop.itemID)
        {
                player.addStat(Main.breadAchieve, 1);
        }
		
		if (item.itemID == Main.McGrassCarpet.blockID)
        {
                player.addStat(Main.carpetAchieve, 1);
        }
		if (item.itemID == Main.McDirtCarpet.blockID)
        {
                player.addStat(Main.carpetAchieve, 1);
        }
		if (item.itemID == Main.McStoneCarpet.blockID)
        {
                player.addStat(Main.carpetAchieve, 1);
        }
		if (item.itemID == Main.McLeafCarpet.blockID)
        {
                player.addStat(Main.carpetAchieve, 1);
        }
		if (item.itemID == Main.McLogCarpet.blockID)
        {
                player.addStat(Main.carpetAchieve, 1);
        }
		if (item.itemID == Main.McPlanksCarpet.blockID)
        {
                player.addStat(Main.carpetAchieve, 1);
        }
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
		
	}

}