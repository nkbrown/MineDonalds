package MineDonalds.Items;

import MineDonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class Fries extends ItemFood{

	public Fries(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setCreativeTab(Main.McTab2);
}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minedonalds:Fries");
		
}
}