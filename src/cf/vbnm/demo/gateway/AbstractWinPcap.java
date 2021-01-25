package cf.vbnm.demo.gateway;

import cf.vbnm.demo.gateway.exceptions.*;

public abstract class AbstractWinPcap {

	private int state;
	String[] devicesDescription;

	static {
		//TODO
		System.load("");
	}

	public AbstractWinPcap() {
		state = Constant.WINPCAP_INIT;
	}

	/**
	 * 查找设备
	 *
	 * @throws FindDevicesException 设备查找问题
	 */
	public void findDevices() throws FindDevicesException {
		if (findDevices0() == 0) {
			state = Constant.WINPCAP_FIND_DEV_FAILURE;
			throw new FindDevicesException("查找设备失败或者无网络设备.");
		} else
			state = Constant.WINPCAP_FIND_DEV_SUCCESS;
	}

	private native int findDevices0();

	/**
	 * 获取设备名称
	 *
	 * @return 返回设备的名称, 如果还没有查找设备, 返回null
	 */
	public String[] getDevicesList() {
		if (state < 2||state==Constant.WINPCAP_CLOSED) {
			return null;
		} else {
			if (devicesDescription == null)
				devicesDescription = obtainDevicesList();
			return devicesDescription;
		}
	}

	private native String[] obtainDevicesList();

	/**
	 * 选择设备
	 *
	 * @param index           设备序号
	 * @param maxCapLen       最大捕获长度
	 * @param promiscuousMode 混杂模式
	 */
	public void openDevice(int index, int maxCapLen, boolean promiscuousMode)
			throws ArgumentsException, FindDevicesException, PcapClosedException {
		if (state < 2) {
			throw new FindDevicesException("Devices are not find yet.");
		}
		if (state == Constant.WINPCAP_CLOSED)
			throw new PcapClosedException("设备已关闭");
		if (index < 0 || index > devicesDescription.length - 1)
			throw new ArgumentsException("设备序号错误.");
		/*过短的数据包捕获就没用,这里应该是小于ip数据包的长度,忘了是多少*/
		if (maxCapLen < 20 || maxCapLen > 65536)
			maxCapLen = 65536;
		try {
			openDevice0(index, maxCapLen, promiscuousMode);
			state = Constant.WINPCAP_DEV_READY;
		} catch (OpenDeviceException e) {
			state = Constant.WINPCAP_OPEN_FAILURE;
			e.printStackTrace();
		}
	}

	private native void openDevice0(int index, int maxCapLen
			, boolean promiscuousMode) throws OpenDeviceException;

	/**
	 * 回调方法, 捕获到一个数据包后如何操作
	 *
	 * @param pkt 捕获到的数据包
	 */
	public abstract void captureLoopCallback(byte[] pkt, int len, int caplen);

	/**
	 * 开始捕获并调用回调方法处理数据
	 */
	public void loopCapture() throws OpenDeviceException, PcapClosedException {
		if (state < Constant.WINPCAP_DEV_READY)
			throw new OpenDeviceException("设备还未打开");
		if (state == Constant.WINPCAP_CLOSED)
			throw new PcapClosedException("设备已关闭");
		loopCapture0();
		state = Constant.WINPCAP_OPEN_LOOP_CAPPING;
	}

	private native void loopCapture0();

	/**
	 * 停止捕获
	 */
	public void breakLoop() {
		if (state != Constant.WINPCAP_OPEN_LOOP_CAPPING)
			return;
		breakLoop0();
		state = Constant.WINPCAP_DEV_READY;
	}

	private native void breakLoop0();

	/**
	 * 捕获下一个数据包
	 *
	 * @return 数据包的数据
	 */
	public byte[] capNext() {
		if (state != Constant.WINPCAP_DEV_READY)
			return null;
		return capNext0();
	}

	private native byte[] capNext0();

	/**
	 * 发送一个数据包
	 *
	 * @throws SendPacketException Error sending the packet
	 */
	public void sendPacket(byte[] pkt) throws SendPacketException,
			OpenDeviceException, PcapClosedException {
		if (state < Constant.WINPCAP_DEV_READY)
			throw new OpenDeviceException("Device not open yet");
		if (state == Constant.WINPCAP_CLOSED)
			throw new PcapClosedException("设备已关闭");
		if (pkt == null || pkt.length == 0)
			return;
		sendPacket0(pkt);
	}

	private native void sendPacket0(byte[] pkt) throws SendPacketException;

	/**
	 * 关闭这个捕获
	 */
	public void close() {
		if (state<Constant.WINPCAP_DEV_READY)
			return;
		if (state==Constant.WINPCAP_DEV_READY)
			close0();
		if (state == Constant.WINPCAP_OPEN_LOOP_CAPPING) {
			breakLoop();
			close0();
		}
		state = Constant.WINPCAP_CLOSED;
	}

	private native void close0();
}
