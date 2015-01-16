package darktech.core;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import darktech.core.blocks.BlockConduit;
import darktech.core.blocks.BlockCreativeProvider;
import darktech.core.blocks.BlockInfiniteDrainer;
import darktech.core.blocks.BlockManualGenerator;
import darktech.core.blocks.tile.TileRelay;
import darktech.core.blocks.tile.TileCreativeProvider;
import darktech.core.blocks.tile.TileInfiniteDrainer;
import darktech.core.blocks.tile.TileManualGenerator;
import darktech.core.items.ItemBinder;

public class ModContent {

	public static BlockManualGenerator basicGen = new BlockManualGenerator();
	public static BlockInfiniteDrainer infinitum = new BlockInfiniteDrainer();
	public static BlockCreativeProvider b2 = new BlockCreativeProvider();
	public static BlockConduit relay = new BlockConduit();
	
	public static ItemBinder binder = new ItemBinder();
	
	public static void i()
	{
		rbt(basicGen, "basicGen", TileManualGenerator.class, "basicGenerator");
		rbt(relay, "relay", TileRelay.class, "relay");
		rbt(b2, "creativeProvider", TileCreativeProvider.class, "creativeProvider");
		rbt(infinitum, "infinitum", TileInfiniteDrainer.class, "infinitum");
		
		GameRegistry.registerItem(binder, "binder");
	}
	
	public static void rb(Block b, String s)
	{
		GameRegistry.registerBlock(b, s);
	}
	
	public static void rbt(Block b, String s, Class c, String z)
	{
		rb(b,s);
		GameRegistry.registerTileEntity(c, z);
	}
	
}