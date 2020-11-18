package cf.vbnm.demo;

import javax.net.SocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Gateway {
	SocketFactory socketFactory;
	ServerSocket serverSocket;

	static void accept(Socket in, Gateway gateway) {
		byte[] inBuffer = new byte[8 * 1480];
		byte[] outBuffer = new byte[8 * 14808];
		Socket out;
		InputStream inInput, outInput;
		OutputStream inOutput, outOutput;
		try {
			out = gateway.socketFactory.createSocket(in.getInetAddress(), in.getPort());
			out.setSoTimeout(3000);
			inInput = in.getInputStream();
			inOutput = in.getOutputStream();
			outInput = out.getInputStream();
			outOutput = out.getOutputStream();
			new Thread(() -> {
				try {
					while (true) {
						int readLen = inInput.read(inBuffer);
						outOutput.write(inBuffer, 0, readLen);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).start();
			new Thread(() -> {
				try {
					while (true) {
						int readLen = outInput.read(outBuffer);
						inOutput.write(inBuffer, 0, readLen);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Gateway gateway = new Gateway();
		int count = 0;
		gateway.socketFactory = new SocketFactory() {
			@Override
			public Socket createSocket(String s, int i) throws IOException, UnknownHostException {
				return new Socket(s, i);
			}

			@Override
			public Socket createSocket(String s, int i, InetAddress inetAddress, int i1) throws IOException, UnknownHostException {
				return new Socket(s, i, inetAddress, i1);
			}

			@Override
			public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
				return new Socket(inetAddress, i);
			}

			@Override
			public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress1, int i1) throws IOException {
				return new Socket(inetAddress, i, inetAddress1, i1);
			}
		};
		try {
			gateway.serverSocket = new ServerSocket(10888);
			while (true) {
				System.out.println("等待连接");
				Socket in = gateway.serverSocket.accept();
				System.out.println(in.getLocalAddress()+":"+in.getPort());
				in.setSoTimeout(16000);
				System.out.println("第" + ++count + "个连接");
				{
					byte[] bytes=new byte[200];
					System.out.println(in.getInetAddress()+":"+in.getPort());
					int read = in.getInputStream().read(bytes);
					System.out.println(Arrays.toString(bytes));
				}
	//			accept(in, gateway);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("port 10888 is busy");
			System.exit(1);
		}


	}
}
