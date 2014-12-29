package darktech.core.blocks.tile;

import darktech.api.IEnergyTile;
import darktech.api.ITileBindable;
import darktech.core.util.DarkUtil;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TileInfiniteDrainer extends BaseTile implements IEnergyTile, ITileBindable {

	int x = 0;
	int y = 0;
	int z = 0;
	
	public void updateEntity()
	{
		if(DarkUtil.validateIfEnergetic(x, y, z, getWorldObj()))
		{
			IEnergyTile tile = (IEnergyTile) worldObj.getTileEntity(x, y, z);
			if(tile.drawEnergy() > 0)
			{
				worldObj.setBlock(xCoord, yCoord + 1, zCoord, Blocks.bedrock);
			}
				
		}
	}
	
	public void readNBTData(NBTTagCompound cmp)
	{
		x = cmp.getInteger("sourceX");
		y = cmp.getInteger("sourceY");
		z = cmp.getInteger("sourceZ");
	}
	
	public void writeNBTData(NBTTagCompound cmp)
	{
		cmp.setInteger("sourceX", x);
		cmp.setInteger("sourceY", y);
		cmp.setInteger("sourceZ", z);
	}
	
	@Override
	public double drawEnergy() {
		return 0;
	}  
	
	@Override
	public double getEnergy() {
		
		return 0;
	}

	@Override
	public void bindToCoords(int x2, int y2, int z2, World world) {
		x = x2;
		y = y2;
		z = z2;
		
		System.out.println("ITS A TRAP");
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);		
	}
	
}
