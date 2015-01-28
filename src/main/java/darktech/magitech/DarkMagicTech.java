package darktech.magitech;

import java.util.ArrayList;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import darktech.api.augmentation.Augment;
import darktech.core.DarkTech;
import darktech.core.ModContent;
import darktech.magitech.augment.AugmentHandler;
import darktech.magitech.augment.SpeedAugment;
import darktech.magitech.proxies.CommonProxy;

@Mod(name = "DarkTech|MagiTech", modid = "DarkTech|MagiTech", version = DarkTech.VERSION)
public class DarkMagicTech {

	public static ArrayList<Augment> augments = new ArrayList<Augment>();
	
	public static Augment speedAugment = new SpeedAugment();
	
	@SidedProxy(serverSide = "darktech.magitech.proxies.CommonProxy", clientSide = "darktech.magitech.proxies.ClientProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e)
	{		
		ModContent.initializeMagiTech();
		augments.add(speedAugment);
		
		MinecraftForge.EVENT_BUS.register(new AugmentHandler());
	    proxy.preInit();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent e)
	{
		proxy.init();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit();
	}
	
}
