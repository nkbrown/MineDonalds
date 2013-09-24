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
		// Blocks or Items
		//YourBlockID = configuration.getBlock(YourBlockName, YourBlockDefaultID).getInt(YourBlockDefaultID);
	} catch (Exception e) {
		FMLLog.log(Level.SEVERE, e, "MineDonalds" + " has had a problem loading its configuration");
		throw new RuntimeException(e);
	} finally {
		configuration.save();
	}
}
}