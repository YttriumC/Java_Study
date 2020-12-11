package cf.vbnm.chapter9.book.compute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Compute {
	public static final Font GLOBAL_FONT = new Font("宋体", Font.BOLD, 25);

	public static void main(String[] args) {
		JFrame mainWindow = new JFrame("计算");
		JButton add = new JButton("加"), subtract = new JButton("减"),
				multiply = new JButton("乘"), divide = new JButton("除");
		JTextField number1 = new JTextField(20);
		JTextField number2 = new JTextField(20);
		JTextField result = new JTextField(20);
		number1.setHorizontalAlignment(JTextField.RIGHT);
		number2.setHorizontalAlignment(JTextField.RIGHT);
		result.setHorizontalAlignment(JTextField.RIGHT);
		add.setFont(GLOBAL_FONT);
		subtract.setFont(GLOBAL_FONT);
		multiply.setFont(GLOBAL_FONT);
		divide.setFont(GLOBAL_FONT);
		number1.setFont(GLOBAL_FONT);
		number2.setFont(GLOBAL_FONT);
		result.setFont(GLOBAL_FONT);
		result.setEditable(false);
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(number1);
		panel.add(add);
		panel.add(subtract);
		panel.add(multiply);
		panel.add(divide);
		panel.add(number2);
		panel.add(result);
		mainWindow.add(panel);
		mainWindow.setBounds(300, 500, 330, 230);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		mainWindow.setVisible(true);
		mainWindow.validate();
		Computer computer = new Computer();
		/*注册监听事件*/
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					computer.setNumber1(new BigDecimal(number1.getText(),Computer.GLOBAL_MATH_PRECISION));
					computer.setNumber2(new BigDecimal(number2.getText(),Computer.GLOBAL_MATH_PRECISION));
					if (e.getSource() == add)
						result.setText(computer.compute(OperateMethod.ADD).toString());
					else if (e.getSource() == subtract)
						result.setText(computer.compute(OperateMethod.SUBTRACT).toString());
					else if (e.getSource() == multiply)
						result.setText(computer.compute(OperateMethod.MULTIPLY).toString());
					else if (e.getSource() == divide)
						result.setText(computer.compute(OperateMethod.DIVIDE).toPlainString());
					else
						throw new Exception();
				} catch (NumberFormatException ex) {
					result.setText("请输入正确的数字");
				} catch (Computer.ComputerException ex) {
					result.setText("NaN");
				} catch (Exception ex) {
					result.setText("UnknownError");
				}
			}
		};
		add.addActionListener(actionListener);
		subtract.addActionListener(actionListener);
		multiply.addActionListener(actionListener);
		divide.addActionListener(actionListener);
	}

}

enum OperateMethod {
	ADD, SUBTRACT, MULTIPLY, DIVIDE;
}


class Computer {
	public static final MathContext GLOBAL_MATH_PRECISION = new MathContext(15, RoundingMode.HALF_UP);
	private BigDecimal number1, number2;

	protected class ComputerException extends Exception {

	}

	public void setNumber1(BigDecimal number1) {
		this.number1 = number1;
	}

	public void setNumber2(BigDecimal number2) {
		this.number2 = number2;
	}

	public BigDecimal compute(OperateMethod operate) throws Computer.ComputerException {
		if (operate == OperateMethod.ADD)
			return number1.add(number2, GLOBAL_MATH_PRECISION);
		if (operate == OperateMethod.SUBTRACT)
			return number1.subtract(number2, GLOBAL_MATH_PRECISION);
		if (operate == OperateMethod.MULTIPLY)
			return number1.multiply(number2, GLOBAL_MATH_PRECISION);
		if (operate == OperateMethod.DIVIDE) {
			if (number2.equals(BigDecimal.ZERO))
				throw this.new ComputerException();
			return number1.divide(number2, GLOBAL_MATH_PRECISION);
		}
		return null;
	}

}