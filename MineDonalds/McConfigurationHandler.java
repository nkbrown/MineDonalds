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
		Main.McPlanksID = configuration.get("Block ID", "MineDimension Planks", 205).getInt();
		Main.McVineID = configuration.get("Block ID", "MineDimension Vine", 206).getInt();
		Main.McFireID = configuration.get("Block ID", "MineDimension Fireblock", 207).getInt();
		Main.McPortalID = configuration.get("Block ID", "MineDimension Portalblock", 208).getInt();
		Main.McSaplingID = configuration.get("Block ID", "MineDimension Sapling", 209).getInt();
		
		Main.McWandID = configuration.get("Item ID", "MineWand", 450).getInt();
		Main.McStickID = configuration.get("Item ID", "MineStick", 451).getInt();
		Main.BigMacID = configuration.get("Item ID", "Big Mine", 452).getInt();
		Main.CheeseBurgerID = configuration.get("Item ID", "Cheesy MineBurger", 453).getInt();
		Main.McChickenID = configuration.get("Item ID", "MineChicken", 454).getInt();
		Main.McNuggetsID = configuration.get("Item ID", "Chicken MineNuggets", 455).getInt();
		Main.FriesID = configuration.get("Item ID", "Mine Fries", 456).getInt();
		Main.SaladID = configuration.get("Item ID", "Premium Mine Salad", 457).getInt();
		Main.CocaColaID = configuration.get("Item ID", "Mine-Cola", 458).getInt();
		Main.FantaID = configuration.get("Item ID", "Mine-Fanta", 459).getInt();
		Main.McFlurryID = configuration.get("Item ID", "MineFlurry", 460).getInt();
		Main.AppleID = configuration.get("Item ID", "MineApple", 461).getInt();
		Main.MilkID = configuration.get("Item ID", "1% Low Fat Mine Milk", 462).getInt();
		Main.McWrapID = configuration.get("Item ID", "MineWrap", 463).getInt();
		
	} catch (Exception e) {
		FMLLog.log(Level.SEVERE, e, "MineDonalds" + " has had a problem loading its configuration");
		throw new RuntimeException(e);
	} finally {
		configuration.save();
	}
}
}