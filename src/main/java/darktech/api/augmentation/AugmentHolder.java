package darktech.api.augmentation;

import darktech.magitech.augment.AugmentHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

/**
 * A class that handles the saving and loading of {@link Augment}s
 * 
 * Allowing augments to store player specific NBT data
 *  
 *  @author Yvesm
 *  */
public class AugmentHolder {

	public NBTTagCompound augmentTagCompound = new NBTTagCompound();
	private Augment augment = null;
	
	public AugmentHolder(Augment aug)
	{
		augment = aug;
	}
	
	public Augment getAugmentInstance()
	{
		return augment;
	}
	
	public void onAugmentUpdate(EntityPlayer pl)
	{
		if(augment != null)
			augment.onAugmentTick(pl, augmentTagCompound);
	}
	
	/**
	 * 
	 * Creates an augment from the nbt. If augment is null it is ignored by {@link darktech.magitech.augment.AugmentHandler}
	 * 
	 * */
	public void loadFromNBT(NBTTagCompound tag)
	{
		augment = AugmentHandler.getAugmentFromString(tag.getString("augID"));
		NBTTagCompound augmentNBT = tag.getCompoundTag("augmentTag");
		augmentTagCompound = augmentNBT;
	}
	
	public void saveToNBT(NBTTagCompound tag)
	{
		if(augment != null)
		tag.setString("augID", augment.getID());
		if(augmentTagCompound != null)
			tag.setTag("augmentTag", augmentTagCompound);
	}
	
}
