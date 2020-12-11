package cf.vbnm.chapter10.scoreanalysis;

import java.io.*;

public class AnalysisResult {
	public static void main(String[] args) {
		File fRead = new File("out\\score.txt");
		File fWrite = new File("out\\scoreAnalysis.txt");
		try {
			Writer out = new FileWriter(fWrite, true);
			BufferedWriter bw = new BufferedWriter(out);
			Reader fr = new FileReader(fRead);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while ((str = br.readLine()) != null) {
				double totalScore = Analysis.getTotalScore(str);
				str = str + "总分:" + totalScore;
				System.out.println(str);
				bw.write(str);
				bw.newLine();
			}
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
}
