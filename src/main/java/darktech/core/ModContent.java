package darktech.core;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import darktech.core.blocks.BlockCreativeProvider;
import darktech.core.blocks.BlockInfiniteDrainer;
import darktech.core.blocks.BlockManualGenerator;
import darktech.core.blocks.tile.TileCreativeProvider;
import darktech.core.blocks.tile.TileInfiniteDrainer;
import darktech.core.blocks.tile.TileManualGenerator;
import darktech.core.items.ItemBinder;
import darktech.magitech.blocks.BlockRelay;
import darktech.magitech.blocks.BlockVoidCrucible;
import darktech.magitech.blocks.tile.TileRelay;
import darktech.magitech.blocks.tile.TileVoidCrucible;

public class ModContent {

	public static BlockManualGenerator basicGen = new BlockManualGenerator();
	public static BlockInfiniteDrainer infinitum = new BlockInfiniteDrainer();
	public static BlockCreativeProvider creativeProvider = new BlockCreativeProvider();
	public static BlockRelay relay = new BlockRelay();
	public static BlockVoidCrucible voidCrucible = new BlockVoidCrucible();
	
	public static ItemBinder binder = new ItemBinder();
	
	public static void initializeCore()
	{
		rbt(basicGen, "basicGen", TileManualGenerator.class, "basicGenerator");
		rbt(creativeProvider, "creativeProvider", TileCreativeProvider.class, "creativeProvider");
		rbt(infinitum, "infinitum", TileInfiniteDrainer.class, "infinitum");
		
		GameRegistry.registerItem(binder, "binder");
	}
	
	public static void initializeMagiTech()
	{
		rbt(relay, "relay", TileRelay.class, "relay");
		rbt(voidCrucible, "voidCrucible", TileVoidCrucible.class, "voidCrucible");
	}
	
	public static void rb(Block b, String s)
	{
		b.setBlockName("darktech:" + s);
		GameRegistry.registerBlock(b, s);
	}
	
	public static void rbt(Block b, String s, Class c, String z)
	{
		rb(b,s);
		GameRegistry.registerTileEntity(c, z);
	}
	
}
