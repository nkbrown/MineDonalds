package MineRonalds.Tools;

import MineRonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class McStoneHoe extends ItemHoe{

	public McStoneHoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Main.McTab2);
	}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("mineronalds:McStoneHoe");
	}
}
