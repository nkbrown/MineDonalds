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
		
	} catch (Exception e) {
		FMLLog.log(Level.SEVERE, e, "MineDonalds" + " has had a problem loading its configuration");
		throw new RuntimeException(e);
	} finally {
		configuration.save();
	}
}
}