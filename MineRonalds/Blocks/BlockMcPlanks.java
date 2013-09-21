package MineRonalds.Blocks;

import MineRonalds.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMcPlanks extends Block{

	public BlockMcPlanks(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Main.McTab);
		
	}
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("mineronalds:McPlanks");
	}
}
