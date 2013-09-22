package MineDonalds.Blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import MineDonalds.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class HappyMineB extends Block{
	
	@SideOnly(Side.CLIENT)
    private Icon happyIconTop;
    @SideOnly(Side.CLIENT)
    private Icon happyIconFront;
    
	public HappyMineB(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(2.0F);
		setStepSound(Block.soundClothFootstep);
		setTickRandomly(true);
		
	}
	public int idDropped(int par1, Random par2Random, int par3)
	{
	return Main.Fries.itemID;
	}
	public int quantityDropped(Random random) {
		return random.nextInt(5);
	}
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.happyIconTop : (par1 == 0 ? this.happyIconTop : (par1 != par2 ? this.blockIcon : this.happyIconFront));
    }
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("minedonalds:happySide");
        this.happyIconFront = par1IconRegister.registerIcon("minedonalds:happyFront");
        this.happyIconTop = par1IconRegister.registerIcon("minedonalds:happyButtom");
    }
}
