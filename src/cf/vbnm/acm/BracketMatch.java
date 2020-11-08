package cf.vbnm.acm;

import java.util.Scanner;
import java.util.Stack;

public class BracketMatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(input.charAt(i));
				continue;
			}
			if (stack.peek() == input.charAt(i))
				stack.pop();
			else
				stack.push(input.charAt(i));
		}
		System.out.println((stack.isEmpty()) ? "Yes" : "No");
	}
}
