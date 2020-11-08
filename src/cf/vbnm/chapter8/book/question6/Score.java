package cf.vbnm.chapter8.book.question6;

import java.util.Scanner;

public class Score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subjects = 0;
		float totalScore = 0;
		while (sc.hasNext()) {
			try {
				totalScore = sc.nextFloat();
			} catch (Exception e) {
				sc.next();
			}


		}
	}
}
