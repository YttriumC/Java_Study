package cf.vbnm.chapter10;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Test {
	public static void main(String[] args) throws IOException {
		File f = new File("test.txt");
		if (!f.exists()) {
			f.createNewFile();
		}
		FileOutputStream os = new FileOutputStream(f, false);
		os.write("abcde\r\n".getBytes(StandardCharsets.UTF_8));
		os.close();
		System.out.println(f.getAbsolutePath());
		/*****************/
		int n;
		byte[] a = new byte[3];
		InputStream is = new FileInputStream(f);
		while ((n = is.read(a, 0, 3)) != -1) {
			System.out.print(new String(a,0,3));
		}
		is.close();
	}
}
