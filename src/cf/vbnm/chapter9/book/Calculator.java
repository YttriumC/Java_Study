package cf.vbnm.chapter9.book;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
	private Computer computer;
	private JFrame mainWindow;
	private JTextField number1;
	private JTextField number2;
	private JTextField result;
	private JPanel panel;
	private JPanel operators;
	private JButton add, subtract, multiply, divide;
	private static final Font globalFont = new Font("宋体", Font.BOLD, 25);

	public void getText() {
		computer.setNumber1(new BigDecimal(number1.getText(), new MathContext(15, RoundingMode.HALF_UP)));
		computer.setNumber2(new BigDecimal(number2.getText(), new MathContext(15, RoundingMode.HALF_UP)));
	}

	public void actionReg() {
		computer = new Computer();
		add.addActionListener(e -> {
			getText();
			try {
				BigDecimal result = computer.compute(Operate.Add);
				this.result.setText(result.toString());
			} catch (ComputerException computerException) {
				this.result.setText("NaN");
			}
		});
		subtract.addActionListener(e -> {
			getText();
			try {
				BigDecimal result = computer.compute(Operate.Subtract);
				this.result.setText(result.toString());
			} catch (ComputerException computerException) {
				this.result.setText("NaN");
			}
		});
		multiply.addActionListener(e -> {
			getText();
			try {
				BigDecimal result = computer.compute(Operate.Multiply);
				this.result.setText(result.toString());
			} catch (ComputerException computerException) {
				this.result.setText("NaN");
			}
		});
		divide.addActionListener(e -> {
			getText();
			try {
				BigDecimal result = computer.compute(Operate.Divide);
				this.result.setText(result.toString());
			} catch (ComputerException computerException) {
				this.result.setText("NaN");
			}
		});
	}

	public void init() {
		mainWindow = new JFrame("计算器");
		mainWindow.setSize(260, 200);
		mainWindow.setLocation(500, 400);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		number1 = new JTextField(15);
		number1.setFont(globalFont);
		number1.setHorizontalAlignment(JTextField.RIGHT);
		number2 = new JTextField(15);
		number2.setFont(globalFont);
		number2.setHorizontalAlignment(JTextField.RIGHT);
		result = new JTextField(15);
		result.setFont(globalFont);
		result.setHorizontalAlignment(JTextField.RIGHT);
		panel = new JPanel(new GridLayout(4, 1));
		operators = new JPanel(new GridLayout(1, 4));
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("×");
		divide = new JButton("÷");
		mainWindow.add(panel);
		panel.add(number1);
		panel.add(operators);
		panel.add(number2);
		panel.add(result);
		add.setFont(globalFont);
		subtract.setFont(globalFont);
		multiply.setFont(globalFont);
		divide.setFont(globalFont);
		operators.add(add);
		operators.add(subtract);
		operators.add(multiply);
		operators.add(divide);
		result.setEnabled(false);
		mainWindow.setVisible(true);
		mainWindow.validate();
		actionReg();
	}


	public static void main(String[] args) {
		new Calculator().init();

	}
}



