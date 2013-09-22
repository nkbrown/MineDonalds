package MineDonalds.Items;

import MineDonalds.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class HappyMine extends Item
{
	public HappyMine(int par1)
	{
		super(par1);
		setCreativeTab(Main.McTab3);
		this.setMaxStackSize(1);
        this.setMaxDamage(1);
		
	}
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int X, int Y, int Z, int par7, float par8, float par9, float par10)
	{
		if (!par3World.isRemote)
		{
			par3World.setBlock(X, Y + 1, Z, Main.HappyMineB.blockID);
			par1ItemStack.damageItem(2, par2EntityPlayer);
				return true;
			}
		else
			{par3World.setBlock(X, Y + 1, Z, Main.HappyMineB.blockID);
			par2EntityPlayer.addChatMessage("[MineDonalds] Be happy!");
			par1ItemStack.damageItem(2, par2EntityPlayer);
				return true;
			}
		}
	
	
	@Override
    public void registerIcons(IconRegister iconRegister)
    {
            itemIcon = iconRegister.registerIcon("minedonalds:HappyMeal");
    }
	
	@SideOnly(Side.CLIENT)
    protected String func_111208_A() 
	{
		return "minedonalds:HappyMeal";
	}
}