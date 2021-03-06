package darktech.core;

import java.util.ArrayList;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import darktech.api.augmentation.Augment;
import darktech.core.proxies.CommonProxy;
import darktech.magitech.augment.AugmentHandler;
import darktech.magitech.augment.SpeedAugment;

@Mod(name = "DarkTech", modid = "DarkTech", version = DarkTech.VERSION)
public class DarkTech {

	public static final String VERSION = "2.0.0";
	
	public static final Logger LOGGER = LogManager.getLogger("DarkTech");
	
	@SidedProxy(serverSide = "darktech.core.proxies.CommonProxy", clientSide = "darktech.core.proxies.ClientProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e)
	{
		ModContent.initializeCore();
		proxy.preInit();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent e)
	{
		proxy.mainInit();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit();
	}
	
}
