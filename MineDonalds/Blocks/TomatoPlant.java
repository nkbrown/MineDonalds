package MineDonalds.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import MineDonalds.Main;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class TomatoPlant extends BlockCrops{
	
	@SideOnly(Side.CLIENT)
    public Icon[] iconArray;
	
	public TomatoPlant(int par1) {
		super(par1);
		
	}
	@Override
	public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 > 7)
        {
            par2 = 7;
        }

        return this.iconArray[par2];
    }
	@Override
	protected int getSeedItem()
    {
        return Main.TomatoSeeds.itemID;
    }
	@Override
	protected int getCropItem()
    {
        return Main.Tomato.itemID;
    }
	@Override
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[8];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(this.func_111023_E() + "_stage_" + i);
        }
    }
}
