package MineDonalds.Items;

import java.util.List;

import MineDonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BigMac extends ItemFood{

	public BigMac(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setAlwaysEdible();
		this.setPotionEffect(Potion.moveSlowdown.id, 20, 1, 1.0F);
		this.setCreativeTab(Main.McTab3);
}
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minedonalds:BigMac");
}
	
	public void addInformation(ItemStack s, EntityPlayer p, List list, boolean flag)
	 {
	  list.add(EnumChatFormatting.DARK_PURPLE + "Eat me...");
	 }
	
	public void onItemUse(World world, Entity entity) {
		world.playSoundAtEntity(entity, "minedonalds:tune", 1, 1);
	}
}