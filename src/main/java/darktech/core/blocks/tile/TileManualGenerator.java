package darktech.core.blocks.tile;

import modframe.core.impl.BaseTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import darktech.api.IEnergyTile;
import darktech.api.ITileBindable;
import darktech.core.util.DarkUtil;

public class TileManualGenerator extends BaseTile implements IEnergyTile, ITileBindable {
	public int energy;
	public int maxEnergy = 100;
	
	int x = 0;
	int y = 0;
	int z = 0;
	
	public void updateEntity()
	{
		if(!DarkUtil.validateIfEnergetic(x, y, z, worldObj)){
			x = 0;
			y = -1;
			z = 0;
		return;
		}
	}
	
	public void readNBTData(NBTTagCompound t){
		energy = t.getInteger("energy");
		x = t.getInteger("sourceX");
		y = t.getInteger("sourceY");
		z = t.getInteger("sourceZ");
	}
	
	public void writeNBTData(NBTTagCompound t)
	{
		t.setInteger("energy", energy);
		t.setInteger("sourceX", x);
		t.setInteger("sourceY", y);
		t.setInteger("sourceZ", z);
	}

	@Override
	public double drawEnergy() {
		if(energy - 1 < 0)
		{
			energy-=1;
			return 1;
		}
		return 0;
	}

	@Override
	public double getEnergy() {
		
		return energy;
	}
	
	public boolean increaseEnergy()
	{
		if(energy < maxEnergy)
		{
			energy+=0.1;
			return true;
		}
		return false;
	}

	@Override
	public boolean bindToCoords(int x2, int y2, int z2, World world) {
		// NO-OP
		return false;
	}
	
}
