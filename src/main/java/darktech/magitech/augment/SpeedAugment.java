package darktech.magitech.augment;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import darktech.api.augmentation.Augment;

public class SpeedAugment extends Augment {
	
	public SpeedAugment() {
		super("speedAugment");
		
	}

	@Override
	public void onAugmentPlayerCreate(EntityPlayer pl, NBTTagCompound tag) {

	}

	@Override
	public void onAugmentTick(EntityPlayer pl, NBTTagCompound tag) {
		if(!pl.worldObj.isRemote)
			return;
		if(pl.moveForward > 0F && pl.onGround)
		{
			pl.moveFlying(0, 1, 0.1F);
		}

		//System.out.println(tag.getString("yoyo"));
		
	}

	@Override
	public void onAugmentPlayerDestroy(EntityPlayer pl, NBTTagCompound tag) {

	}

}
