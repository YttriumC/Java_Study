package cf.vbnm.chapter2;

import java.util.Arrays;

public class CopyArray {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 500, 600, 700, 800};
		int[] b, c, d;
		System.out.println(Arrays.toString(a));
		b = Arrays.copyOf(a, a.length);
		System.out.println(Arrays.toString(b));
		/*code 1*/
		c = Arrays.copyOf(a, 4);
		/*code 1*/
		System.out.println(/*code 2*/ Arrays.toString(c)/*code 2*/);
		d =/*code 3*/ Arrays.copyOfRange(a, a.length - 5, a.length);/*code 3*/
		System.out.println(Arrays.toString(d));
		/*code 4*/
		c[c.length - 1] = -200;
		/*code 4*/
		System.out.println(Arrays.toString(a));
		/*after experiment*/
		int[] tom = Arrays.copyOf(c, 6);
		System.out.println(Arrays.toString(tom));
//		int[] jerry = Arrays.copyOf(d, 1, 8);
//		System.out.println(Arrays.toString(jerry));有问题

		/*after experiment*/

	}
}
