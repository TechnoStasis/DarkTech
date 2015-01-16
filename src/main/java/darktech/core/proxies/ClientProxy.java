package darktech.core.proxies;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import darktech.core.ModContent;
import darktech.core.blocks.tile.TileRelay;
import darktech.core.client.render.VoidCrucibleRenderer;

public class ClientProxy extends CommonProxy {

	public void preInit() {

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModContent.relay), new VoidCrucibleRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileRelay.class, new VoidCrucibleRenderer());
	}

	public void mainInit() {

	}

	public void postInit() {

	}
}
