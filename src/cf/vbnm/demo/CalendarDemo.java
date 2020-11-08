package cf.vbnm.demo;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		System.out.println(date.getYear());
		calendar.set(date.getYear()+1900, date.getMonth(),1);
		CalendarDemo demo = new CalendarDemo();
		demo.printCalender(calendar);
	}


	public void printCalender(Calendar calendar) {
//		int month = calendar.get(Calendar.MONTH) + 1;
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		int daysOfMonth;
		switch (calendar.get(Calendar.MONTH) + 1) {
			case 2:
				if (calendar.get(Calendar.YEAR) % 4 == 0) {
					daysOfMonth = 29;
					if (calendar.get(Calendar.YEAR) % 100 == 0 && !(calendar.get(Calendar.YEAR) % 400 == 0))
						daysOfMonth = 28;
				} else
					daysOfMonth = 28;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				daysOfMonth = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				daysOfMonth = 30;
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + calendar.get(Calendar.MONTH) + 1);
		}
		System.out.println("日 一 二  三 四  五 六");
		for (int i = 0, j = 1; i < daysOfMonth; j++) {
			if (j < weekDay) {
				System.out.print("   ");
				continue;
			}
			System.out.printf("%-2d ", ++i);
			if (j % 7 == 0)
				System.out.println();
		}
	}

}