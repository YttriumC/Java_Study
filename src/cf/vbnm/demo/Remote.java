package cf.vbnm.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Remote {
	//3389
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		InputStream recStream;
		Socket sendSocket = null;
		try {

			serverSocket = new ServerSocket(3389);
			recStream = serverSocket.accept().getInputStream();
			sendSocket = new Socket();

			byte[] in = new byte[3072];
			while (true) {
				recStream.read(in);

			}
		} catch (IOException e) {
			System.err.println("input stream error");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				sendSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}

class Local {
	public static void main(String[] args) {

	}
}
