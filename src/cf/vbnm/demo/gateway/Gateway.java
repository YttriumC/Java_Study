package cf.vbnm.demo.gateway;

public class Gateway {

	public native byte[] getPacket(PacketHeader packetHeader);

	public native void send(byte[] packet);

	public native byte[][] getNetworkInterface();

}

