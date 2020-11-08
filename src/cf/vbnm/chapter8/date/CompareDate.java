package cf.vbnm.chapter8.date;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CompareDate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入第一个年,月,日数据");
		System.out.println("输入年份");
		short year1 = sc.nextShort();
		System.out.println("输入月份");
		short month1 = sc.nextShort();
		System.out.println("输入日期");
		short day1 = sc.nextShort();
		System.out.println("输入第二个年,月,日数据");
		System.out.println("输入年份");
		short year2 = sc.nextShort();
		System.out.println("输入月份");
		short month2 = sc.nextShort();
		System.out.println("输入日期");
		short day2 = sc.nextShort();
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(year1, month1 - 1, day1);
		long milliSecond1 = calendar1.getTimeInMillis();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(year2, month2 - 1, day2);
		long milliSecond2 = calendar2.getTimeInMillis();
		Date date1 = new Date(milliSecond1);
		Date date2 = new Date(milliSecond2);
		if (date2.equals(date1))
			System.out.println("两个日期的年月日完全相同");
		else if (date2.after(date1))
			System.out.println("第二个日期大于第一个日期");
		else
			System.out.println("第二个日期小于第一个日期");
		long days = Math.abs(milliSecond1 - milliSecond2) / (1000 * 3600 * 24);
		System.out.println(date1 + "和" + date2 + "相隔" + days + "天");
	}
}
