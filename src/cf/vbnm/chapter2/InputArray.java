package cf.vbnm.chapter2;

public class InputArray {
	public static void main(String[] args) {
		int[] a = {100, 200, 300};
		/*code 1*/
		System.out.println(a.length);
		/*code 1*/
		/*code 2*/
		System.out.println(a);
		/*code 2*/
		int b[][] = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}};
		/*code 3*/
		System.out.println(b.length);
		/*code 3*/
		/*after experiment*/
		for (int[] ints:b) {
			System.out.println(ints.length+"  "+ints);
		}
		/*after experiment*/
		/*code 4*/
		b[4] = a;
		/*code 4*/
		System.out.println(b[4][2]);
		/*after experiment*/
//		a[3]=200; //Index 3 out of bounds for length 3
		for (int[] ints:b) {
			System.out.println(ints.length+"  "+ints);
		}
		/*after experiment*/

	}
}
