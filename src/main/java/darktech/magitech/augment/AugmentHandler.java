package darktech.magitech.augment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import darktech.api.augmentation.Augment;
import darktech.api.augmentation.AugmentHolder;
import darktech.core.DarkTech;
import darktech.magitech.DarkMagicTech;

/**
 * 
 *  Handles the saving and loading of Augments.
 *  
 *  It also handles the ticking of each player augment.
 *  
 *  @author Yvesm
 *  
 *  */
public class AugmentHandler {
	
	public static HashMap<String, AugmentHolder> playerAugments = new HashMap<String, AugmentHolder>();
	
	public static Augment getAugmentFromString(String str)
	{
		for(Augment aug : DarkMagicTech.augments)
		{
			String id = aug.getID();
			if(str.equals(id))
			{
				return aug;
			}
		}
		
		return null;
	}
   
	public static void setAugment(EntityPlayer pl, AugmentHolder aug)
	{	
		playerAugments.put(pl.getDisplayName(), aug);
	}
	
	public static AugmentHolder getCurrentPlayerAugmentHolder(EntityPlayer pl)
	{
		return playerAugments.get(pl.getDisplayName());
	}
	
	@SubscribeEvent
	public void onPlayerTick(LivingUpdateEvent ev)
	{		
		if(ev.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer pl = (EntityPlayer) ev.entityLiving;
			AugmentHolder aug = playerAugments.get(pl.getDisplayName());
			if(aug != null)
				aug.onAugmentUpdate(pl);
			
		}
	}
	
	@SubscribeEvent
	public void loadPlayerFile(PlayerEvent.LoadFromFile ev)
	{
		playerAugments.remove(ev.entityPlayer.getDisplayName());
		File file = ev.getPlayerFile("aug");
		if(file.exists())
		{
			try {
				FileInputStream is = new FileInputStream(file);
				NBTTagCompound tag = CompressedStreamTools.readCompressed(is);
				AugmentHolder holder = new AugmentHolder(null);
				holder.loadFromNBT(tag);
				if(holder.getAugmentInstance() != null)
				    setAugment(ev.entityPlayer, holder);
				else
					setAugment(ev.entityPlayer, null);
				is.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
	
	@SubscribeEvent
	public void savePlayerFile(PlayerEvent.SaveToFile ev)
	{
		File file = ev.getPlayerFile("aug");
			AugmentHolder augH = playerAugments.get(ev.entityPlayer.getDisplayName());
			
			try {
			
			FileOutputStream io = new FileOutputStream(file);
			NBTTagCompound tag = new NBTTagCompound();
			if(augH != null)
			augH.saveToNBT(tag);
			CompressedStreamTools.writeCompressed(tag, io);
			io.close();
			
			} catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
}
