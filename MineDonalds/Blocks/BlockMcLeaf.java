package MineDonalds.Blocks;

import MineDonalds.Main;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMcLeaf extends BlockMcDirtMcStone
{
	public BlockMcLeaf(int par1)
	{
		super(par1, Material.leaves);
		this.setCreativeTab(Main.McTab);
		this.setStepSound(soundGrassFootstep);
		this.setHardness(0.2F);
	}

	public boolean isOpaqueCube()
	{
		return false;
	}
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("minedonalds:McLeaf");
	}
}