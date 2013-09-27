package MineDonalds.Carpets;

import net.minecraft.util.Icon;
import MineDonalds.Main;

public class McPlanksCarpet extends McGrassCarpet{

	public McPlanksCarpet(int par1) {
		super(par1);
		
	}
@Override
public Icon getIcon(int par1, int par2)
{
    return Main.McPlanks.getIcon(par1, par2);
}
}
