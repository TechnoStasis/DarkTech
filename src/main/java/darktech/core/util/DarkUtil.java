package darktech.core.util;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import darktech.api.ITileBindable;

public class DarkUtil {

	public static String convertCoordsToString(double x, double y, double z)
	{
		return "X: " + x + " Y: " + y + " Z: " + z;
	}
	
	public static boolean validateIfBindable(int x, int y, int z, World world) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if(tile != null && tile instanceof ITileBindable)
		{
			return true;
		}
		return false;
	}
	
	public static ITileBindable castTileToBindable(int x, int y, int z, World world)
	{
		if(validateIfBindable(x,y,z,world))
		{
			return (ITileBindable) world.getTileEntity(x, y, z);
		}
		
		return null;
	}
	
}
