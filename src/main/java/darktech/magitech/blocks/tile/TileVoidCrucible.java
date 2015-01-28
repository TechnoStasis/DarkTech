package darktech.magitech.blocks.tile;

import modframe.core.impl.BaseTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import darktech.api.IEnergyTile;
import darktech.api.ITileBindable;
import darktech.core.util.DarkUtil;

public class TileVoidCrucible extends BaseTile implements IEnergyTile, ITileBindable, IInventory {

	public ItemStack[] stacks = new ItemStack[1];
	
	int x = 0;
	int y = 0;
	int z = 0;
	
	public static double maxEnergy = 100000;
	double energy = 0;
	
	public void writeNBTData(NBTTagCompound t)
	{
		t.setInteger("sourceX", x);
		t.setInteger("sourceY", y);
		t.setInteger("sourceZ", z);
		
		t.setDouble("storedEnergy", energy);
		
		NBTTagList list = new NBTTagList();
		for(int i = 0; i < stacks.length; i++)
		{
			if(stacks[i] != null){
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("slot", (byte) i);
				stacks[i].writeToNBT(tag);
				list.appendTag(tag);
			}
		}
		
		t.setTag("inv", list);
	}
	
	public void readNBTData(NBTTagCompound t)
	{
		x = t.getInteger("sourceX");
		y = t.getInteger("sourceY");
		z = t.getInteger("sourceZ");
		
		energy = t.getDouble("storedEnergy");
		NBTTagList taglist = t.getTagList("inv", 10);
		for (int i = 0; i < stacks.length; i++) {
			NBTTagCompound tag = taglist.getCompoundTagAt(i);
			byte slot = tag.getByte("slot");
			if(slot >= 0 && slot < stacks.length)
			stacks[i] = ItemStack.loadItemStackFromNBT(tag);
		}
	}
	
	public void updateEntity()
	{
		if(!DarkUtil.validateIfEnergetic(x, y, z, worldObj)){
			x = 0;
			y = -1;
			z = 0;
		return;
		}
		
		if(maxEnergy > energy && !DarkUtil.validateIfEnergetic(x, y, z, worldObj))
		{
			IEnergyTile e = (IEnergyTile) worldObj.getTileEntity(x, y, z);
			
			energy += e.drawEnergy();
		}
	}

	@Override
	public boolean bindToCoords(int x2, int y2, int z2, World world) {

		return false;
	}

	@Override
	public double drawEnergy() {
		
		return 0;
	}

	@Override
	public double getEnergy() {
		
		return energy;
	}

	
	//-- inventory
	@Override
	public int getSizeInventory() {
		
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		if(stacks[slot] != null)
		{
			return stacks[slot];
		}
		return null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = stacks[slot];
		if(stack != null)
		{
			if(stack.stackSize <= amount)
			{
				this.setInventorySlotContents(slot, null);
				markDirty();
			} else
			{
				stack = stack.splitStack(amount);
				if(stack.stackSize <= 0)
				{
					this.setInventorySlotContents(slot, null);
				}
				markDirty();
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		if(slot < stacks.length)
		{
			stacks[slot] = stack;
			this.markDirty();
		}
		
	}

	@Override
	public String getInventoryName() {
		
		return "name.voidCrucible.darktech.thisisaname";
	}

	@Override
	public boolean hasCustomInventoryName() {
		
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		
		return false;
	}

	@Override
	public void openInventory() { }

	@Override
	public void closeInventory() { }

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		
		return true;
	}
	
}
