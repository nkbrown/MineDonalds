package MineDonalds;

import MineDonalds.Mobs.EntityEmployee;
import MineDonalds.Mobs.EntityMcZombie;
import MineDonalds.Mobs.RenderEmployee;
import MineDonalds.Mobs.RenderMcZombie;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityEmployee.class, new RenderEmployee());
		RenderingRegistry.registerEntityRenderingHandler(EntityMcZombie.class, new RenderMcZombie());
	}
}