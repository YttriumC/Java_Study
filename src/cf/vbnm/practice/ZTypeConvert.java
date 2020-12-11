package cf.vbnm.practice;

/*将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。

		比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：

		L   C   I   R
		E T O E S I I G
		E   D   H   N
		之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
		请你实现这个将字符串进行指定行数变换的函数：
		string convert(string s, int numRows);
		示例1:

		输入: s = "LEETCODEISHIRING", numRows = 3
		输出: "LCIRETOESIIGEDHN"
		示例2:

		输入: s = "LEETCODEISHIRING", numRows = 4
		输出:  "LDREOEIIECIHNTSG"
		解释:

		L     D     R
		E   O E   I I
		E C   I H   N
		T     S     G

*/
public class ZTypeConvert {
	public static void main(String[] args) {
		System.out.println(new ZTypeConvert().zTypeConvert("LEETCODEISHIRING", 3));
	}

	public String zTypeConvert(String s, int numRows) {
		if (numRows < 2)
			return s;
		StringBuilder stringBuilder = new StringBuilder(s.length());
		for (int i = 0; i < s.length(); i += (numRows * 2 - 2)) {
			stringBuilder.append(s.charAt(i));
		}
		for (int j = 1; j < numRows - 1; j++) {
			for (int i = j; i < s.length(); i += (numRows * 2 - 2)) {
				stringBuilder.append(s.charAt(i));
				if ((i + ((numRows - j - 1) << 1)) < s.length())
					stringBuilder.append(s.charAt(i + ((numRows - j - 1) << 1)));
			}

		}
		for (int i = numRows - 1; i < s.length(); i += (numRows * 2 - 2)) {
			stringBuilder.append(s.charAt(i));
		}
		return stringBuilder.toString();
	}
}
