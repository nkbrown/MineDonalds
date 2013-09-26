package MineDonalds.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class TomatoSeeds extends ItemSeeds{

	public TomatoSeeds(int par1, int par2, int par3) {
		super(par1, par2, par3);
		
	}
	@Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return (EnumPlantType.Crop);
    }
}
