package cf.vbnm.demo.gui;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame {
	public void init(){
		JFrame frame=new JFrame("Calculator");
		frame.setSize(300,450);
		frame.setVisible(true);
		JPanel calc=new JPanel();
		calc.setLayout(new BorderLayout());
		JPanel display=new JPanel();
		JPanel buttons=new JPanel();
		display.setLayout(new BorderLayout());
		buttons.setLayout(new GridLayout(4,5));
		calc.add(display,BorderLayout.NORTH);
		calc.add(buttons, BorderLayout.SOUTH);
		JTextArea operate =new JTextArea(3,15);
	}
}
