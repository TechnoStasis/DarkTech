package darktech.core.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import darktech.core.blocks.tile.TileManualGenerator;

public class BlockManualGenerator extends BlockContainer {

	public BlockManualGenerator() {
		super(Material.iron);
		this.setBlockName("manualGenerator");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileManualGenerator();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		TileManualGenerator tile = (TileManualGenerator) world.getTileEntity(x, y, z);
		
		
		return tile.increaseEnergy();
	}
}
