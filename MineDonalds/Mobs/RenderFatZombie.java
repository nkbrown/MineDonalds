package MineDonalds.Mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderFatZombie extends RenderLiving
{
    private static final ResourceLocation texture = new ResourceLocation("minedonalds:textures/entity/FatZombie.png");

    public RenderFatZombie(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return texture;
	}
}
