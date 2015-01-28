package darktech.magitech.blocks.tile;

import java.util.List;

import modframe.core.impl.BaseTile;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import darktech.api.IEnergyTile;
import darktech.api.ITileBindable;
import darktech.core.util.DarkUtil;

public class TileRelay extends BaseTile implements IEnergyTile, ITileBindable {

	int x = 0;
	int y = -1;
	int z = 0;

	public void updateEntity() {
		if(!DarkUtil.validateIfEnergetic(x, y, z, worldObj)){
			x = 0;
			y = -1;
			z = 0;
		return;
		}
	}

	public void readNBTData(NBTTagCompound cmp) {
		x = cmp.getInteger("sourceX");
		y = cmp.getInteger("sourceY");
		z = cmp.getInteger("sourceZ");
	}

	public void writeNBTData(NBTTagCompound cmp) {
		cmp.setInteger("sourceX", x);
		cmp.setInteger("sourceY", y);
		cmp.setInteger("sourceZ", z);
	}

	@Override
	public double drawEnergy() {
		if (DarkUtil.validateIfEnergetic(x, y, z, worldObj)) {
			IEnergyTile energy = (IEnergyTile) worldObj.getTileEntity(x, y, z);
			worldObj.spawnParticle("portal", xCoord + worldObj.rand.nextDouble(), yCoord + worldObj.rand.nextDouble(), zCoord + worldObj.rand.nextDouble(), 0, 0, 0);
			return energy.drawEnergy();
		}
		return 0;
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
