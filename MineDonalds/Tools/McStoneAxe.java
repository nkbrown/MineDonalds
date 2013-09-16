package MineDonalds.Tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class McStoneAxe extends ItemAxe{

	public McStoneAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		
	}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minedonalds:McStoneAxe");
	}
}