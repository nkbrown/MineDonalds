package MineDonalds.Items;

import MineDonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class CocaCola extends ItemFood{

	public CocaCola(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setAlwaysEdible();
		this.setPotionEffect(Potion.regeneration.id, 150, 3, 1.0F);
		this.setCreativeTab(Main.McTab2);
}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minedonalds:CocaCola");
}
}