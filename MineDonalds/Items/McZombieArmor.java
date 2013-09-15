package MineDonalds.Items;

import MineDonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class McZombieArmor extends ItemArmor{

	public McZombieArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4, String armornamePrefix) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		par2EnumArmorMaterial.getDamageReductionAmount(par4);
		this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
		this.maxStackSize = 1;
		this.setCreativeTab(Main.McTab2);
		armorNamePrefix = armornamePrefix;
		
	}
	public String armorNamePrefix;
	public EnumArmorMaterial material;
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if(stack.toString().contains("leggings")) {
			return "minedonalds:textures/armor/" + "mczombie" + "_2.png";
		}
		if(stack.toString().contains("Leggings")) if(itemID == Main.McZombieLeggings.itemID){
			return "minedonalds:textures/armor/" + "mczombie" + "_2.png";
		}
		return "minedonalds:textures/armor/" + "mczombie" + "_1.png";
	}
	public void registerIcon(IconRegister par1iconRegister) {
		if(itemID == Main.McZombieHelmet.itemID) {
			itemIcon = par1iconRegister.registerIcon("minedonalds:mczombie_helmet");
		}
		if(itemID == Main.McZombieChestplate.itemID) {
			itemIcon = par1iconRegister.registerIcon("minedonalds:mczombie_chestplate");
		}
		if(itemID == Main.McZombieLeggings.itemID) {
			itemIcon = par1iconRegister.registerIcon("minedonalds:mczombie_leggings");
		}
		if(itemID == Main.McZombieBoots.itemID) {
			itemIcon = par1iconRegister.registerIcon("minedonalds:mczombie_boots");
		}
	}
}