package darktech.magitech.proxies;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import darktech.core.ModContent;
import darktech.core.client.render.VoidCrucibleRenderer;
import darktech.magitech.blocks.tile.TileVoidCrucible;

public class ClientProxy extends CommonProxy {

	public void preInit()
	{
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModContent.voidCrucible), new VoidCrucibleRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileVoidCrucible.class, new VoidCrucibleRenderer());
	}
	
}
