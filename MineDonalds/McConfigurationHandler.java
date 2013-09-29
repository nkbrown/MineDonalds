package MineDonalds;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.Configuration;

public class McConfigurationHandler {
	
public static Configuration configuration;
public static void init(File configFile) {
	configuration = new Configuration(configFile);
	try {
		configuration.load();
		
		Main.Dim = configuration.get("Dimension ID", "MineDonalds Dimension", 2).getInt();
		Main.McBiomeID = configuration.get("Biome ID", "MineDonalds Biome", 40).getInt();
		
		Main.McGrassID = configuration.get("Block ID", "MineDimension Grass", 200).getInt();
		Main.McDirtID = configuration.get("Block ID", "MineDimension Dirt", 201).getInt();
		Main.McStoneID = configuration.get("Block ID", "MineDimension Stone", 202).getInt();
		Main.McLeafID = configuration.get("Block ID", "MineDimension Leaves", 203).getInt();
		Main.McLogID = configuration.get("Block ID", "MineDimension Log", 204).getInt();
		Main.McVineID = configuration.get("Block ID", "MineDimension Vine", 206).getInt();
		Main.McFireID = configuration.get("Block ID", "MineDimension Fireblock", 207).getInt();
		Main.McPortalID = configuration.get("Block ID", "MineDimension Portalblock", 208).getInt();
		Main.McSaplingID = configuration.get("Block ID", "MineDimension Sapling", 209).getInt();
		
		Main.McGrassCarpetID = configuration.get("Carpet ID", "MineDonalds Grass Carpet", 210).getInt();
		Main.McDirtCarpetID = configuration.get("Carpet ID", "MineDonalds Dirt Carpet", 211).getInt();
		Main.McStoneCarpetID = configuration.get("Carpet ID", "MineDonalds Stone Carpet", 212).getInt();
		Main.McLeafCarpetID = configuration.get("Carpet ID", "MineDonalds Leaf Carpet", 213).getInt();
		Main.McLogCarpetID = configuration.get("Carpet ID", "MineDonalds Log Carpet", 214).getInt();
		
		Main.BigMacID = configuration.get("Food ID", "Big Mine", 450).getInt();
		Main.CheeseBurgerID = configuration.get("Food ID", "Cheesy MineBurger", 451).getInt();
		Main.McChickenID = configuration.get("Food ID", "MineChicken", 452).getInt();
		Main.McNuggetsID = configuration.get("Food ID", "Chicken MineNuggets", 453).getInt();
		Main.FriesID = configuration.get("Food ID", "Mine Fries", 454).getInt();
		Main.SaladID = configuration.get("Food ID", "Premium Mine Salad", 455).getInt();
		Main.CocaColaID = configuration.get("Food ID", "Mine-Cola", 456).getInt();
		Main.FantaID = configuration.get("Food ID", "Mine-Fanta", 457).getInt();
		Main.McFlurryID = configuration.get("Food ID", "MineFlurry", 458).getInt();
		Main.AppleID = configuration.get("Food ID", "MineApple", 459).getInt();
		Main.MilkID = configuration.get("Food ID", "1% Low Fat Mine Milk", 460).getInt();
		Main.McWrapID = configuration.get("Food ID", "MineWrap", 461).getInt();
		
		Main.McWandID = configuration.get("Item ID", "MineWand", 462).getInt();
		Main.BurgerTopID = configuration.get("Item ID", "Burger Bread (Top)", 464).getInt();
		Main.BurgerButtomID = configuration.get("Item ID", "Burger Bread (Buttom)", 465).getInt();
		Main.CheeseID = configuration.get("Item ID", "Cheese", 466).getInt();
		Main.LettucePieceID = configuration.get("Item ID", "Lettuce Piece", 467).getInt();
		Main.TomatoID = configuration.get("Item ID", "Tomato", 468).getInt();
		
		Main.McZombieHelmetID = configuration.get("Armor ID", "MineZombie Helmet", 469).getInt();
		Main.McZombieChestplateID = configuration.get("Armor ID", "MineZombie Chestplate", 470).getInt();
		Main.McZombieLeggingsID = configuration.get("Armor ID", "MineZombie Leggings", 471).getInt();
		Main.McZombieBootsID = configuration.get("Armor ID", "MineZombie Boots", 472).getInt();
		
		Main.McStoneSwordID = configuration.get("Tool ID", "MineStone Sword", 473).getInt();
		Main.McStonePickaxeID = configuration.get("Tool ID", "MineStone Pickaxe", 474).getInt();
		Main.McStoneAxeID = configuration.get("Tool ID", "MineStone Axe", 475).getInt();
		Main.McStoneShovelID = configuration.get("Tool ID", "MineStone Shovel", 476).getInt();
		Main.McStoneHoeID = configuration.get("Tool ID", "MineStone Hoe", 477).getInt();
		
		Main.TomatoSeedsID = configuration.get("Plant ID", "Tomatoplant Seeds", 478).getInt();
		Main.LettuceSeedsID = configuration.get("Plant ID", "Lettuceplant Seeds", 479).getInt();
		
		
	} catch (Exception e) {
		FMLLog.log(Level.SEVERE, e, "MineDonalds" + " has had a problem loading its configuration");
		throw new RuntimeException(e);
	} finally {
		configuration.save();
	}
}
}