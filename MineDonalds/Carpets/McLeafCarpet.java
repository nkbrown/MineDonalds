package MineDonalds.Carpets;

import net.minecraft.util.Icon;
import MineDonalds.Main;

public class McLeafCarpet extends McGrassCarpet{

	public McLeafCarpet(int par1) {
		super(par1);
		
	}
@Override
public Icon getIcon(int par1, int par2)
{
    return Main.McLeaf.getIcon(par1, par2);
}
}
