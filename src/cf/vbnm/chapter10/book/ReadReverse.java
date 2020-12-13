package cf.vbnm.chapter10.book;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadReverse {
	public static void main(String[] args) {
		RandomAccessFile raf;
		try {
			//abcdefghijklmnopqrstuvwxyz
			raf = new RandomAccessFile("out\\reverse.txt", "r");
			long position = (raf.length());
			while (position-- > 0) {
				raf.seek(position);
				System.out.print((char) raf.read());
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
