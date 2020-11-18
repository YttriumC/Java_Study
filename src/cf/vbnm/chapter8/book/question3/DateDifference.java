package cf.vbnm.chapter8.book.question3;

import java.util.Calendar;

public class DateDifference {
	public static void main(String[] args) {
		Calendar dayOne = Calendar.getInstance();
		Calendar dayTwo = Calendar.getInstance();
		try {
			String[] dayOnes = args[0].split("\\D");
			String[] dayTwos = args[1].split("\\D");
			dayOne.set(Integer.parseInt(dayOnes[0]), Integer.parseInt(dayOnes[1]) - 1, Integer.parseInt(dayOnes[2]));
			dayTwo.set(Integer.parseInt(dayTwos[0]), Integer.parseInt(dayTwos[1]) - 1, Integer.parseInt(dayTwos[2]));
			System.out.println("相差" + Math.abs(
					dayOne.getTimeInMillis() - dayTwo.getTimeInMillis()) / (1000 * 3600 * 24) + "天");
		} catch (Exception e) {
			usage();
		}
	}

	static void usage() {
		System.out.println("""
				Usage:
				date date
					date: the date you want to compare.
				        date must have non-number character but blank
				        character to separate the year, month and day.
				    eg. :
				        2020-10-1 or 2020/12/31 or 2020.1.1 etc..
				""");
	}
}
