package darktech.core.items;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import darktech.api.ITileBindable;
import darktech.core.thirdparty.ftb.NBTHelper;
import darktech.core.util.DarkUtil;

public class ItemBinder extends Item {

	public ItemBinder() {
		super();
		this.setUnlocalizedName("binder");
		setMaxStackSize(1);
	}

	//@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
	 if((getBindY(stack) != -1) || getBindY(stack) != 0) list.add("Binding Coords: " + DarkUtil.convertCoordsToString(getBindX(stack), getBindY(stack), getBindZ(stack)));
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int wz, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		
	    if(world.isRemote)
	    	return false;
		MovingObjectPosition mop = Minecraft.getMinecraft().objectMouseOver;
		
		int x = mop.blockX;
		int y = mop.blockY;
		int z = mop.blockZ;
		
		TileEntity tile = world.getTileEntity(x,y,z);
		
		if(getBindY(stack) == -1 || getBindY(stack) == 0)
		{
			if(DarkUtil.validateIfBindable(x, y, z, world))
			{
				setBind(stack,x,y,z);
				player.addChatMessage(new ChatComponentText("Bound to: " + DarkUtil.convertCoordsToString(x, y, z)));
			}
		} else
		{
			if(DarkUtil.validateIfBindable(getBindX(stack), getBindY(stack), getBindZ(stack), world) && DarkUtil.validateIfBindable(x, y, z, world))
			{
				ITileBindable bind = DarkUtil.castTileToBindable(getBindX(stack), getBindY(stack), getBindZ(stack), world);
				bind.bindToCoords(x, y, z, world);
				player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Successfuly bound block"));
				//System.out.println("SUCCESS!");
				
				setBind(stack, 0, -1, 0);
			} else
			{
				//System.out.println(DarkUtil.validateIfBindable(getBindX(stack), getBindY(stack), getBindZ(stack), world));
				//System.out.println("FAIL!!");
				player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "darktech.api.BindableNotFoundException: Was not able to find original bound block."));
				setBind(stack,0,-1,0);
			}
		}

		return false;
	}

	public void setBind(ItemStack stack, int x, int y, int z) {;
		NBTHelper.setInteger(stack, "bindX", x);
		NBTHelper.setInteger(stack, "bindY", y);
		NBTHelper.setInteger(stack, "bindZ", z);
		//System.out.println("SUCCESSFULLY BOUND! :" + DarkUtil.convertCoordsToString(x,y,z));
	}

	public int getBindX(ItemStack stack) {
		return NBTHelper.getInt(stack, "bindX");
	}

	public int getBindY(ItemStack stack) {
		return NBTHelper.getInt(stack, "bindY");
	}

	public int getBindZ(ItemStack stack) {
		return NBTHelper.getInt(stack, "bindZ");
	}
}
