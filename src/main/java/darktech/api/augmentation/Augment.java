package darktech.api.augmentation;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.Loader;

/** 
 * An abstract class that manipulates a player every entity update.
 * 
 * NBT Data is handled by {@link AugmentHolder} as well as loading, saving and ticking.
 * 
 * Augments are static instances, and any player specific data must be loaded and saved with {@link net.minecraft.nbt.NBTTagCompound}
 * 
 * Any data saved in augment instances not using NBT will be static and will not persist on shutdown.
 * 
 * @author Yvesm
 * */
public abstract class Augment {


	String id = "";
	

	/**
	 * Creates a new augment with ID using {@link java.lang.String}
	 *  
	 *  */
	public Augment(String id)
	{
		setID(id);
	}
	
	public abstract void onAugmentPlayerCreate(EntityPlayer pl, NBTTagCompound tag);
	
	public abstract void onAugmentTick(EntityPlayer pl, NBTTagCompound tag);
	
	public abstract void onAugmentPlayerDestroy(EntityPlayer pl, NBTTagCompound tag);
	
	public void setID(String s)
	{
		id = s;
	}
	
	public String getID()
	{
		return id;
	}
}
