package MineDonalds.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BurgerButtom extends Item{

	public BurgerButtom(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabFood);
	}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minedonalds:BurgerButtom");
}
}
