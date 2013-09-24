package MineDonalds;

import java.io.File;
import java.util.HashMap;

import MineDonalds.Blocks.*;
import MineDonalds.Carpets.McDirtCarpet;
import MineDonalds.Carpets.McGrassCarpet;
import MineDonalds.Carpets.McStoneCarpet;
import MineDonalds.Dimension.McWorldProvider;
import MineDonalds.Dimension.Biomes.BiomeGenMcBiome;
import MineDonalds.Dimension.Biomes.BiomeGenYellowTree;
import MineDonalds.Dimension.Event.McEvent;
import MineDonalds.Items.*;
import MineDonalds.Mobs.*;
import MineDonalds.Tools.McStoneAxe;
import MineDonalds.Tools.McStoneHoe;
import MineDonalds.Tools.McStonePickaxe;
import MineDonalds.Tools.McStoneShovel;
import MineDonalds.Tools.McStoneSword;
import MineDonalds.Tools.McWoodAxe;
import MineDonalds.Tools.McWoodHoe;
import MineDonalds.Tools.McWoodPickaxe;
import MineDonalds.Tools.McWoodShovel;
import MineDonalds.Tools.McWoodSword;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.*;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.RecipesTools;
import net.minecraft.src.BaseMod;
import net.minecraft.stats.Achievement;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = "minedonalds", name = "iLexiconn's MineDonalds", version = "1.1.1")
@NetworkMod(serverSideRequired = false, clientSideRequired = true)


/**
 * Hi
 * @authors iLexiconn Modding Team
 */

public class Main {

	/**
	 * Proxy stuff
	 */
	@SidedProxy(clientSide="MineDonalds.ClientProxy", serverSide="MineDonalds.ServerProxy")
	public static ServerProxy proxy;
	static Configuration config;
	@Instance("minedonalds")
	public static Main instance;
	
	/**
	 * Int things
	 */
	public static Block McGrass;
	public static Block McDirt;
	public static Block McStone;
	public static Block McLeaf;
	public static Block McLog;
	public static Block McPlanks;
	public static Block McVine;
	public static BlockMcFire McFire;
	public static BlockMcPortal McPortal;
	public static BlockMcSapling McSapling;
	public static Item McWand;
	public static Item McStick;
	public static Item BigMac;
	public static Item CheeseBurger;
	public static Item McChicken;
	public static Item McNuggets;
	public static Item Fries;
	public static Item Salad;
	public static Item CocaCola;
	public static Item Fanta;
	public static Item McFlurry;
	public static Item McWrap;
	public static Item Apple;
	public static Item Milk;
	public static Item McZombieHelmet;
	public static Item McZombieChestplate;
	public static Item McZombieLeggings;
	public static Item McZombieBoots;
	public static Item McStoneSword;
	public static Item McStonePickaxe;
	public static Item McStoneAxe;
	public static Item McStoneShovel;
	public static Item McStoneHoe;
	public static Item McWoodSword;
	public static Item McWoodPickaxe;
	public static Item McWoodAxe;
	public static Item McWoodShovel;
	public static Item McWoodHoe;
	public static BiomeGenBase YellowTree;
	public static BiomeGenBase McBiome;
	public static int DimID;
	public static Item BurgerButtom;
	public static Item BurgerTop;
	public static Item LettucePiece;
	public static Item Tomato;
	public static Item Cheese;
	public static Item HappyMine;
	public static Block HappyMineB;
	public static Block McGrassCarpet;
	public static Block McDirtCarpet;
	public static Block McStoneCarpet;
	
	
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
	 * IDFix stuff
	 */
	
	static String blockList[]=new String[4096];
	static HashMap<String,Integer> blockMapping=new HashMap<String,Integer>();
	static String itemList[]=new String[32000];
	static HashMap<String,Integer> itemMapping=new HashMap<String,Integer>();
	static String enchantmentList[]=new String[256];
	static HashMap<String,Integer> enchantmentMapping=new HashMap<String,Integer>();
	static boolean isBlockItem;
	public static String getModNamespace(){
		String res=null;
		isBlockItem=false;
		
		try {
			throw new Exception();
		} catch (Exception ex) {
			StackTraceElement[] stack=ex.getStackTrace();
			
			for(StackTraceElement e: ex.getStackTrace()){
				Class<?> cl=null;
				
				try {
					cl = Class.forName(e.getClassName());
				} catch (ClassNotFoundException ee) {
					continue;
				}
				
				if(ItemBlock.class.isAssignableFrom(cl)) isBlockItem=true;
				
				if(cl.getName().startsWith("sun."))continue;
				if(cl.getName().startsWith("cpw.mods.fml."))continue;
				if(cl.getName().startsWith("java."))continue;
				if(Block.class.isAssignableFrom(cl)) continue;
				if(Item.class.isAssignableFrom(cl)) continue;
				if(Enchantment.class.isAssignableFrom(cl)) continue;
				if(Main.class.isAssignableFrom(cl)) continue;
				
				if(res==null)
					res=e.getClassName();
				
				if (BaseMod.class.isAssignableFrom(cl)){
					res=e.getClassName();
					break;
				}
				if (cl.isAnnotationPresent(Mod.class)) {
					res=e.getClassName();
					break;
				}
			}
		}
		
		return res;
	}
	static void loadConfig(){
		if(config!=null) return;
		
		Configuration cfg=new Configuration(new File("minedonalds.txt"));
		cfg.load();
		config = cfg;
		
		for(int i=0;i<blockList.length;i++){
			Property p=getBlockId(i,"");
			if(p==null) continue;
			
			blockList[i]=p.getString();
			blockMapping.put(blockList[i],i);
		}
		
		for(int i=0;i<itemList.length;i++){
			Property p=getItemId(i,"");
			if(p==null) continue;
			
			itemList[i]=p.getString();
			itemMapping.put(itemList[i],i);
		}
		
		for(int i=0;i<enchantmentList.length;i++){
			Property p=getEnchantmentId(i,"");
			if(p==null) continue;
			
			enchantmentList[i]=p.getString();
			enchantmentMapping.put(enchantmentList[i],i);
		}
	}
	static Property getBlockId(int id,String def){
		return getId("blocks","%04d", id, def);
	}
	static Property getItemId(int id,String def){
		return getId("items","%05d", id, def);
	}
	static Property getEnchantmentId(int id,String def){
		return getId("enchantments","%03d", id, def);
	}
	static Property getId(String category,String keyMask,int id,String def){
		String key=String.format(keyMask,id);
		
		if(! config.hasKey(category, key) && def.isEmpty()) return null;
		
		return config.get(category, key, def);
	}
	public static int transformBlockId(int blockId) {
		if(Block.field_111034_cE==null) return blockId;
		loadConfig();
		
		String key=getModNamespace()+"|"+blockId;
		if(blockMapping.containsKey(key))
			blockId=blockMapping.get(key);
		
    	int lower=0x100;
    	int upper=Block.blocksList.length;
    	
    	if(blockId<0 || blockId>=blockList.length)
    		blockId=upper-1;
    	
        for(int possibleId=upper;possibleId>=lower;possibleId--){
        	int id=possibleId==upper?blockId:possibleId;
        	
        	if(Block.blocksList[id]!=null) continue;
        	if(itemList[id]!=null) continue;
       	
        	boolean empty=blockList[id]==null;
        	boolean fits=!empty && blockList[id].equals(key);
        	if(!empty && !fits) continue;
        	
        	if(empty && config!=null){
        		blockList[id]=key;
        		blockMapping.put(key, id);
        		getBlockId(id,key).set(key);
        		config.save();
        	}
        	
        	if(id!=blockId){
        		if(itemList[blockId]!=null)
        			System.out.println("[MineDonalds] changing block id for "+key+" because of conflict with item "+itemList[blockId]+"; from "+blockId+" to "+id);
        		else
        			System.out.println("[MineDonalds] changing block id for "+key+" because of conflict with block "+blockList[blockId]+"; from "+blockId+" to "+id);
        	}
        	
        	return id;
        }
        
    	return blockId;
	}
	public static int transformItemId(int itemId) {
		if(Item.recordWait==null) return itemId;
		loadConfig();
		
		int shiftedItemId=itemId+0x100;
    	
		String namespace=getModNamespace();
		String key=namespace+"|"+itemId;
		String blockKey=namespace+"|"+shiftedItemId;
		
		/* this is a normal block item */
    	if(shiftedItemId>=0 && shiftedItemId<Block.blocksList.length && Block.blocksList[shiftedItemId]!=null && isBlockItem)
    		return itemId;
    	
    	/* this is a block item, but not inherited from ItemBlock */
    	Integer itemBlockId=blockMapping.get(blockKey);
    	if(itemBlockId!=null)
    		return itemBlockId-0x100;

    	if(itemMapping.containsKey(key)){
			itemId=itemMapping.get(key);
			shiftedItemId=itemId+0x100;
		}
		
    	int lower=0x100;
    	int upper=Item.itemsList.length-0x100;
    	
    	if(itemId<0 || itemId+0x100>=itemList.length)
    		itemId=upper-1;
    	
        for(int possibleId=upper;possibleId>=lower;possibleId--){
        	int id=possibleId==upper?itemId:possibleId;
        	int shiftedId=id+0x100;
        	
        	if(Item.itemsList[shiftedId]!=null) continue;
        	if(shiftedId>0 && shiftedId<blockList.length && blockList[shiftedId]!=null)
        		continue;
        	
        	boolean empty=itemList[id]==null;
        	boolean fits=!empty && itemList[id].equals(key);
        	if(!empty && !fits) continue;
        	
        	if(empty && config!=null){
        		itemList[id]=key;
        		itemMapping.put(key, id);
        		getItemId(id,key).set(key);
        		config.save();
        	}
        	
        	if(id!=itemId){
        		if(shiftedItemId>0 && shiftedItemId<blockList.length && blockList[shiftedItemId]!=null)
            		System.out.println("Idfix: changing item id for "+key+" because of conflict with block "+blockList[shiftedItemId]+"; from "+itemId+" to "+id);
        		else
        			System.out.println("Idfix: changing item id for "+key+" because of conflict with item "+itemList[itemId]+"; from "+itemId+" to "+id);
        	}
        	
        	return id;
        }
        
    	return itemId;
	}
	public static int transformEnchantmentId(int enchantmentId) {
		if(Enchantment.infinity==null) return enchantmentId;
		loadConfig();
		
		String key=getModNamespace()+"|"+enchantmentId;
		if(enchantmentMapping.containsKey(key))
			enchantmentId=enchantmentMapping.get(key);
		
    	int lower=0;
    	int upper=0x100;
    	
    	if(enchantmentId<0 || enchantmentId>=enchantmentList.length)
    		enchantmentId=upper-1;
    	
        for(int possibleId=upper;possibleId>=lower;possibleId--){
        	int id=possibleId==upper?enchantmentId:possibleId;
        	
        	if(Enchantment.enchantmentsList[id]!=null) continue;
        	
        	boolean empty=enchantmentList[id]==null;
        	boolean fits=!empty && enchantmentList[id].equals(key);
        	if(!empty && !fits) continue;
        	
        	if(empty && config!=null){
        		enchantmentList[id]=key;
        		enchantmentMapping.put(key, id);
        		getEnchantmentId(id,key).set(key);
        		config.save();
        	}
        	
        	if(id!=enchantmentId)
        		System.out.println("Idfix: changing enchantment id for "+key+" because of conflict with "+enchantmentList[enchantmentId]+"; from "+enchantmentId+" to "+id);
        	
        	return id;
        }
        
    	return enchantmentId;
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
			return new ItemStack(McWand);
		}};
	public static CreativeTabs McTab3 = new CreativeTabs("McTab3"){

		public ItemStack getIconItemStack(){
			return new ItemStack(BigMac);
		}};
	public static CreativeTabs McTab4 = new CreativeTabs("McTab4"){

		public ItemStack getIconItemStack(){
			return new ItemStack(McGrassCarpet);
		}};
	public static EnumArmorMaterial armorMcZombie = EnumHelper.addArmorMaterial("MCZOMBIE", 15, new int[]{2, 7, 5, 2}, 99);
	public static EnumToolMaterial toolMcStone = EnumHelper.addToolMaterial("MCSTONE", 2, 242, 4.5F, 1.5F, 99);
	public static EnumToolMaterial toolMcWood = EnumHelper.addToolMaterial("MCWOOD", 1, 69, 2.5F, 0.5F, 99);
	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		McConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator  +"MineDonalds" + ".cfg"));
	McGrass = new BlockMcGrass(201).setStepSound(Block.soundGrassFootstep).setHardness(0.5F).setUnlocalizedName("McGrass");
	McDirt = new BlockMcDirtMcStone(202, Material.ground).setStepSound(Block.soundGravelFootstep).setHardness(0.5F).setUnlocalizedName("McDirt");
	McStone = new BlockMcDirtMcStone(203, Material.rock).setHardness(2.0F).setUnlocalizedName("McStone");
	McLeaf = new BlockMcLeaf(204).setHardness(0.2F).setUnlocalizedName("McLeaf");
	McLog = new BlockMcLog(205).setHardness(2.0F).setUnlocalizedName("McLog");
	McPlanks = new BlockMcPlanks(206, Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("McWood");
	McVine = new BlockMcVine(207).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("McVine");
	McFire = (BlockMcFire)new BlockMcFire(208).setUnlocalizedName("McFire");
	McPortal = (BlockMcPortal)new BlockMcPortal(209).setUnlocalizedName("McPortal");
	McSapling = (BlockMcSapling)new BlockMcSapling(210, 0).setUnlocalizedName("McSapling");
	
	McWand = new ItemMcWand(451).setUnlocalizedName("McWand");
	McStick = new McStick(483).setUnlocalizedName("McStick");
	BigMac = new BigMac(452, 30, 10.0F, false).setUnlocalizedName("BigMac");
	CheeseBurger = new CheeseBurger(453, 18, 4.0F, false).setUnlocalizedName("CheeseBurger");
	McChicken = new McChicken(454, 17, 3.5F, false).setUnlocalizedName("McChicken");
	McNuggets = new McNuggets(455, 7, 4.0F, true).setUnlocalizedName("McNuggets");
	Fries = new Fries(456, 10, 4.5F, false).setUnlocalizedName("Fries");
	Salad = new Salad(457, 8, 1.5F, true).setUnlocalizedName("Salad");
	CocaCola = new CocaCola(458, 0, 0, false).setUnlocalizedName("CocaCola");
	Fanta = new Fanta(459, 1, 0.1F, false).setUnlocalizedName("Fanta");
	McFlurry = new McFlurry(460, 1, 1.2F, false).setUnlocalizedName("McFlurry");
	McWrap = new McWrap(461, 2, 1.6F, true).setUnlocalizedName("McWrap");
	Apple = new Apple(462, 2, 1.8F, true).setUnlocalizedName("Apple");
	Milk = new Milk(463, 3, 2.0F, true).setUnlocalizedName("Milk");
	
	McZombieHelmet = new McZombieArmor(464, armorMcZombie, 0, 0).setUnlocalizedName("McZombieHelmet");
	McZombieChestplate = new McZombieArmor(465, armorMcZombie, 0, 1).setUnlocalizedName("McZombieChestplate");
	McZombieLeggings = new McZombieArmor(466, armorMcZombie, 0, 2).setUnlocalizedName("McZombieLeggings");
	McZombieBoots = new McZombieArmor(467, armorMcZombie, 0, 3).setUnlocalizedName("McZombieBoots");
	
	McStoneSword = new McStoneSword(468, toolMcStone).setUnlocalizedName("McStoneSword");
	McStonePickaxe = new McStonePickaxe(469, toolMcStone).setUnlocalizedName("McStonePickaxe");
	McStoneAxe = new McStoneAxe(470, toolMcStone).setUnlocalizedName("McStoneAxe");
	McStoneShovel = new McStoneShovel(471, toolMcStone).setUnlocalizedName("McStoneShovel");
	McStoneHoe = new McStoneHoe(472, toolMcStone).setUnlocalizedName("McStoneHoe");
	
	McWoodSword = new McWoodSword(473, toolMcWood).setUnlocalizedName("McWoodSword");
	McWoodPickaxe = new McWoodPickaxe(474, toolMcWood).setUnlocalizedName("McWoodPickaxe");
	McWoodAxe = new McWoodAxe(475, toolMcWood).setUnlocalizedName("McWoodAxe");
	McWoodShovel = new McWoodShovel(476, toolMcWood).setUnlocalizedName("McWoodShovel");
	McWoodHoe = new McWoodHoe(477, toolMcWood).setUnlocalizedName("McWoodHoe");

	YellowTree = new BiomeGenYellowTree(41);
	McBiome = new BiomeGenMcBiome(42);
	DimID = 2;
	
	BurgerButtom = new BurgerButtom(478).setUnlocalizedName("BurgerButtom");
	BurgerTop = new BurgerTop(479).setUnlocalizedName("BurgerTop");
	LettucePiece = new LettucePiece(480).setUnlocalizedName("LettucePiece");
	Tomato = new Tomato(481).setUnlocalizedName("Tomato");
	Cheese = new Cheese(482).setUnlocalizedName("Cheese");
	
	HappyMine = new HappyMine(484).setUnlocalizedName("HappyMine");
	HappyMineB = new HappyMineB(211, Material.rock).setUnlocalizedName("HappyMineB");
	
	McGrassCarpet = (new McGrassCarpet(212)).setHardness(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("mineCarpet").setLightOpacity(0);
	McDirtCarpet = (new McDirtCarpet(213)).setHardness(0.1F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("mineCarpet1").setLightOpacity(0);
	McStoneCarpet = (new McStoneCarpet(214)).setHardness(0.1F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("mineCarpet2").setLightOpacity(0);
	
	}
	
	//static final Achievement macAchieve = new Achievement(2002, "MacAchieve", 0, 0, BigMac, null).registerAchievement();
	//static final Achievement wandAchieve = new Achievement(2001, "WandAchieve", 2, 1, McWand, macAchieve).registerAchievement().setSpecial();
	
	//static final Achievement cheeseAchieve = new Achievement(2003, "CheeseAchieve", 4, -1, CheeseBurger, null).registerAchievement();
	//public static McCraftingHandler craftHandler = new McCraftingHandler();
	//public static AchievementPage page1 = new AchievementPage("MineDonalds", wandAchieve, macAchieve, cheeseAchieve);
	
	
	
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
    		EntityRegistry.findGlobalUniqueEntityId();
    		LanguageRegistry.instance().addStringLocalization("entity.Employee.name", "en_US", "MineDonalds Employee");
    		registerEntityEgg(EntityEmployee.class, 0xFF0000, 0xFFFF00);
    		
    		EntityRegistry.registerGlobalEntityID(EntityMcZombie.class, "McZombie", 2);
    		EntityRegistry.findGlobalUniqueEntityId();
    		LanguageRegistry.instance().addStringLocalization("entity.McZombie.name", "en_US", "MineDimension Zombie");
    		registerEntityEgg(EntityMcZombie.class, 0xFF0000, 0x096910);
    		
    		EntityRegistry.registerGlobalEntityID(EntityFatZombie.class, "FatZombie", 3);
    		EntityRegistry.findGlobalUniqueEntityId();
    		LanguageRegistry.instance().addStringLocalization("entity.FatZombie.name", "en_US", "Fat Zombie");
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
    		GameRegistry.registerBlock(McGrass, "MineGrass");
    		GameRegistry.registerBlock(McDirt, "MineDirt");
    		GameRegistry.registerBlock(McStone, "MineStone");
    		GameRegistry.registerBlock(McLeaf, "MineLeaf");
    		GameRegistry.registerBlock(McLog, "MineLog");
    		GameRegistry.registerBlock(McVine, "MineVine");
    		GameRegistry.registerBlock(McSapling, "MineSapling");
    		
    		GameRegistry.registerBlock(McGrassCarpet, "McGrassCarpet");
    		GameRegistry.registerBlock(McDirtCarpet, "McDirtCarpet");
    		GameRegistry.registerBlock(McStoneCarpet, "McStoneCarpet");
    		
    		GameRegistry.registerCraftingHandler(new McCraftingHandler());
    		//AchievementPage.registerAchievementPage(page1);
    		
    		/**
    		 * LanguageRegistry
    		 */
    		LanguageRegistry.addName(McGrass, "MineDimension Grass");
            LanguageRegistry.addName(McDirt, "MineDimension Dirt");
            LanguageRegistry.addName(McStone, "MineDimension Stone");
            LanguageRegistry.addName(McLeaf, "MineTree Leaf");
            LanguageRegistry.addName(McLog, "MineTree Log");
            LanguageRegistry.addName(McVine, "MineTree Vine");
            LanguageRegistry.addName(McSapling, "MineTree Sapling");
            LanguageRegistry.addName(McPlanks, "MineTree Planks");
            
            LanguageRegistry.addName(McWand, "MineWand");
            LanguageRegistry.addName(McStick, "MineStick");
            LanguageRegistry.addName(McNuggets, "Chicken MineNuggets");
            LanguageRegistry.addName(CheeseBurger, "Cheesy MineBurger");
            LanguageRegistry.addName(BigMac, "Big Mine");
            LanguageRegistry.addName(McChicken, "MineChicken");
            LanguageRegistry.addName(Fries, "Mine Fries");
            LanguageRegistry.addName(Salad, "Premium Mine Salad");
            LanguageRegistry.addName(CocaCola, "Mine-Cola");
            LanguageRegistry.addName(Fanta, "Fanta");
            LanguageRegistry.addName(McFlurry, "MineFlurry");
			LanguageRegistry.addName(McWrap, "MineWrap)");
            LanguageRegistry.addName(Apple, "MineApple");
            LanguageRegistry.addName(Milk, "1% Low Fat Mine Milk");
            
            LanguageRegistry.addName(BurgerButtom, "Burger Bread (Buttom)");
            LanguageRegistry.addName(BurgerTop, "Burger Bread (Top)");
            LanguageRegistry.addName(LettucePiece, "Lettuce Piece");
            LanguageRegistry.addName(Tomato, "Tomato");
            LanguageRegistry.addName(Cheese, "Cheese");
            
            LanguageRegistry.addName(McStoneSword, "MineStone Sword");
            LanguageRegistry.addName(McStonePickaxe, "MineStone Pickaxe");
            LanguageRegistry.addName(McStoneAxe, "MineStone Axe");
            LanguageRegistry.addName(McStoneShovel, "MineStone Shovel");
            LanguageRegistry.addName(McStoneHoe, "MineStone Hoe");
            LanguageRegistry.addName(McWoodSword, "MineWood Sword");
            LanguageRegistry.addName(McWoodPickaxe, "MineWood Pickaxe");
            LanguageRegistry.addName(McWoodAxe, "MineWood Axe");
            LanguageRegistry.addName(McWoodShovel, "MineWood Shovel");
            LanguageRegistry.addName(McWoodHoe, "MineWood Hoe");
            
            LanguageRegistry.addName(McZombieHelmet, "MineZombie Helmet");
            LanguageRegistry.addName(McZombieChestplate, "MineZombie Chestplate");
            LanguageRegistry.addName(McZombieLeggings, "MineZombie Leggings");
            LanguageRegistry.addName(McZombieBoots, "MineZombie Boots");
            
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab", "MineDonald's Blocks");
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab2", "MineDonald's Items");
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab3", "MineDonald's Food");
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab4", "MineDonald's Carpets");
            
            LanguageRegistry.addName(McGrassCarpet, "MineDonalds Grass Carpet");
            LanguageRegistry.addName(McDirtCarpet, "MineDonalds Dirt Carpet");
            LanguageRegistry.addName(McStoneCarpet, "MineDonalds Stone Carpet");
            
            
            
            LanguageRegistry.instance().addStringLocalization("achievement.WandAchieve", "en_US", "Got MineWand Achieve!");
            LanguageRegistry.instance().addStringLocalization("achievement.WandAchieve.desc", "en_US", "You crafted the MineWand!");
            LanguageRegistry.instance().addStringLocalization("achievement.MacAchieve", "en_US", "Got BigMine Achieve!");
            LanguageRegistry.instance().addStringLocalization("achievement.MacAchieve.desc", "en_US", "You crafted the BigMine!");
            /**
             * Crafting recipes
             */
            GameRegistry.addRecipe(new ItemStack(McWand,1), new Object[]{
            	"GGB","GSG","GGG",'B',BigMac,'G',Block.blockGold,'S',Item.stick
            	});
            
            GameRegistry.addRecipe(new ItemStack(BigMac,2), new Object[]{
            	"LTL","SOS","CBC",'L',LettucePiece,'T',BurgerTop,'S',Item.beefCooked,'O',Tomato,'C',Cheese,'B',BurgerButtom
            	});
            
            GameRegistry.addRecipe(new ItemStack(CheeseBurger,2), new Object[]{
            	"CTC","SCS","CBC",'L',LettucePiece,'T',BurgerTop,'S',Item.beefCooked,'O',Tomato,'C',Cheese,'B',BurgerButtom
            	});
            
            GameRegistry.addRecipe(new ItemStack(McChicken,2), new Object[]{
            	"KTK","LKL","KBK",'L',LettucePiece,'T',BurgerTop,'S',Item.beefCooked,'O',Tomato,'C',Cheese,'B',BurgerButtom,'K',Item.chickenCooked
            	});
            
            GameRegistry.addRecipe(new ItemStack(McNuggets,2), new Object[]{
            	"KK","KK",'L',LettucePiece,'T',BurgerTop,'S',Item.beefCooked,'O',Tomato,'C',Cheese,'B',BurgerButtom,'K',Item.chickenCooked
            	});
            
            GameRegistry.addRecipe(new ItemStack(Fries,2), new Object[]{
            	"FF","FF",'L',LettucePiece,'T',BurgerTop,'S',Item.beefCooked,'O',Tomato,'C',Cheese,'B',BurgerButtom,'K',Item.chickenCooked,'F',Item.bakedPotato
            	});
            
            GameRegistry.addRecipe(new ItemStack(Salad,2), new Object[]{
            	"LLL","LSL"," B ",'L',LettucePiece,'T',BurgerTop,'S',Item.porkCooked,'O',Tomato,'C',Cheese,'B',Item.bowlEmpty,'K',Item.chickenCooked
            	});
            
            GameRegistry.addRecipe(new ItemStack(CocaCola,2), new Object[]{
            	"GOG","GOG"," G ",'G',Block.glass,'O',Block.obsidian
            	});
            
            GameRegistry.addRecipe(new ItemStack(Fanta,2), new Object[]{
            	"GOG","GOG"," G ",'G',Block.glass,'O',Item.glowstone
            	});
            
            GameRegistry.addRecipe(new ItemStack(McFlurry,2), new Object[]{
            	"SCS","SSS"," B ",'S',Item.snowball,'C',Item.cookie,'B',Item.bowlEmpty
            	});
            
            GameRegistry.addRecipe(new ItemStack(McWrap,2), new Object[]{
            	"LBL","CCC","LBL",'L',LettucePiece,'B',Item.bread,'C',Item.chickenCooked
            	});
            
            GameRegistry.addRecipe(new ItemStack(Apple,2), new Object[]{
            	"AA","AA",'A',Item.appleRed
            	});
            
            GameRegistry.addShapelessRecipe(new ItemStack(Milk,2), new Object[]{
            	Item.bucketMilk });
            
            
            
            GameRegistry.addRecipe(new ItemStack(McStonePickaxe, 1), new Object[]{
            	"MMM", " S ", " S ", 'S', Item.stick, 'M', McStone
            	});
            
            GameRegistry.addRecipe(new ItemStack(McStoneSword, 1), new Object[]{
            	"M", "M", "S", 'S', Item.stick, 'M', McStone
            	});
            
            GameRegistry.addRecipe(new ItemStack(McStoneAxe, 1), new Object[]{
            	"MM ", "MS ", " S ", 'S', Item.stick, 'M', McStone
            	});
            
            GameRegistry.addRecipe(new ItemStack(McStoneAxe, 1), new Object[]{
            	" MM", " SM", " S ", 'S', Item.stick, 'M', McStone
            	});
            
            GameRegistry.addRecipe(new ItemStack(McStoneShovel, 1), new Object[]{
            	"M", "S", "S", 'S', Item.stick, 'M', McStone
            	});
            
            GameRegistry.addRecipe(new ItemStack(McStoneHoe, 1), new Object[]{
            	"MM ", " S ", " S ", 'S', Item.stick, 'M', McStone
            	});
            
            GameRegistry.addRecipe(new ItemStack(McStoneHoe, 1), new Object[]{
            	" MM", " S ", " S ", 'S', Item.stick, 'M', McStone
            	});
            
            GameRegistry.addRecipe(new ItemStack(McStonePickaxe, 1), new Object[]{
            	"MMM", " S ", " S ", 'S', Item.stick, 'M', McStone
            	});
            
            
            GameRegistry.addRecipe(new ItemStack(McStick, 4), new Object[]{
            	"M", "M", 'M', McPlanks
            	});
            
            
            GameRegistry.addRecipe(new ItemStack(McWoodSword, 1), new Object[]{
            	"M", "M", "S", 'S', McStick, 'M', McPlanks
            	});
            
            GameRegistry.addRecipe(new ItemStack(McWoodPickaxe, 1), new Object[]{
            	"MMM", " S ", " S ", 'S', McStick, 'M', McPlanks
            	});
            
            GameRegistry.addRecipe(new ItemStack(McWoodAxe, 1), new Object[]{
            	"MM ", "MS ", " S ", 'S', McStick, 'M', McPlanks
            	});
            
            GameRegistry.addRecipe(new ItemStack(McWoodAxe, 1), new Object[]{
            	" MM", " SM", " S ", 'S', McStick, 'M', McPlanks
            	});
            
            GameRegistry.addRecipe(new ItemStack(McWoodShovel, 1), new Object[]{
            	"M", "S", "S", 'S', McStick, 'M', McPlanks
            	});
            
            GameRegistry.addRecipe(new ItemStack(McWoodHoe, 1), new Object[]{
            	"MM ", " S ", " S ", 'S', McStick, 'M', McPlanks
            	});
            
            GameRegistry.addRecipe(new ItemStack(McWoodHoe, 1), new Object[]{
            	" MM", " S ", " S ", 'S', McStick, 'M', McPlanks
            	});
            
            GameRegistry.addShapelessRecipe(new ItemStack(McPlanks,4), new Object[]{
            	McLog });
            
            
            
            
}
}
