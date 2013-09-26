package MineDonalds.Blocks;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import MineDonalds.Main;

public class LettucePlant extends TomatoPlant{

	public LettucePlant(int par1) {
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
        return Main.LettuceSeeds.itemID;
    }
	@Override
	protected int getCropItem()
    {
        return Main.LettucePiece.itemID;
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
