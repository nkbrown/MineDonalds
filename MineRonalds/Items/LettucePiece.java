package MineRonalds.Items;

import MineRonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LettucePiece extends Item{

	public LettucePiece(int par1) {
		super(par1);
		this.setCreativeTab(Main.McTab3);
	}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minedonalds:LettucePiece");
}
}
