package MineDonalds;

import java.io.File;
import java.util.HashMap;

import MineDonalds.Blocks.*;
import MineDonalds.Carpets.McDirtCarpet;
import MineDonalds.Carpets.McGrassCarpet;
import MineDonalds.Carpets.McLeafCarpet;
import MineDonalds.Carpets.McLogCarpet;
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
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.*;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;
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
 *******************
 * Hi
 * @author iLexiconn
 *******************
 *
 *
 * Mod version 1.1.1
 * 
 * Thanks to -> Mogan, Isaac, Evan and Waffleguy ;p
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
	public static int McGrassID;
	public static Block McDirt;
	public static int McDirtID;
	public static Block McStone;
	public static int McStoneID;
	public static Block McLeaf;
	public static int McLeafID;
	public static Block McLog;
	public static int McLogID;
	public static Block McVine;
	public static int McVineID;
	public static BlockMcFire McFire;
	public static int McFireID;
	public static BlockMcPortal McPortal;
	public static int McPortalID;
	public static BlockMcSapling McSapling;
	public static int McSaplingID;
	
	public static Item McWand;
	public static int McWandID;
	public static Item BigMac;
	public static int BigMacID;
	public static Item CheeseBurger;
	public static int CheeseBurgerID;
	public static Item McChicken;
	public static int McChickenID;
	public static Item McNuggets;
	public static int McNuggetsID;
	public static Item Fries;
	public static int FriesID;
	public static Item Salad;
	public static int SaladID;
	public static Item CocaCola;
	public static int CocaColaID;
	public static Item Fanta;
	public static int FantaID;
	public static Item McFlurry;
	public static int McFlurryID;
	public static Item McWrap;
	public static int McWrapID;
	public static Item Apple;
	public static int AppleID;
	public static Item Milk;
	public static int MilkID;
	
	public static Item McZombieHelmet;
	public static int McZombieHelmetID;
	public static Item McZombieChestplate;
	public static int McZombieChestplateID;
	public static Item McZombieLeggings;
	public static int McZombieLeggingsID;
	public static Item McZombieBoots;
	public static int McZombieBootsID;
	public static Item McStoneSword;
	public static int McStoneSwordID;
	public static Item McStonePickaxe;
	public static int McStonePickaxeID;
	public static Item McStoneAxe;
	public static int McStoneAxeID;
	public static Item McStoneShovel;
	public static int McStoneShovelID;
	public static Item McStoneHoe;
	public static int McStoneHoeID;
	
	public static BiomeGenBase McBiome;
	public static int McBiomeID;
	public static int DimID;
	public static int Dim;
	public static Item BurgerButtom;
	public static int BurgerButtomID;
	public static Item BurgerTop;
	public static int BurgerTopID;
	public static Item LettucePiece;
	public static int LettucePieceID;
	public static Item Tomato;
	public static int TomatoID;
	public static Item Cheese;
	public static int CheeseID;
	
	public static Block McGrassCarpet;
	public static int McGrassCarpetID;
	public static Block McDirtCarpet;
	public static int McDirtCarpetID;
	public static Block McStoneCarpet;
	public static int McStoneCarpetID;
	public static Block McLeafCarpet;
	public static int McLeafCarpetID;
	public static Block McLogCarpet;
	public static int McLogCarpetID;
	
	public static Block TomatoPlant;
	public static Item TomatoSeeds;
	public static int TomatoSeedsID;
	public static Block LettucePlant;
	public static Item LettuceSeeds;
	public static int LettuceSeedsID;
	
	public static McCraftingHandler craftHandler;
	public static Achievement macAchieve;
	public static Achievement wandAchieve;
	public static Achievement cheeseAchieve;
	public static Achievement breadAchieve;
	public static Achievement carpetAchieve;
	public static AchievementPage page1;
	
	public static boolean enable; //true/false, but how via config?
	
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
			if(enable == true)
    		{
			return new ItemStack(McWand);
    		}
			if(enable == false)
    		{
			return new ItemStack(McStoneSword);
    		}
			return new ItemStack (McStoneSword);
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
	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		McConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator  +"MineDonalds" + ".cfg"));
		
	McGrass = new BlockMcGrass(McGrassID).setStepSound(Block.soundGrassFootstep).setHardness(0.5F).setUnlocalizedName("McGrass");
	McDirt = new BlockMcDirtMcStone(McDirtID, Material.ground).setStepSound(Block.soundGravelFootstep).setHardness(0.5F).setUnlocalizedName("McDirt");
	McStone = new BlockMcDirtMcStone(McStoneID, Material.rock).setHardness(2.0F).setUnlocalizedName("McStone");
	McLeaf = new BlockMcLeaf(McLeafID).setHardness(0.2F).setUnlocalizedName("McLeaf");
	McLog = new BlockMcLog(McLogID).setHardness(2.0F).setUnlocalizedName("McLog");
	McVine = new BlockMcVine(McVineID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("McVine");
	if(enable == true)
	{
	McFire = (BlockMcFire)new BlockMcFire(McFireID).setUnlocalizedName("McFire");
	McPortal = (BlockMcPortal)new BlockMcPortal(McPortalID).setUnlocalizedName("McPortal");
	}
	McSapling = (BlockMcSapling)new BlockMcSapling(McSaplingID, 0).setUnlocalizedName("McSapling");
	
	if(enable == true)
	{
	McWand = new ItemMcWand(McWandID).setUnlocalizedName("McWand");
	}
	BigMac = new BigMac(BigMacID, 30, 10.0F, false).setUnlocalizedName("BigMac");
	CheeseBurger = new CheeseBurger(CheeseBurgerID, 18, 4.0F, false).setUnlocalizedName("CheeseBurger");
	McChicken = new McChicken(McChickenID, 17, 3.5F, false).setUnlocalizedName("McChicken");
	McNuggets = new McNuggets(McNuggetsID, 7, 4.0F, true).setUnlocalizedName("McNuggets");
	Fries = new Fries(FriesID, 10, 4.5F, false).setUnlocalizedName("Fries");
	Salad = new Salad(SaladID, 8, 1.5F, true).setUnlocalizedName("Salad");
	CocaCola = new CocaCola(CocaColaID, 0, 0, false).setUnlocalizedName("CocaCola");
	Fanta = new Fanta(FantaID, 1, 0.1F, false).setUnlocalizedName("Fanta");
	McFlurry = new McFlurry(McFlurryID, 1, 1.2F, false).setUnlocalizedName("McFlurry");
	McWrap = new McWrap(McWrapID, 2, 1.6F, true).setUnlocalizedName("McWrap");
	Apple = new Apple(AppleID, 2, 1.8F, true).setUnlocalizedName("Apple");
	Milk = new Milk(MilkID, 3, 2.0F, true).setUnlocalizedName("Milk");
	
	McZombieHelmet = new McZombieArmor(McZombieHelmetID, armorMcZombie, 0, 0).setUnlocalizedName("McZombieHelmet");
	McZombieChestplate = new McZombieArmor(McZombieChestplateID, armorMcZombie, 0, 1).setUnlocalizedName("McZombieChestplate");
	McZombieLeggings = new McZombieArmor(McZombieLeggingsID, armorMcZombie, 0, 2).setUnlocalizedName("McZombieLeggings");
	McZombieBoots = new McZombieArmor(McZombieBootsID, armorMcZombie, 0, 3).setUnlocalizedName("McZombieBoots");
	
	McStoneSword = new McStoneSword(McStoneSwordID, toolMcStone).setUnlocalizedName("McStoneSword");
	McStonePickaxe = new McStonePickaxe(McStonePickaxeID, toolMcStone).setUnlocalizedName("McStonePickaxe");
	McStoneAxe = new McStoneAxe(McStoneAxeID, toolMcStone).setUnlocalizedName("McStoneAxe");
	McStoneShovel = new McStoneShovel(McStoneShovelID, toolMcStone).setUnlocalizedName("McStoneShovel");
	McStoneHoe = new McStoneHoe(McStoneHoeID, toolMcStone).setUnlocalizedName("McStoneHoe");
	
	if(enable == true)
	{
	McBiome = new BiomeGenMcBiome(McBiomeID);
	DimID = Dim;
	}
	
	BurgerButtom = new BurgerButtom(BurgerButtomID).setUnlocalizedName("BurgerButtom");
	BurgerTop = new BurgerTop(BurgerTopID).setUnlocalizedName("BurgerTop");
	LettucePiece = new LettucePiece(LettucePieceID).setUnlocalizedName("LettucePiece");
	Tomato = new Tomato(TomatoID).setUnlocalizedName("Tomato");
	Cheese = new Cheese(CheeseID).setUnlocalizedName("Cheese");
	
	McGrassCarpet = (new McGrassCarpet(McGrassCarpetID)).setHardness(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("mineCarpet").setLightOpacity(0);
	McDirtCarpet = (new McDirtCarpet(McDirtCarpetID)).setHardness(0.1F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("mineCarpet1").setLightOpacity(0);
	McStoneCarpet = (new McStoneCarpet(McStoneCarpetID)).setHardness(0.1F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("mineCarpet2").setLightOpacity(0);
	McLeafCarpet = (new McLeafCarpet(McLeafCarpetID)).setHardness(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("mineCarpet3").setLightOpacity(0);
	McLogCarpet = (new McLogCarpet(McLogCarpetID)).setHardness(0.1F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("mineCarpet4").setLightOpacity(0);
	
	TomatoPlant = (new TomatoPlant(216)).setUnlocalizedName("tomatoCrop").func_111022_d("minedonalds:tomato");
	TomatoSeeds = (new TomatoSeeds(TomatoSeedsID, Main.TomatoPlant.blockID, Block.tilledField.blockID)).setUnlocalizedName("tomatoSeeds").func_111206_d("minedonalds:tomatoSeeds");
	LettucePlant = (new LettucePlant(217)).setUnlocalizedName("lettuceCrop").func_111022_d("minedonalds:lettuce");
	LettuceSeeds = (new LettuceSeeds(LettuceSeedsID, Main.LettucePlant.blockID, Block.tilledField.blockID)).setUnlocalizedName("lettuceSeeds").func_111206_d("minedonalds:lettuceSeeds");
    
	breadAchieve = new Achievement(1999, "BreadAchieve", 4, 2, BurgerTop, null).registerAchievement();
	macAchieve = new Achievement(2000, "MacAchieve", 2, 1, BigMac, breadAchieve).registerAchievement();
	if(enable == true)
	{
	wandAchieve = new Achievement(2001, "WandAchieve", 0, 0, McWand, macAchieve).registerAchievement().setSpecial();
	}
	cheeseAchieve = new Achievement(2002, "CheeseAchieve", 4, -1, CheeseBurger, breadAchieve).registerAchievement();
	//carpetAchieve = new Achievement(2003, "CarpetAchieve", 4, 2, McGrassCarpet, wandAchieve).registerAchievement();
	
	craftHandler = new McCraftingHandler();
	page1 = new AchievementPage("MineDonalds", macAchieve, wandAchieve, cheeseAchieve, breadAchieve, carpetAchieve);
	
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
    		if(enable == true)
    		{
    		DimensionManager.registerProviderType(DimID, McWorldProvider.class, true);
    		DimensionManager.registerDimension(DimID, DimID);
    		MinecraftForge.EVENT_BUS.register(new McEvent());
    		}
    		
    		
    		
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
    		GameRegistry.registerBlock(McLeafCarpet, "McLeafCarpet");
    		GameRegistry.registerBlock(McLogCarpet, "McLogCarpet");
    		
    		GameRegistry.registerCraftingHandler(craftHandler);
    		AchievementPage.registerAchievementPage(page1);
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
            
            if(enable == true)
    		{
            LanguageRegistry.addName(McWand, "MineWand");
    		}
            LanguageRegistry.addName(McNuggets, "Chicken MineNuggets");
            LanguageRegistry.addName(CheeseBurger, "Cheesy MineBurger");
            LanguageRegistry.addName(BigMac, "Big Mine");
            LanguageRegistry.addName(McChicken, "MineChicken");
            LanguageRegistry.addName(Fries, "Mine Fries");
            LanguageRegistry.addName(Salad, "Premium Mine Salad");
            LanguageRegistry.addName(CocaCola, "Mine-Cola");
            LanguageRegistry.addName(Fanta, "Mine-Fanta");
            LanguageRegistry.addName(McFlurry, "MineFlurry");
			LanguageRegistry.addName(McWrap, "MineWrap");
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
            
            LanguageRegistry.addName(McZombieHelmet, "MineZombie Helmet");
            LanguageRegistry.addName(McZombieChestplate, "MineZombie Chestplate");
            LanguageRegistry.addName(McZombieLeggings, "MineZombie Leggings");
            LanguageRegistry.addName(McZombieBoots, "MineZombie Boots");
            
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab", "MineDonald's Blocks");
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab2", "MineDonald's Items");
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab3", "MineDonald's Food");
            LanguageRegistry.instance().addStringLocalization("itemGroup.McTab4", "MineDonald's Carpets");
            
            LanguageRegistry.instance().addStringLocalization("achievement.WandAchieve", "en_US", "Minewhat..?");
            LanguageRegistry.instance().addStringLocalization("achievement.WandAchieve.desc", "en_US", "You crafted the MineWand!");
            LanguageRegistry.instance().addStringLocalization("achievement.MacAchieve", "en_US", "Yumyum, NO!");
            LanguageRegistry.instance().addStringLocalization("achievement.MacAchieve.desc", "en_US", "You crafted the BigMine!");
            LanguageRegistry.instance().addStringLocalization("achievement.CheeseAchieve", "en_US", "Cheese FTW!");
            LanguageRegistry.instance().addStringLocalization("achievement.CheeseAchieve.desc", "en_US", "You crafted the Cheesy Mineburger!");
            LanguageRegistry.instance().addStringLocalization("achievement.BreadAchieve", "en_US", "Burger bread...");
            LanguageRegistry.instance().addStringLocalization("achievement.BreadAchieve.desc", "en_US", "You crafted some burger bread!");
            LanguageRegistry.instance().addStringLocalization("achievement.CarpetAchieve", "en_US", "Carpets!");
            LanguageRegistry.instance().addStringLocalization("achievement.CarpetAchieve.desc", "en_US", "You crafted a carpet!");
            
            LanguageRegistry.addName(McGrassCarpet, "MineDonalds Grass Carpet");
            LanguageRegistry.addName(McDirtCarpet, "MineDonalds Dirt Carpet");
            LanguageRegistry.addName(McStoneCarpet, "MineDonalds Stone Carpet");
            LanguageRegistry.addName(McLeafCarpet, "MineDonalds Leaves Carpet");
            LanguageRegistry.addName(McLogCarpet, "MineDonalds Log Carpet");
            
            
            LanguageRegistry.addName(TomatoSeeds, "Tomatoplant Seeds");
            LanguageRegistry.addName(LettuceSeeds, "Lettuceplant Seeds");
            
            /**
             * Crafting recipes
             */
            if(enable == true)
    		{
            GameRegistry.addRecipe(new ItemStack(McWand,1), new Object[]{
            	"GGB","GSG","GGG",'B',BigMac,'G',Block.blockGold,'S',Item.stick
            	});
    		}
            
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
            
            
            
            GameRegistry.addRecipe(new ItemStack(BurgerTop, 6), new Object[]{
            	"BBB", "   ", "   ", 'B', Item.bread
            	});
            GameRegistry.addRecipe(new ItemStack(BurgerButtom, 6), new Object[]{
            	"   ", "   ", "BBB", 'B', Item.bread
            	});
            
            GameRegistry.addShapelessRecipe(new ItemStack(Cheese, 4), new Object[]{
            	Item.bucketMilk, Item.bucketWater });
            
            GameRegistry.addShapelessRecipe(new ItemStack(TomatoSeeds, 4), new Object[]{
            	Item.seeds, new ItemStack(Item.dyePowder, 1, 1) });
            
            GameRegistry.addShapelessRecipe(new ItemStack(LettuceSeeds, 4), new Object[]{
            	Item.seeds, new ItemStack(Item.dyePowder, 1, 2) });
            
}
}
