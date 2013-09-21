package MineDonalds;

import java.io.File;
import java.util.HashMap;

import MineDonalds.Blocks.*;
import MineDonalds.Items.*;
import MineDonalds.Dimension.McWorldProvider;
import MineDonalds.Dimension.Biomes.BiomeGenMcBiome;
import MineDonalds.Dimension.Biomes.BiomeGenYellowTree;
import MineDonalds.Dimension.Event.McEvent;
import MineDonalds.Items.ItemMcWand;
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
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = "mineronalds", name = "MineRonald's Food", version = "1.0")
@NetworkMod(serverSideRequired = false, clientSideRequired = true)


/**
 * Hi
 * @author iLexiconn
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
	public static EnumArmorMaterial armorMcZombie = EnumHelper.addArmorMaterial("MCZOMBIE", 15, new int[]{2, 7, 5, 2}, 99);
	public static EnumToolMaterial toolMcStone = EnumHelper.addToolMaterial("MCSTONE", 2, 242, 4.5F, 1.5F, 99);
	public static EnumToolMaterial toolMcWood = EnumHelper.addToolMaterial("MCWOOD", 1, 69, 2.5F, 0.5F, 99);
		
	public static Block McGrass = new BlockMcGrass(201).setStepSound(Block.soundGrassFootstep).setHardness(0.5F).setUnlocalizedName("McGrass");
	public static Block McDirt = new BlockMcDirtMcStone(202, Material.ground).setStepSound(Block.soundGravelFootstep).setHardness(0.5F).setUnlocalizedName("McDirt");
	public static Block McStone = new BlockMcDirtMcStone(203, Material.rock).setHardness(2.0F).setUnlocalizedName("McStone");
	public static Block McLeaf = new BlockMcLeaf(204).setHardness(0.2F).setUnlocalizedName("McLeaf");
	public static Block McLog = new BlockMcLog(205).setHardness(2.0F).setUnlocalizedName("McLog");
	public static Block McPlanks = new BlockMcPlanks(206, Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("McWood");
	public static Block McVine = new BlockMcVine(207).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("McVine");
	public static BlockMcFire McFire = (BlockMcFire)new BlockMcFire(208).setUnlocalizedName("McFire");
	public static BlockMcPortal McPortal = (BlockMcPortal)new BlockMcPortal(209).setUnlocalizedName("McPortal");
	public static BlockMcSapling McSapling = (BlockMcSapling)new BlockMcSapling(210, 0).setUnlocalizedName("McSapling");
	
	public static Item McWand = new ItemMcWand(451).setUnlocalizedName("McWand");
	public static Item McStick = new McStick(483).setUnlocalizedName("McStick");
	public static Item BigMac = new BigMac(452, 30, 10.0F, false).setUnlocalizedName("BigMac");
	public static Item CheeseBurger = new CheeseBurger(453, 18, 4.0F, false).setUnlocalizedName("CheeseBurger");
	public static Item McChicken = new McChicken(454, 17, 3.5F, false).setUnlocalizedName("McChicken");
	public static Item McNuggets = new McNuggets(455, 7, 4.0F, true).setUnlocalizedName("McNuggets");
	public static Item Fries = new Fries(456, 10, 4.5F, false).setUnlocalizedName("Fries");
	public static Item Salad = new Salad(457, 8, 1.5F, true).setUnlocalizedName("Salad");
	public static Item CocaCola = new CocaCola(458, 0, 0, false).setUnlocalizedName("CocaCola");
	public static Item Fanta = new Fanta(459, 1, 0.1F, false).setUnlocalizedName("Fanta");
	public static Item McFlurry = new McFlurry(460, 1, 1.2F, false).setUnlocalizedName("McFlurry");
	public static Item McWrap = new McWrap(461, 2, 1.6F, true).setUnlocalizedName("McWrap");
	public static Item Apple = new Apple(462, 2, 1.8F, true).setUnlocalizedName("Apple");
	public static Item Milk = new Milk(463, 3, 2.0F, true).setUnlocalizedName("Milk");
	
	public static Item McZombieHelmet = new McZombieArmor(464, armorMcZombie, 0, 0).setUnlocalizedName("McZombieHelmet");
	public static Item McZombieChestplate = new McZombieArmor(465, armorMcZombie, 0, 1).setUnlocalizedName("McZombieChestplate");
	public static Item McZombieLeggings = new McZombieArmor(466, armorMcZombie, 0, 2).setUnlocalizedName("McZombieLeggings");
	public static Item McZombieBoots = new McZombieArmor(467, armorMcZombie, 0, 3).setUnlocalizedName("McZombieBoots");
	
	public static Item McStoneSword = new McStoneSword(468, toolMcStone).setUnlocalizedName("McStoneSword");
	public static Item McStonePickaxe = new McStonePickaxe(469, toolMcStone).setUnlocalizedName("McStonePickaxe");
	public static Item McStoneAxe = new McStoneAxe(470, toolMcStone).setUnlocalizedName("McStoneAxe");
	public static Item McStoneShovel = new McStoneShovel(471, toolMcStone).setUnlocalizedName("McStoneShovel");
	public static Item McStoneHoe = new McStoneHoe(472, toolMcStone).setUnlocalizedName("McStoneHoe");
	
	public static Item McWoodSword = new McWoodSword(473, toolMcWood).setUnlocalizedName("McWoodSword");
	public static Item McWoodPickaxe = new McWoodPickaxe(474, toolMcWood).setUnlocalizedName("McWoodPickaxe");
	public static Item McWoodAxe = new McWoodAxe(475, toolMcWood).setUnlocalizedName("McWoodAxe");
	public static Item McWoodShovel = new McWoodShovel(476, toolMcWood).setUnlocalizedName("McWoodShovel");
	public static Item McWoodHoe = new McWoodHoe(477, toolMcWood).setUnlocalizedName("McWoodHoe");

	public static BiomeGenBase YellowTree = new BiomeGenYellowTree(41);
	public static BiomeGenBase McBiome = new BiomeGenMcBiome(42);
	public static int DimID = 2;
	
	public static Item BurgerButtom = new BurgerButtom(478).setUnlocalizedName("BurgerButtom");
	public static Item BurgerTop = new BurgerTop(479).setUnlocalizedName("BurgerTop");
	public static Item LettucePiece = new LettucePiece(480).setUnlocalizedName("LettucePiece");
	public static Item Tomato = new Tomato(481).setUnlocalizedName("Tomato");
	public static Item Cheese = new Cheese(482).setUnlocalizedName("Cheese");
	
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
    		GameRegistry.registerBlock(McPlanks, "MinePlanks");
    		
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
            LanguageRegistry.addName(CheeseBurger, "Mineburger");
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
            
            LanguageRegistry.addName(BurgerButtom, "Burger Buttom");
            LanguageRegistry.addName(BurgerTop, "Burger Top");
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
            
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab", "MineRonald's Blocks");
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab2", "MineRonald's Items");
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab3", "MineRonald's Food");
            
            
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
