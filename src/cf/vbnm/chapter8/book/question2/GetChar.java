package cf.vbnm.chapter8.book.question2;

import java.util.Scanner;

public class GetChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一句话:");
		String input = sc.next();
		System.out.println(input + "的第一个字符是:" + input.charAt(0) +
				";最后一个字符是:" + input.charAt(input.length() - 1) + ".");

	}
}
