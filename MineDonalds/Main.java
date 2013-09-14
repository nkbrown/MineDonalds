package MineDonalds;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "minedonalds", name = "MineDonalds", version = "4.0")
@NetworkMod(serverSideRequired = false, clientSideRequired = true)
//Last edited by iLexiconn
//14:12 (2:12 PM)
public class Main {
	
	/**
	 * Proxy stuff
	 */
	@SidedProxy(clientSide="MineDonalds.ClientProxy", serverSide="MineDonalds.ServerProxy")
	public static ServerProxy proxy;
	
	
}
