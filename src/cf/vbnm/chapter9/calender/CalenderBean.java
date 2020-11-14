package cf.vbnm.chapter9.calender;

import java.util.Calendar;

public class CalenderBean {
	int year, month;

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public String[] getCalender() {
		String a[] = new String[42];
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int day;
		switch (month) {
			case 1:
			case 2:
				day = 28;
				if (calendar.get(Calendar.YEAR) % 4 == 0 &&
						calendar.get(Calendar.YEAR) % 100 != 0 ||
						calendar.get(Calendar.YEAR) % 400 == 0)
					day = 29;
				break;
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day = 30;
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + month + 1);
		}
		for (int i = dayOfWeek, n = 1; i < dayOfWeek + day; i++) {
			a[i] = String.valueOf(n);
			n++;
		}
		return a;
	}
}
