package cf.vbnm.chapter10.book;

import java.io.*;

public class ReadByLine {
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("out\\readByLineOut.txt"));
			BufferedReader br = new BufferedReader(new FileReader("out\\readByLine.txt"));
			String in;
			int lineNumber = 1;
			while ((in = br.readLine()) != null) {
				System.out.printf("%4d %s\n", lineNumber, in);
				bw.write(String.format("%4d ", lineNumber++));
				bw.write(in);
				bw.newLine();
			}
			bw.flush();
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
