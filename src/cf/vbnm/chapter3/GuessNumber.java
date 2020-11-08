package cf.vbnm.chapter3;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Random random = new Random();
		System.out.println("Give you a integer number between 1 and 100, let's guess!!");
		int realNumber = random.nextInt(100) + 1;
		int yourGuess;
		System.out.println("input your guess:");
		yourGuess = reader.nextInt();
		while (/*1*/realNumber != yourGuess) {
			if (/*2*/yourGuess > realNumber) {
				System.out.println("too large, please try again!");
				yourGuess = reader.nextInt();
			} else if (/*3*/yourGuess < realNumber) {
				System.out.println("too small, please try again!");
				yourGuess= reader.nextInt();
			}
		}
		System.out.println("brilliant! That's it!");
	}
}
