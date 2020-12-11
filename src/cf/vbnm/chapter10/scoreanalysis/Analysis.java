package cf.vbnm.chapter10.scoreanalysis;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Analysis {
	public static double getTotalScore(String s) {
		Scanner sc = new Scanner(s);
		sc.useDelimiter("[^0-9\\.]+");
		double totalScore = 0;
		while (sc.hasNext()) {
			try {
				totalScore += sc.nextDouble();
			} catch (InputMismatchException e) {
				sc.next();
			}
		}
		return totalScore;
	}
}
