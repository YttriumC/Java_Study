package cf.vbnm.demo;

import java.util.Scanner;

public class CellPhone {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str = sc.next();
		boolean matches = str.matches("1[1-9]{10}|0[1-9][0-9]{10}");

	}
}
