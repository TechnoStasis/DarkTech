package darktech.api;

import net.minecraft.world.World;

/**
 * 
 * An interface for being able to bind a certain object into a location in 3D space. 
 * Can be used in any type of 3D space game engine.
 * 
 * **/
public interface ITileBindable {

	/***
	 * 
	 * Method invoked to bind the class that implements this to a certain location.
	 * 
	 * Uses minecraft style XYZ position system.
	 * 
	 * NOTE: Despite what some other programs use, the Z is not an altitude axis!
	 * 
	 * @param x The X Coord, East West Axis
	 * @param y The Altitude Axis
	 * @param z The Z Coord, South North Axis
	 * 
	 * **/
	public void bindToCoords(int x2, int y2, int z2, World world);
	
}

