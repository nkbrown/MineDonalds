package MineDonalds;

import MineDonalds.Mobs.EntityEmployee;
import MineDonalds.Mobs.RenderEmployee;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityEmployee.class, new RenderEmployee());
	}
}