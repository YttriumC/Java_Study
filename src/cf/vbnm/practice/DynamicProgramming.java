package cf.vbnm.practice;

public class DynamicProgramming {
	public static void main(String[] args) {
		int A = 10, B = 10;
		long timeMillis = System.currentTimeMillis();
		int[][] a = new int[A][B];
		for (int i = 1; i < A; i++) {
			a[i][0] = 1;
		}
		for (int i = 1; i < B; i++) {
			a[0][i] = 1;
		}
		for (int i = 1; i < A; i++) {
			for (int j = 1; j < B; j++) {
				a[i][j] = a[i - 1][j] + a[i][j - 1];
			}
		}
		System.out.println(System.currentTimeMillis() - timeMillis);
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < B; j++) {
				System.out.println((i + 1) + "个A和" + (j + 1) + "个B的排列总数共有:" + a[i][j] + "种");
			}
		}
		DynamicProgramming dynamicProgramming = new DynamicProgramming();
		timeMillis = System.currentTimeMillis();
		dynamicProgramming.func(A - 1, B - 1);
		System.out.println(System.currentTimeMillis() - timeMillis);
		System.out.println(dynamicProgramming.total);
	}
	int total;
	public void func(int A, int B) {
		if (A == 0 && B == 0) {
			total++;
			return;
		}
		if (A > 0)
			func(A - 1, B);
		if (B > 0)
			func(A, B - 1);
	}


}
