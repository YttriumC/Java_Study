package cf.vbnm.chapter9.book.average;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		JFrame mainWindow = new JFrame("计算");
		TextArea inputArea = new TextArea(5, 40);
		TextArea outputArea = new TextArea(2, 30);
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(inputArea);
		panel.add(outputArea);
		outputArea.setEditable(false);
		mainWindow.add(panel);
		mainWindow.setBounds(500, 300, 360, 200);
		mainWindow.setVisible(true);
		mainWindow.setMinimumSize(new Dimension(360,200));
		mainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		mainWindow.validate();
		inputArea.addTextListener(e -> {
			String inputAreaText = inputArea.getText();
			Scanner sc = new Scanner(inputAreaText);
			ArrayList<Double> doubles = new ArrayList<>();
			try {
				while (sc.hasNext()) {
					doubles.add(sc.nextDouble());
				}
			} catch (Exception ex) {
				outputArea.setText("请修改非数值项");
				return;
			}
			float sum = 0, aver;
			if (doubles.isEmpty()) {
				outputArea.setText("请输入数字");
				return;
			}
			for (double x : doubles) {
				sum += x;
			}
			aver = sum / doubles.size();
			outputArea.setText("和=" + sum + "\n平均数=" + aver);
			mainWindow.validate();
		});
	}
}
