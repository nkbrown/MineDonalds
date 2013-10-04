package MineDonalds.Blocks;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import MineDonalds.Main;

public class LettucePlant extends TomatoPlant{

	public LettucePlant(int par1) {
		super(par1);
	}

	@Override
	protected int getSeedItem()
    {
        return Main.LettuceSeeds.itemID;
    }
	
	@Override
	protected int getCropItem()
    {
        return Main.LettucePiece.itemID;
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
            this.iconArray[i] = par1IconRegister.registerIcon("minedonalds:lettuce_stage_" + i);
        }

    }
}
