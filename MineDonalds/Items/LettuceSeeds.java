package MineDonalds.Items;

import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class LettuceSeeds extends TomatoSeeds{

	public LettuceSeeds(int par1, int par2, int par3) {
		super(par1, par2, par3);
		
	}
	@Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return (EnumPlantType.Crop);
    }
}
