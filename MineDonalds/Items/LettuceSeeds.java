package MineDonalds.Items;

import MineDonalds.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class LettuceSeeds extends TomatoSeeds{

	public LettuceSeeds(int par1, int par2, int par3) {
		super(par1, par2, par3);
		this.setCreativeTab(Main.McTab2);
		
	}
	@Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return (EnumPlantType.Crop);
    }
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("minedonalds:lettuceSeeds");
}
}
