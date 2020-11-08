package cf.vbnm.chapter8.book.question1;

import java.util.Scanner;

public class Methods {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入一个字符串,转成大写(英文):");
		System.out.println(sc.next().toUpperCase());
		System.out.println("输入一个字符串,转成小写(英文):");
		System.out.println(sc.next().toLowerCase());
		System.out.println("输入两一个字符串,拼接在一起:");
		System.out.println(sc.next().concat(sc.next()));
	}
}
