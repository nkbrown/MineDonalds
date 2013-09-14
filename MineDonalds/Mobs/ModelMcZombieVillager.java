package MineDonalds.Mobs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelMcZombieVillager extends ModelMcZombie
{
    public ModelMcZombieVillager()
    {
        this(0.0F, 0.0F, false);
    }

    public ModelMcZombieVillager(float par1, float par2, boolean par3)
    {
    }

    public int func_82897_a()
    {
        return 10;
    }
}