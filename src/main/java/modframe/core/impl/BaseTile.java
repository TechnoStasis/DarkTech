package modframe.core.impl;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class BaseTile extends TileEntity {

	public void readFromNBT(NBTTagCompound cmp) {
		super.readFromNBT(cmp);
		readNBTData(cmp);
	}

	public void readNBTData(NBTTagCompound t) {

	}

	public void writeToNBT(NBTTagCompound cmp) {
		super.writeToNBT(cmp);
		writeNBTData(cmp);
	}

	public void writeNBTData(NBTTagCompound t) {

	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeNBTData(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, -999, nbttagcompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
		this.readNBTData(pkt.func_148857_g());
	}

}
