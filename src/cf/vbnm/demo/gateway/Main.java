package cf.vbnm.demo.gateway;

import cf.vbnm.demo.gateway.exceptions.ArgumentsException;
import cf.vbnm.demo.gateway.exceptions.FindDevicesException;
import cf.vbnm.demo.gateway.exceptions.OpenDeviceException;
import cf.vbnm.demo.gateway.exceptions.PcapClosedException;

public class Main {
	public static void main(String[] args) {
		AbstractWinPcap winPcap = new AbstractWinPcap() {
			@Override
			public void captureLoopCallback(byte[] pkt, int len, int caplen) {
				System.out.printf("%02X:%02X:%02X:%02X:%02X:%02X->" +
								"%02X:%02X:%02X:%02X:%02X:%02X len=%d,caplen=%d",
						pkt[0], pkt[1], pkt[2], pkt[3], pkt[4], pkt[5],
						pkt[6], pkt[7], pkt[8], pkt[9], pkt[10], pkt[11],
						len, caplen);
			}
		};
		try {
			winPcap.findDevices();
		} catch (FindDevicesException e) {
			e.printStackTrace();
		}
		String[] devs = winPcap.getDevicesList();
		for (int i = 0; i < devs.length; i++) {
			System.out.println(i + ":" + devs[i]);
		}
		try {
			winPcap.openDevice(2, 13234, true);
		} catch (ArgumentsException | FindDevicesException | PcapClosedException e) {
			e.printStackTrace();
		}
		try {
			winPcap.loopCapture();
		} catch (OpenDeviceException | PcapClosedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(10001);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		winPcap.close();
	}
}
