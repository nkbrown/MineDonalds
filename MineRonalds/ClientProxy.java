package MineRonalds;

import MineRonalds.Mobs.EntityEmployee;
import MineRonalds.Mobs.EntityFatZombie;
import MineRonalds.Mobs.EntityMcZombie;
import MineRonalds.Mobs.ModelFatZombie;
import MineRonalds.Mobs.RenderEmployee;
import MineRonalds.Mobs.RenderFatZombie;
import MineRonalds.Mobs.RenderMcZombie;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityEmployee.class, new RenderEmployee());
		RenderingRegistry.registerEntityRenderingHandler(EntityMcZombie.class, new RenderMcZombie());
		RenderingRegistry.registerEntityRenderingHandler(EntityFatZombie.class, new RenderFatZombie(new ModelFatZombie(), 0.3F));
	}
	
	public void addArmor(String armor) {
		RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}