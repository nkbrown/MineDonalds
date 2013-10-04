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
		
		Main.Dim = configuration.get("DimensionID", "Minedonalds Dimension", 2).getInt(2);
		Main.McBiomeID = configuration.get("Biome ID", "MineDonalds Biome", 40).getInt(40);
		
		Main.McGrassID = configuration.get("Block ID", "MineDimension Grass", 200).getInt(200);
		Main.McDirtID = configuration.get("Block ID", "MineDimension Dirt", 201).getInt(201);
		Main.McStoneID = configuration.get("Block ID", "MineDimension Stone", 202).getInt(202);
		Main.McLeafID = configuration.get("Block ID", "MineDimension Leaves", 203).getInt(203);
		Main.McLogID = configuration.get("Block ID", "MineDimension Log", 204).getInt(204);
		Main.McVineID = configuration.get("Block ID", "MineDimension Vine", 206).getInt(206);
		Main.McFireID = configuration.get("Block ID", "MineDimension Fireblock", 207).getInt(207);
		Main.McPortalID = configuration.get("Block ID", "MineDimension Portalblock", 208).getInt(208);
		Main.McSaplingID = configuration.get("Block ID", "MineDimension Sapling", 209).getInt(209);
		
		Main.McGrassCarpetID = configuration.get("Carpet ID", "MineDonalds Grass Carpet", 210).getInt(210);
		Main.McDirtCarpetID = configuration.get("Carpet ID", "MineDonalds Dirt Carpet", 211).getInt(211);
		Main.McStoneCarpetID = configuration.get("Carpet ID", "MineDonalds Stone Carpet", 212).getInt(212);
		Main.McLeafCarpetID = configuration.get("Carpet ID", "MineDonalds Leaf Carpet", 213).getInt(213);
		Main.McLogCarpetID = configuration.get("Carpet ID", "MineDonalds Log Carpet", 214).getInt(214);
		
		Main.BigMacID = configuration.get("Food ID", "Big Mine", 450).getInt(450);
		Main.CheeseBurgerID = configuration.get("Food ID", "Cheesy MineBurger", 451).getInt(451);
		Main.McChickenID = configuration.get("Food ID", "MineChicken", 452).getInt(452);
		Main.McNuggetsID = configuration.get("Food ID", "Chicken MineNuggets", 453).getInt(453);
		Main.FriesID = configuration.get("Food ID", "Mine Fries", 454).getInt(454);
		Main.SaladID = configuration.get("Food ID", "Premium Mine Salad", 455).getInt(455);
		Main.CocaColaID = configuration.get("Food ID", "Mine-Cola", 456).getInt(456);
		Main.FantaID = configuration.get("Food ID", "Mine-Fanta", 457).getInt(457);
		Main.McFlurryID = configuration.get("Food ID", "MineFlurry", 458).getInt(458);
		Main.AppleID = configuration.get("Food ID", "MineApple", 459).getInt(459);
		Main.MilkID = configuration.get("Food ID", "1% Low Fat Mine Milk", 460).getInt(460);
		Main.McWrapID = configuration.get("Food ID", "MineWrap", 461).getInt(461);
		
		Main.McWandID = configuration.get("Item ID", "MineWand", 462).getInt(462);
		Main.BurgerTopID = configuration.get("Item ID", "Burger Bread (Top)", 464).getInt(464);
		Main.BurgerButtomID = configuration.get("Item ID", "Burger Bread (Buttom)", 465).getInt(465);
		Main.CheeseID = configuration.get("Item ID", "Cheese", 466).getInt(466);
		Main.LettucePieceID = configuration.get("Item ID", "Lettuce Piece", 467).getInt(467);
		Main.TomatoID = configuration.get("Item ID", "Tomato", 468).getInt(468);
		
		Main.McZombieHelmetID = configuration.get("Armor ID", "MineZombie Helmet", 469).getInt(469);
		Main.McZombieChestplateID = configuration.get("Armor ID", "MineZombie Chestplate", 470).getInt(470);
		Main.McZombieLeggingsID = configuration.get("Armor ID", "MineZombie Leggings", 471).getInt(471);
		Main.McZombieBootsID = configuration.get("Armor ID", "MineZombie Boots", 472).getInt(472);
		
		Main.McStoneSwordID = configuration.get("Tool ID", "MineStone Sword", 473).getInt(473);
		Main.McStonePickaxeID = configuration.get("Tool ID", "MineStone Pickaxe", 474).getInt(474);
		Main.McStoneAxeID = configuration.get("Tool ID", "MineStone Axe", 475).getInt(475);
		Main.McStoneShovelID = configuration.get("Tool ID", "MineStone Shovel", 476).getInt(476);
		Main.McStoneHoeID = configuration.get("Tool ID", "MineStone Hoe", 477).getInt(477);
		
		Main.TomatoSeedsID = configuration.get("Plant ID", "Tomatoplant Seeds", 478).getInt(478);
		Main.LettuceSeedsID = configuration.get("Plant ID", "Lettuceplant Seeds", 479).getInt(479);
		
		Main.dimensionEnable = configuration.get("Enable/Disable", "MineDonalds Dimension", true).getBoolean(true);
		Main.toolsEnable = configuration.get("Enable/Disable", "MineStone Tools", true).getBoolean(true);
		Main.armorEnable = configuration.get("Enable/Disable", "MineZombie Armor", true).getBoolean(true);
		Main.mobEnable = configuration.get("Enable/Disable", "Emplayee/Fat Zombie/McZombie", true).getBoolean(true);
		Main.carpetEnable = configuration.get("Enable/Disable", "Carpets", true).getBoolean(true);
		
		
	} catch (Exception e) {
		FMLLog.log(Level.SEVERE, e, "MineDonalds" + " has had a problem loading its configuration");
		throw new RuntimeException(e);
	} finally {
		configuration.save();
	}
}
}