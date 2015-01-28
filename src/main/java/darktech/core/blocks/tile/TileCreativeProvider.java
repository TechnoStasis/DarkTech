package darktech.core.blocks.tile;

import modframe.core.impl.BaseTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import darktech.api.IEnergyTile;
import darktech.api.ITileBindable;

public class TileCreativeProvider extends BaseTile implements IEnergyTile, ITileBindable {

	int x = 0;
	int y = 0;
	int z = 0;
	
	public void updateEntity()
	{
		
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
		//System.out.println("DRAWING ENERGY");
		return 1;
	}  
	
	@Override
	public double getEnergy() {
		
		return 0;
	}

	@Override
	public boolean bindToCoords(int x2, int y2, int z2, World world) {
		x = x2;
		y = y2;
		z = z2;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		
		return true;
	}

}
