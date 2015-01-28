package darktech.magitech.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import darktech.api.augmentation.Augment;
import darktech.api.augmentation.AugmentHolder;
import darktech.magitech.augment.AugmentHandler;
import darktech.magitech.augment.SpeedAugment;
import darktech.magitech.blocks.tile.TileVoidCrucible;

public class BlockVoidCrucible extends BlockContainer {

	public BlockVoidCrucible() {
		super(Material.iron);
		this.setHardness(4);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(world.isRemote)
			return false;
		
		TileEntity t = world.getTileEntity(x, y, z);
		
		if(AugmentHandler.playerAugments.get(p.getDisplayName()) != null && AugmentHandler.playerAugments.get(p.getDisplayName()).getAugmentInstance() instanceof SpeedAugment)
			AugmentHandler.setAugment(p, null);
		else {
			AugmentHolder holder = new AugmentHolder(new SpeedAugment());
		    AugmentHandler.setAugment(p, holder);
		}
		if(p != null && t != null && t instanceof TileVoidCrucible)
		{
			TileVoidCrucible vozd = (TileVoidCrucible)t;
			ItemStack stack = p.getCurrentEquippedItem();
			if(stack != null && vozd.getStackInSlot(0) == null)
			{
				
				ItemStack invStack = stack.copy();
				invStack.stackSize = 1;
				if(vozd.isItemValidForSlot(0, invStack)) {
				 vozd.setInventorySlotContents(0, invStack);
				 stack.stackSize-=1;
				 p.inventory.markDirty();
				 world.markBlockForUpdate(x, y, z);
			    }
			} else
			{
				if(vozd.getStackInSlot(0) != null)
				{
					EntityItem item = new EntityItem(world, x, y, z, vozd.getStackInSlot(0));
					item.age = 5000;
					item.delayBeforeCanPickup = 20;
					world.spawnEntityInWorld(item);
					vozd.setInventorySlotContents(0, null);
					 world.markBlockForUpdate(x, y, z);
				}
			}
			
			return true;
		}
		return false;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_)
    {
	    TileVoidCrucible tile = (TileVoidCrucible) world.getTileEntity(x, y, z);
        ItemStack stack = tile.getStackInSlot(0);
        if(stack != null)
        {
        	EntityItem item = new EntityItem(world, x, y, z, stack);
        	item.age = 5000;
        	item.delayBeforeCanPickup = 20;
        	world.spawnEntityInWorld(item);
        }
        super.breakBlock(world, x, y, z, block, p_149749_6_);
       
    }
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {

		return new TileVoidCrucible();
	}

}
