package MineDonalds.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BurgerTop extends Item{

	public BurgerTop(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabFood);
	}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minedonalds:BurgerTop");
}
}
