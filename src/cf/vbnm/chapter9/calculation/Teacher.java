package cf.vbnm.chapter9.calculation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Teacher implements ActionListener {
	int numberOne, numberTwo;
	String operator = "";
	boolean isRight;
	Random random;
	int maxInteger;
	JTextField textOne, textTwo, textResult;
	JLabel operatorLabel, message;

	Teacher() {
		random = new Random();
	}

	public void setMaxInteger(int maxInteger) {
		this.maxInteger = maxInteger;
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if ("getProblem".equals(str)) {
			numberOne = random.nextInt(maxInteger) + 1;
			numberTwo = random.nextInt(maxInteger) + 1;
			double d = Math.random();
			if (d >= 0.5)
				operator = "+";
			else
				operator = "-";
			textOne.setText("" + numberOne);
			textTwo.setText("" + numberTwo);
			operatorLabel.setText(operator);
			message.setText("请回答");
			textResult.setText(null);
		} else if ("answer".equals(str)) {
			String answer = textResult.getText();
			try {
				int result = Integer.parseInt(answer);
				if ("+".equals(operator)) {
					if (result == numberOne + numberTwo) message.setText("correct");
					else message.setText("wrong");
				} else if ("-".equals(operator))
					if (result == numberOne - numberTwo)
						message.setText("correct");
					else
						message.setText("wrong");
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
				message.setText("请输入数字字符");
			}
		}
	}

	public void setJTextField(JTextField... t) {
		textOne = t[0];
		textTwo = t[1];
		textResult = t[2];
	}

	public void setJLabel(JLabel... label) {
		operatorLabel = label[0];
		message = label[1];
	}
}
