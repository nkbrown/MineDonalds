package MineDonalds;

import MineDonalds.Biomes.BiomeGenYellowTree;
import MineDonalds.Blocks.*;
import MineDonalds.Mobs.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "minedonalds", name = "MineDonalds", version = "4.0")
@NetworkMod(serverSideRequired = false, clientSideRequired = true)
/**
 * Hi
 * @author ilexiconn
 */
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
	
	/**
	 * The public static things!
	 */
	public static Block McGrass = new BlockMcGrass(201).setStepSound(Block.soundGrassFootstep).setHardness(0.5F).setUnlocalizedName("McGrass");
	public static Block McDirt = new BlockMcDirtMcStone(202, Material.ground).setStepSound(Block.soundGravelFootstep).setHardness(0.5F).setUnlocalizedName("McDirt");
	public static Block McStone = new BlockMcDirtMcStone(203, Material.rock).setHardness(2.0F).setUnlocalizedName("McStone");
	public static Block McLeaf = new BlockMcLeaf(204).setHardness(0.2F).setUnlocalizedName("McLeaf");
	public static Block McLog = new BlockMcLog(205).setHardness(2.0F).setUnlocalizedName("McLog");
	public static Block McVine = new BlockMcVine(206).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("McVine");
	public static BlockMcFire McFire = (BlockMcFire)new BlockMclFire(207).setUnlocalizedName("McFire");
	public static BlockMclPortal McPortal = (BlockMclPortal)new BlockMcPortal(208).setUnlocalizedName("McPortal");
	public static BlockMcSapling McSapling = (BlockMcSapling)new BlockMcSapling(209, 0).setUnlocalizedName("McSapling");
	
	public static Item McWand = new ItemMcWand(451).setUnlocalizedName("McWand");
	
	public static BiomeGenBase YellowTree = new BiomeGenYellowTree(41);
	public static int DimID = 2;
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
    		
    		/**
    		 * GameRegistry
    		 */
    		GameRegistry.registerBlock(McGrass, "McGrass");
    		GameRegistry.registerBlock(McDirt, "McDirt");
    		GameRegistry.registerBlock(McStone, "McStone");
    		GameRegistry.registerBlock(McLeaf, "McLeaf");
    		GameRegistry.registerBlock(McLog, "McLog");
    		GameRegistry.registerBlock(McVine, "McVine");
    		
    		/**
    		 * LanguageRegistry
    		 */
    		LanguageRegistry.addName(McGrass, "McGrass");
            LanguageRegistry.addName(McDirt, "McDirt");
            LanguageRegistry.addName(McStone, "McStone");
            LanguageRegistry.addName(McLeaf, "McLeaf");
            LanguageRegistry.addName(McLog, "McLog");
            LanguageRegistry.addName(McVine, "McVine");
            
}
}
