package MineDonalds.Blocks;

import MineDonalds.Main;
import MineDonalds.Texture;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCake;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class CheeseBlock extends BlockCake {
    
    @SideOnly(Side.CLIENT)
    private Icon iconTop;
    @SideOnly(Side.CLIENT)
    private Icon iconBottom;
    @SideOnly(Side.CLIENT)
    private Icon iconInside;
    

    public CheeseBlock(int id) {
        super(id);
        this.setStepSound(soundClothFootstep);
        this.setHardness(0.5F);
        this.setCreativeTab(Main.McTab3);
    } 
    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int side, int metadata)
    {
        return side == 1 ? this.iconTop : (side == 0 ? this.iconBottom : (metadata > 0 && side == 4 ? this.iconInside : this.blockIcon));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = Texture.getIconFromTextureName(par1IconRegister, "CheeseSide");
        this.iconInside = Texture.getIconFromTextureName(par1IconRegister, "CheesesInside");
        this.iconTop = Texture.getIconFromTextureName(par1IconRegister, "CheeseTop");
        this.iconBottom = Texture.getIconFromTextureName(par1IconRegister, "CheeseBottom");
    }

}