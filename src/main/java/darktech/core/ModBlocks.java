package darktech.core;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import darktech.core.blocks.BlockConduit;
import darktech.core.blocks.tile.TileConduit;
import darktech.core.items.ItemBinder;

public class ModBlocks {

	public static BlockConduit relay = new BlockConduit();
	public static ItemBinder binder = new ItemBinder();
	
	public static void i()
	{
		rbt(relay, "relay", TileConduit.class, "relay");
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
