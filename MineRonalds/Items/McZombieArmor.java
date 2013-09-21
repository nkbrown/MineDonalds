package MineRonalds.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import MineRonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class McZombieArmor extends ItemArmor {
	
private String texturePath = "minedonalds:";
private String iconPath = "minedonalds:";
private String type = "mczombie";

public McZombieArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
super(par1, par2EnumArmorMaterial, par3, par4);
this.setCreativeTab(Main.McTab2);
this.setArmorType(type.toLowerCase(), par4);
}
private void setArmorType(String type, int par4){
switch (par4){
case 0:
this.setUnlocalizedName(type + "helmet");
this.texturePath += "textures/armor/" + type +"_1.png";
this.iconPath += type + "_helmet";
break;
case 1:
this.setUnlocalizedName(type + "chestplate");
this.texturePath += "textures/armor/" + type  +"_1.png";
this.iconPath += type + "_chestplate";
break;
case 2:
this.setUnlocalizedName(type + "leggings");
this.texturePath += "textures/armor/" + type +"_2.png";
this.iconPath += type + "_leggings";
break;
case 3:
this.setUnlocalizedName(type + "boots");
this.texturePath += "textures/armor/" + type +"_1.png";
this.iconPath += type + "_boots";
break;
}
}
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister icon){
this.itemIcon = icon.registerIcon(this.iconPath);
}
public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer){
return this.texturePath;
}
}