package MineRonalds.Items;

import MineRonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class McStick extends Item{

	public McStick(int par1) {
		super(par1);
		this.setCreativeTab(Main.McTab2);
	}
	@Override
    public void registerIcons(IconRegister iconRegister)
    {
            itemIcon = iconRegister.registerIcon("mineronalds:McStick");
    }
}
