package darktech.core.util;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import darktech.api.IEnergyTile;
import darktech.api.ITileBindable;

/**
 * 
 * Utility methods to aid in the tediousness that is debugging.
 * 
 * ***/
public class DarkUtil {

	public static String convertCoordsToString(double x, double y, double z)
	{
		return "X: " + x + " Y: " + y + " Z: " + z;
	}
	
	public static boolean validateIfEnergetic(int x, int y, int z, World worldObj)
	{
		TileEntity tile = worldObj.getTileEntity(x, y, z);
		if(tile != null && tile instanceof IEnergyTile)
		{
			return true;
		}
		return false;
	}
	
	public static boolean validateIfTileBindable(int x, int y, int z, World world) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if(tile != null && tile instanceof ITileBindable)
		{
			return true;
		}
		return false;
	}
	
	public static ITileBindable castTileToBindable(int x, int y, int z, World world)
	{
		if(validateIfTileBindable(x,y,z,world))
		{
			return (ITileBindable) world.getTileEntity(x, y, z);
		}
		
		return null;
	}
	
}
