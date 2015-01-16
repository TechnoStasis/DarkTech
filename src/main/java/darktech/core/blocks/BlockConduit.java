package darktech.core.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import darktech.api.ITileBindable;
import darktech.core.DarkTech;
import darktech.core.blocks.tile.TileRelay;
import darktech.core.util.DarkUtil;

public class BlockConduit extends BlockContainer {

	public BlockConduit() {
		super(Material.iron);
		setBlockBounds(0.30F,0.30F,0.30F,0.70F,0.70F,0.70F);
		setBlockName("conduit");
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
	public int getRenderType()
	{
	return -1;
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		
		return new TileRelay();
	}

}
