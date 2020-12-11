package cf.vbnm.practice;

public class IntegerReverse {
	public static void main(String[] args) {
		System.out.println(new IntegerReverse().reverse(-2147483648));
	}
/*  给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

	示例1:

	输入: 123
	输出: 321
	示例 2:

	输入: -123
	输出: -321
	示例 3:

	输入: 120
	输出: 21
	注意:

	假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−2^31, (2^31)−1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
*/

	public int reverse(int x) {
		boolean isPositive = x >= 0;
		StringBuilder stringBuilder = new StringBuilder(32);
		stringBuilder.append(x).reverse();
		if (!isPositive)
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		long reversed = Long.parseLong(stringBuilder.toString());
		if (reversed > (long) 0x7fffffff || reversed < (long) 0x80000000)
			return 0;
		return (int) ((isPositive) ? reversed : -reversed);
	}
}
