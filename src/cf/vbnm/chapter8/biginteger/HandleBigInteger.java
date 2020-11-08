package cf.vbnm.chapter8.biginteger;

import java.math.BigInteger;

public class HandleBigInteger {
	public static void main(String[] args) {
		BigInteger n1 = new BigInteger("987654321987654321987654321"),
				n2 = new BigInteger("123456789123456789123456789"),
				result = null;
		result = n1.add(n2);
		System.out.println("n1 plus n2: " + result);
		result = n1.subtract(n2);
		System.out.println("n1 subtract n2: " + result);
		result = n1.multiply(n2);
		System.out.println("n1 multiply n2: " + result);
		result = n1.divide(n2);
		System.out.println("n1 divide n2: " + result);
		BigInteger m = new BigInteger("1968957"),
				COUNT = new BigInteger("0"),
				ONE = new BigInteger("1"),
				TWO = new BigInteger("2");
		System.out.println(m + "的因子有:");
		for (BigInteger i = TWO; i.compareTo(m) < 0; i = i.add(ONE))
			if ((n1.remainder(i).compareTo(BigInteger.ZERO)) == 0) {
				COUNT = COUNT.add(ONE);
				System.out.print("   " + i);
			}
		System.out.println();
		System.out.println(m + "一共有" + COUNT + "个因子");
		System.out.println("" + fac(new BigInteger("123")));
	}

	static public BigInteger fac(BigInteger fac) {
		BigInteger rtn = BigInteger.ONE;
		for (BigInteger i = BigInteger.ONE; fac.compareTo(i) >= 0; i = i.add(BigInteger.ONE)) {
			rtn = rtn.multiply(i);
		}
		return rtn;
	}
}
