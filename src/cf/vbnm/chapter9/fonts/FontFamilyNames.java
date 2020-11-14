package cf.vbnm.chapter9.fonts;

import java.awt.*;

public class FontFamilyNames {
	String allFontNames[];
	public String[] getFontNames(){
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		allFontNames=ge.getAvailableFontFamilyNames();
		return allFontNames;
	}
}
