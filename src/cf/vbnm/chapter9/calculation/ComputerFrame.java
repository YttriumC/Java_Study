package cf.vbnm.chapter9.calculation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerFrame extends JFrame {
	JMenuBar menuBar;
	JMenu choiceGrade;
	JMenuItem grade1, grade2;
	JTextField textOne, textTwo, textResult;
	JButton getProblem, giveAnswer;
	JLabel operatorLabel, message;
	Teacher teacherZhang;

	ComputerFrame() {
		teacherZhang = new Teacher();
		teacherZhang.setMaxInteger(20);
		setLayout(new FlowLayout());
		menuBar = new JMenuBar();
		choiceGrade = new JMenu("选择级别");
		grade1 = new JMenuItem("幼儿级别");
		grade2 = new JMenuItem("儿童级别");
		grade1.addActionListener((e) -> teacherZhang.setMaxInteger(10));
		grade2.addActionListener((e) -> teacherZhang.setMaxInteger(50));
		choiceGrade.add(grade1);
		choiceGrade.add(grade2);
		menuBar.add(choiceGrade);
		setJMenuBar(menuBar);
		textOne = new JTextField(5);
		textTwo = new JTextField(5);
		textResult = new JTextField(5);
		operatorLabel = new JLabel("+");
		operatorLabel.setFont(new Font("Arial", Font.BOLD, 20));
		message = new JLabel("你还没有回答呢");
		getProblem = new JButton("获取题目");
		giveAnswer = new JButton("确认答案");
		add(getProblem);
		add(textOne);
		add(operatorLabel);
		add(textTwo);
		add(new Label("="));
		add(textResult);
		add(giveAnswer);
		add(message);
		textResult.requestFocus();
		textOne.setEnabled(false);
		textTwo.setEnabled(false);
		getProblem.setActionCommand("getProblem");
		textResult.setActionCommand("answer");
		giveAnswer.setActionCommand("answer");
		teacherZhang.setJTextField(textOne, textTwo, textResult);
		teacherZhang.setJLabel(operatorLabel, message);
		getProblem.addActionListener(teacherZhang);
		giveAnswer.addActionListener(teacherZhang);
		textResult.addActionListener(teacherZhang);
		setVisible(true);
		validate();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
