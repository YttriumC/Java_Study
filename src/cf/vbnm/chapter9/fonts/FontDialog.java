package cf.vbnm.chapter9.fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FontDialog extends JDialog implements ItemListener, ActionListener {
	FontFamilyNames fontFamilyNames;
	int fontSize = 38;
	String fontName;
	JComboBox fontNameList, fontSizeList;
	JLabel label;
	Font font;
	JButton yes, cancel;
	static int YES = 1, NO = 0;
	int state = -1;

	FontDialog(JFrame frame) {
		super(frame);
		setTitle("字体对话框");
		font = new Font("宋体", Font.PLAIN, 12);
		fontFamilyNames = new FontFamilyNames();
		setModal(true);
		yes = new JButton("Yes");
		cancel = new JButton("Cancel");
		yes.addActionListener(this);
		cancel.addActionListener(this);
		label = new JLabel("Hello,你好", JLabel.CENTER);
		fontNameList = new JComboBox();
		fontSizeList = new JComboBox();
		String[] name = fontFamilyNames.getFontNames();
		fontNameList.addItem("字体");
		for (int k = 0; k < name.length; k++)
			fontNameList.addItem(name[k]);
		fontSizeList.addItem("大小");
		for (int k = 0; k < 72; k++)
			fontSizeList.addItem(k);
		fontNameList.addItemListener(this);
		fontSizeList.addItemListener(this);
		JPanel pNorth = new JPanel();
		pNorth.add(fontNameList);
		pNorth.add(fontSizeList);
		add(pNorth, BorderLayout.NORTH);
		add(label, BorderLayout.CENTER);
		JPanel pSouth = new JPanel();
		pSouth.add(yes);
		pSouth.add(cancel);
		add(pSouth, BorderLayout.SOUTH);
		setBounds(100, 100, 280, 170);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		validate();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == fontNameList) {
			fontName = (String) fontNameList.getSelectedItem();
			font = new Font(fontName, Font.PLAIN, fontSize);
		} else if (e.getSource() == fontSizeList) {
			Integer m = (Integer) fontSizeList.getSelectedItem();
			fontSize = m.intValue();
			font = new Font(fontName, Font.PLAIN, fontSize);
		}
		label.setFont(font);
		label.repaint();
		validate();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == yes) {
			state = YES;
			setVisible(false);
		} else if (e.getSource() == cancel) {
			state = NO;
			setVisible(false);
		}
	}

	public int getState() {
		return state;
	}

	public Font getFont() {
		return font;
	}
}
