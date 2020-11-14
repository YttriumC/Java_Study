package cf.vbnm.chapter9.calender;

public class CalenderMainClass {
	public static void main(String[] args) {
		CalenderFrame frame = new CalenderFrame(2020,11);
		frame.setBounds(100, 100, 360, 360);
		frame.setVisible(true);
	}
}
