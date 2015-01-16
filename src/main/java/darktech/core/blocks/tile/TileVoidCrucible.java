package darktech.core.blocks.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import darktech.api.IEnergyTile;
import darktech.api.ITileBindable;
import darktech.core.util.DarkUtil;

public class TileVoidCrucible extends BaseTile implements IEnergyTile,ITileBindable {

	int x = 0;
	int y = 0;
	int z = 0;
	
	public static double maxEnergy = 100000;
	double energy = 0;
	
	public void writeNBTData(NBTTagCompound t)
	{
		t.setInteger("sourceX", x);
		t.setInteger("sourceY", y);
		t.setInteger("sourceZ", z);
		
		t.setDouble("storedEnergy", energy);
	}
	
	public void readNBTData(NBTTagCompound t)
	{
		x = t.getInteger("sourceX");
		y = t.getInteger("sourceY");
		z = t.getInteger("sourceZ");
		
		energy = t.getDouble("storedEnergy");
	}
	
	public void updateEntity()
	{
		if(!DarkUtil.validateIfEnergetic(x, y, z, worldObj)){
			x = 0;
			y = -1;
			z = 0;
		return;
		}
		
		//Just a fail safe for ClassCastExceptions
		if(maxEnergy > energy && !DarkUtil.validateIfEnergetic(x, y, z, worldObj))
		{
			IEnergyTile e = (IEnergyTile) worldObj.getTileEntity(x, y, z);
			
			energy += e.drawEnergy();
		}
	}

	@Override
	public void bindToCoords(int x2, int y2, int z2, World world) {

		
	}

	@Override
	public double drawEnergy() {
		// NO-OP Ruins the complete purpose of relays.
		return 0;
	}

	@Override
	public double getEnergy() {
		
		return energy;
	}
	
}
