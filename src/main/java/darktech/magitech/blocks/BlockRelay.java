package darktech.magitech.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import darktech.api.ITileBindable;
import darktech.core.DarkTech;
import darktech.core.util.DarkUtil;
import darktech.magitech.blocks.tile.TileRelay;

public class BlockRelay extends BlockContainer {

	public BlockRelay() {
		super(Material.iron);
		setBlockBounds(0.30F,0.30F,0.30F,0.70F,0.70F,0.70F);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		
		return new TileRelay();
	}

}
