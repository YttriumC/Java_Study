package cf.vbnm.chapter8.book.question5;

import java.util.Scanner;

public class ExtractNumbers {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入一个字符串,提取数字:");
		System.out.println(sc.next().replaceAll("\\D+",""));
	}
}
