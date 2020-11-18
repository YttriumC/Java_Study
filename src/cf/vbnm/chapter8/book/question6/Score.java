package cf.vbnm.chapter8.book.question6;
import java.util.Scanner;
public class Score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc=new Scanner(sc.nextLine());
		sc.useDelimiter("[^\\d+\\.?\\d*]+");
		int subjects = 0;
		float totalScore = 0;
		while (sc.hasNext()) {
			try {
				String n=sc.next("\\d+\\.?\\d*");
				totalScore += Float.parseFloat(n);
				subjects++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("总分:" + totalScore + ",平均分:" + totalScore / subjects);
	}
}
