package MineDonalds.Items;

import MineDonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class Fanta extends ItemFood{

	public Fanta(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setAlwaysEdible();
		this.setPotionEffect(Potion.regeneration.id, 100, 2, 1.0F);
		this.setCreativeTab(Main.McTab3);
}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minedonalds:Fanta");
}
}