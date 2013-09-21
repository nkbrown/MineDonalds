package MineRonalds.Blocks;

import java.util.Random;

import MineRonalds.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockMcDirtMcStone extends Block
{

    Block BlockID;
    public static Material blockMaterial;
    
    public BlockMcDirtMcStone(int par1, Material material) 
    {
            super(par1, material);
            this.blockMaterial = material;
            setCreativeTab(Main.McTab);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
            return blockID;
    }


    public int quantityDropped(Random random)
    {
            return 1;
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
            blockIcon = iconRegister.registerIcon("mineronalds" + ":" + this.getUnlocalizedName().substring(5));
    }

   @Override
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
            if(blockID == Main.McGrass.blockID)
            {
                    return true;
            }
            if(blockID == Main.McDirt.blockID)
            {
                    return true;
            }
            else
                    return false;
    }
}