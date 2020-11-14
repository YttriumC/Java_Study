package cf.vbnm.chapter9.calender;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalenderFrame extends JFrame implements ActionListener {
	JLabel labelDay[] = new JLabel[42];
	JButton titleName[] = new JButton[7];
	String name[] = {"日", "一", "二", "三", "四", "五", "六"};
	JButton nextMonth, previousMonth;
	CalenderBean calenderBean;
	JLabel showMessage = new JLabel("", JLabel.CENTER);
	static int year, month;

	public CalenderFrame(int year, int month) {
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(7, 7));
		for (int i = 0; i < 7; i++) {
			titleName[i] = new JButton(name[i]);
			titleName[i].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			pCenter.add(titleName[i]);
		}
		for (int i = 0; i < 42; i++) {
			labelDay[i] = new JLabel("", JLabel.CENTER);
			labelDay[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
			pCenter.add(labelDay[i]);
		}
		calenderBean = new CalenderBean();
		nextMonth = new JButton("下月");
		previousMonth = new JButton("上月");
		nextMonth.addActionListener(this);
		previousMonth.addActionListener(this);
		JPanel pNorth = new JPanel(), pSouth = new JPanel();
		pNorth.add(previousMonth);
		pNorth.add(nextMonth);
		pSouth.add(showMessage);
		add(pCenter, BorderLayout.CENTER);
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		setYearAndMonth(year, month);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void setYearAndMonth(int year, int month) {
		calenderBean.setYear(year);
		calenderBean.setMonth(month);
		CalenderFrame.year = year;
		CalenderFrame.month = month;
		String day[] = calenderBean.getCalender();
		for (int i = 0; i < 42; i++)
			labelDay[i].setText(day[i]);
		showMessage.setText("日历:" + calenderBean.getYear() + "年" + calenderBean.getMonth() + "月");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextMonth) {
			month++;
			if (month > 12) {
				month = 1;
				calenderBean.setYear(++year);
			}
			calenderBean.setMonth(month);
			String day[] = calenderBean.getCalender();
			for (int i = 0; i < 42; i++) {
				labelDay[i].setText(day[i]);
			}
		} else if (e.getSource() == previousMonth) {
			month--;
			if (month < 1) {
				month = 12;
				calenderBean.setYear(--year);
			}
			calenderBean.setMonth(month);
			String day[] = calenderBean.getCalender();
			for (int i = 0; i < 42; i++) {
				labelDay[i].setText(day[i]);
			}
		}
		showMessage.setText("日历:" + calenderBean.getYear() + "年" + calenderBean.getMonth() + "月");
	}
}
