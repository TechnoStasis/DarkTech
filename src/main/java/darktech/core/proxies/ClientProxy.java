package darktech.core.proxies;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import darktech.core.ModBlocks;
import darktech.core.blocks.tile.TileConduit;
import darktech.core.client.render.VoidCrucibleRenderer;

public class ClientProxy extends CommonProxy {

	public void preInit() {

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.relay), new VoidCrucibleRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileConduit.class, new VoidCrucibleRenderer());
	}

	public void mainInit() {

	}

	public void postInit() {

	}
}
