package MineDonalds;

import MineDonalds.Blocks.*;
import MineDonalds.Items.*;
import MineDonalds.Dimension.McWorldProvider;
import MineDonalds.Dimension.Biomes.BiomeGenMcBiome;
import MineDonalds.Dimension.Biomes.BiomeGenYellowTree;
import MineDonalds.Dimension.Event.McEvent;
import MineDonalds.Items.ItemMcWand;
import MineDonalds.Mobs.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
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
 * I have added little pieces of text due the whole project!
 * @author iLexiconn
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
	public static CreativeTabs McTab = new CreativeTabs("McTab"){
		public ItemStack getIconItemStack(){
			return new ItemStack(McGrass);
		}};
	public static CreativeTabs McTab2 = new CreativeTabs("McTab2"){
		public ItemStack getIconItemStack(){
			return new ItemStack(BigMac);
		}};
		
	public static Block McGrass = new BlockMcGrass(201).setStepSound(Block.soundGrassFootstep).setHardness(0.5F).setUnlocalizedName("McGrass");
	public static Block McDirt = new BlockMcDirtMcStone(202, Material.ground).setStepSound(Block.soundGravelFootstep).setHardness(0.5F).setUnlocalizedName("McDirt");
	public static Block McStone = new BlockMcDirtMcStone(203, Material.rock).setHardness(2.0F).setUnlocalizedName("McStone");
	public static Block McLeaf = new BlockMcLeaf(204).setHardness(0.2F).setUnlocalizedName("McLeaf");
	public static Block McLog = new BlockMcLog(205).setHardness(2.0F).setUnlocalizedName("McLog");
	public static Block McVine = new BlockMcVine(206).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("McVine");
	public static BlockMcFire McFire = (BlockMcFire)new BlockMcFire(207).setUnlocalizedName("McFire");
	public static BlockMcPortal McPortal = (BlockMcPortal)new BlockMcPortal(208).setUnlocalizedName("McPortal");
	public static BlockMcSapling McSapling = (BlockMcSapling)new BlockMcSapling(209, 0).setUnlocalizedName("McSapling");
	
	public static Item McWand = new ItemMcWand(451).setUnlocalizedName("McWand");
	public static Item BigMac = new BigMac(452, 30, 10.0F, false).setUnlocalizedName("BigMac");
	public static Item CheeseBurger = new CheeseBurger(453, 18, 4.0F, false).setUnlocalizedName("CheeseBurger");
	public static Item McChicken = new McChicken(454, 17, 3.5F, false).setUnlocalizedName("McChicken");
	public static Item McNuggets = new McNuggets(455, 7, 4.0F, true).setUnlocalizedName("McNuggets");
	public static Item Fries = new Fries(456, 10, 4.5F, false).setUnlocalizedName("Fries");
	public static Item Salad = new Salad(457, 8, 1.5F, true).setUnlocalizedName("Salad");
	public static Item CocaCola = new CocaCola(458, 0, 0, false).setUnlocalizedName("CocaCola");
	public static Item Fanta = new Fanta(459, 1, 0.1F, false).setUnlocalizedName("Fanta");
	
	public static BiomeGenBase YellowTree = new BiomeGenYellowTree(41);
	public static BiomeGenBase McBiome = new BiomeGenMcBiome(42);
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
    		 * Boring dimension stuff :c
    		 */
    		DimensionManager.registerProviderType(DimID, McWorldProvider.class, true);
    		DimensionManager.registerDimension(DimID, DimID);
    		MinecraftForge.EVENT_BUS.register(new McEvent());
    		GameRegistry.addBiome(YellowTree);
    		
    		
    		/**
    		 * GameRegistry
    		 */
    		GameRegistry.registerBlock(McGrass, "McGrass");
    		GameRegistry.registerBlock(McDirt, "McDirt");
    		GameRegistry.registerBlock(McStone, "McStone");
    		GameRegistry.registerBlock(McLeaf, "McLeaf");
    		GameRegistry.registerBlock(McLog, "McLog");
    		GameRegistry.registerBlock(McVine, "McVine");
    		GameRegistry.registerBlock(McSapling, "McSapling");
    		
    		/**
    		 * LanguageRegistry
    		 */
    		LanguageRegistry.addName(McGrass, "McGrass");
            LanguageRegistry.addName(McDirt, "McDirt");
            LanguageRegistry.addName(McStone, "McStone");
            LanguageRegistry.addName(McLeaf, "McLeaf");
            LanguageRegistry.addName(McLog, "McLog");
            LanguageRegistry.addName(McVine, "McVine");
            
            LanguageRegistry.addName(McWand, "McWand");
            LanguageRegistry.addName(McNuggets, "Chicken McNuggets");
            LanguageRegistry.addName(CheeseBurger, "Cheeseburger");
            LanguageRegistry.addName(BigMac, "Big Mac");
            LanguageRegistry.addName(McChicken, "McChicken");
            LanguageRegistry.addName(Fries, "World Famous Fries");
            LanguageRegistry.addName(Salad, "Premium Bacon Ranch Salad");
            LanguageRegistry.addName(CocaCola, "Coca-Cola");
            LanguageRegistry.addName(Fanta, "Fanta");
            
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab", "MineDonalds Blocks");
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab2", "MineDonalds Items");
            
}
}
