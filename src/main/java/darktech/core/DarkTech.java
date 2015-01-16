package darktech.core;

import java.util.HashMap;

import net.minecraft.item.Item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import darktech.core.proxies.CommonProxy;

@Mod(name = "DarkTech", modid = "DarkTech", version = DarkTech.VERSION)
public class DarkTech {

	public static final String VERSION = "2.0.0";
	
	public static final Logger logger = LogManager.getLogger("DarkTech");
	
	@SidedProxy(serverSide = "darktech.core.proxies.CommonProxy", clientSide = "darktech.core.proxies.ClientProxy")
	public static CommonProxy proxy;
	
	public static HashMap<Item, Item> crucibleRecipe = new HashMap<Item, Item>();
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e)
	{
		ModBlocks.i();
		proxy.preInit();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent e)
	{
		
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e)
	{
		
	}
	
}
