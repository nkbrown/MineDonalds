package MineDonalds;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import MineDonalds.Mobs.EntityEmployee;
import MineDonalds.Mobs.EntityFatZombie;
import MineDonalds.Mobs.EntityMcZombie;
import MineDonalds.Mobs.ModelFatZombie;
import MineDonalds.Mobs.RenderEmployee;
import MineDonalds.Mobs.RenderFatZombie;
import MineDonalds.Mobs.RenderMcZombie;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderers() {
		if(Main.mobEnable == true)
		{
		RenderingRegistry.registerEntityRenderingHandler(EntityEmployee.class, new RenderEmployee());
		RenderingRegistry.registerEntityRenderingHandler(EntityMcZombie.class, new RenderMcZombie());
		RenderingRegistry.registerEntityRenderingHandler(EntityFatZombie.class, new RenderFatZombie(new ModelFatZombie(), 0.3F));
		}
	}
	
	public void addArmor(String armor) {
		if(Main.armorEnable == true)
		{
		RenderingRegistry.addNewArmourRendererPrefix(armor);
		}
	}

}
