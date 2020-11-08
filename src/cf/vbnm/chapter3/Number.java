package cf.vbnm.chapter3;

import java.util.Scanner;

public class Number {
	/*after experiment
	2332:
	2332 is a thousand number
	2332 is a palindrome
	654321:
	654321 is not between 1 and 99999
	33321:
	33321 is a ten thousand number
	33321 is not a palindrome
	after experiment*/
	public static void main(String[] args) {
		int number = 0, d5, d4, d3, d2, d1;
		Scanner reader = new Scanner(System.in);
		System.out.println("input a number between 1 and 99999");
		number = reader.nextInt();
		if (/*1*/number > 0 && number < 100000) {
			/*2-4*/
			d5 = number / 10000;
			d4 = (number / 1000) % 10;
			d3 = (number / 100) % 10;
			d2 = number % 100 / 10;
			d1 = number % 10;
			if (/*5*/0 != d5) {
				System.out.println(number + " is a ten thousand number");
				if (/*6*/d5 == d1 && d4 == d2) {
					System.out.println(number + " is a palindrome number");
				} else {
					System.out.println(number + " is not a palindrome");
				}
			} else if (/*7*/ 0 != d4) {
				System.out.println(number + " is a thousand number");
				if (/*8*/d4 == d1 && d3 == d2)
					System.out.println(number + " is a palindrome");
				else
					System.out.println(number + " is not a palindrome");
			} else if (/*9*/ 0 != d3) {
				System.out.println(number + " is a hundred number");
				if (/*10*/d1 == d3)
					System.out.println(number + " is a palindrome");
				else
					System.out.println(number + " is not a palindrome");
			} else if (d2 != 0) {
				System.out.println(number + " is a ten number");
				if (d1 == d2)
					System.out.println(number + " is a palindrome");
				else
					System.out.println(number + " is not a palindrome");

			} else {
				System.out.println(number + " is a single number");
				System.out.println(number + " is a palindrome");
			}
		} else
			System.out.println(number + " is not between 1 and 99999");
	}
}
