package MineDonalds;

import MineDonalds.Mobs.EntityEmployee;
import MineDonalds.Mobs.EntityFatZombie;
import MineDonalds.Mobs.EntityMcZombie;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "minedonalds", name = "MineDonalds", version = "4.0")
@NetworkMod(serverSideRequired = false, clientSideRequired = true)
//Last edited by iLexiconn
//16:18 (4:18 PM)
public class Main {
	
	/**
	 * Proxy stuff
	 */
	@SidedProxy(clientSide="MineDonalds.ClientProxy", serverSide="MineDonalds.ServerProxy")
	public static ServerProxy proxy;
	
	/**
	 * The Entity ID Registry
	 */
	static int startEntityId = 5;
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		}
		while (EntityList.getClassFromID(startEntityId) !=null);
	return startEntityId++;
	}
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
		
		
		
	}
	
	@EventHandler
    public void load(FMLInitializationEvent event) {
	
			/**
			 * The Proxy-registry
			 */
            proxy.registerRenderers();
            
            /**
             * Entity stuff
             */
            EntityRegistry.registerGlobalEntityID(EntityEmployee.class, "Employee", 1);
    		EntityRegistry.addSpawn(EntityEmployee.class, 1, 1, 4, EnumCreatureType.ambient);
    		EntityRegistry.findGlobalUniqueEntityId();
    		LanguageRegistry.instance().addStringLocalization("entity.Employee.name", "en_US", "McDonalds Employee");
    		LanguageRegistry.instance().addStringLocalization("entity.Employee.name", "nl_NL", "McDonalds Werknemer");
    		registerEntityEgg(EntityEmployee.class, 0xFF0000, 0xFFFF00);
    		
    		EntityRegistry.registerGlobalEntityID(EntityMcZombie.class, "McZombie", 2);
    		EntityRegistry.addSpawn(EntityMcZombie.class, 2, 2, 5, EnumCreatureType.ambient);
    		EntityRegistry.findGlobalUniqueEntityId();
    		LanguageRegistry.instance().addStringLocalization("entity.McZombie.name", "en_US", "McDimension Zombie");
    		LanguageRegistry.instance().addStringLocalization("entity.McZombie.name", "nl_NL", "McDimensie Zombie");
    		registerEntityEgg(EntityMcZombie.class, 0xFF0000, 0x096910);
    		
    		EntityRegistry.registerGlobalEntityID(EntityFatZombie.class, "FatZombie", 3);
    		EntityRegistry.addSpawn(EntityFatZombie.class, 2, 2, 5, EnumCreatureType.ambient);
    		EntityRegistry.findGlobalUniqueEntityId();
    		LanguageRegistry.instance().addStringLocalization("entity.FatZombie.name", "en_US", "Fat Zombie");
    		LanguageRegistry.instance().addStringLocalization("entity.FatZombie.name", "nl_NL", "Dikke Zombie");
    		registerEntityEgg(EntityFatZombie.class, 0xFF0000, 0x096910);
            
}
}
