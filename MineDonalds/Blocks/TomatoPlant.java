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
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 7)
        {
            if (par2 == 6)
            {
                par2 = 5;
            }

            return this.iconArray[par2 >> 1];
        }
        else
        {
            return this.iconArray[3];
        }
    }
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[7];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon("minedonalds:tomato_stage_" + i);
        }

    }
	
}
