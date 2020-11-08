package cf.vbnm.demo;

import java.util.Scanner;

public class Rand {
	static boolean flag;
	static int i = 0;

	public static void main(String[] args) {
		flag = true;
		String[] names = {"邓力铨", "田佳", "张浙"};
		Thread t= new Thread(() -> {
			while (flag) i++;
		});
		t.start();
		Scanner sc = new Scanner(System.in);
		sc.next();
		t.stop();
		flag = false;
		System.out.println(names[Math.abs(i % 3)]);
	}
}
