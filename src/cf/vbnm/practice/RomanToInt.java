package cf.vbnm.practice;
/*
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。



示例 1:

输入: "III"
输出: 3
示例 2:

输入: "IV"
输出: 4
示例 3:

输入: "IX"
输出: 9
示例 4:

输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
示例 5:

输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.


提示：

题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
*/

public class RomanToInt {
	public static void main(String[] args) {
		System.out.println(new RomanToInt().romanToInt("CMXCIX"));
	}

	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.charAt(0) == 'M')
			return 1000 + romanToInt(s.substring(1));
		if (s.charAt(0) == 'D')
			return 500 + romanToInt(s.substring(1));
		if (s.charAt(0) == 'C')
			if (s.length() > 1 && s.charAt(1) == 'M')
				return 900 + romanToInt(s.substring(2));
			else if (s.length() > 1 && s.charAt(1) == 'D')
				return 400 + romanToInt(s.substring(2));
			else
				return 100 + romanToInt(s.substring(1));
		if (s.charAt(0) == 'L')
			return 50 + romanToInt(s.substring(1));
		if (s.charAt(0) == 'X')
			if (s.length() > 1 && s.charAt(1) == 'C')
				return 90 + romanToInt(s.substring(2));
			else if (s.length() > 1 && s.charAt(1) == 'L')
				return 40 + romanToInt(s.substring(2));
			else
				return 10 + romanToInt(s.substring(1));
		if (s.charAt(0) == 'V')
			return 5 + romanToInt(s.substring(1));
		if (s.charAt(0) == 'I')
			if (s.length() > 1 && s.charAt(1) == 'X')
				return 9 + romanToInt(s.substring(2));
			else if (s.length() > 1 && s.charAt(1) == 'V')
				return 4 + romanToInt(s.substring(2));
			else
				return 1 + romanToInt(s.substring(1));
		return 0;
	}
}
