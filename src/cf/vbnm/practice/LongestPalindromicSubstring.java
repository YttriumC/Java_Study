package cf.vbnm.practice;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {

		System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaa"));
	}

	/*
	 *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
	 *
	 * */
	public String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		int subStringLen = 0, indexL = 0, indexR = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			int jl, jr, subStrLen = 1;
			for (jl = i - 1, jr = i + 1; jl >= 0 && jr < s.length(); jl--, jr++) {
				if (s.charAt(jl) == s.charAt(jr)) {
					subStrLen += 2;
				} else {
					break;
				}
			}
			if (subStrLen > subStringLen) {
				subStringLen = subStrLen;
				indexL = jl + 1;
				indexR = jr - 1;
			}
			if (s.charAt(i) == s.charAt(i + 1)) {
				subStrLen = 2;
				for (jl = i - 1, jr = i + 2; jl >= 0 && jr < s.length(); jl--, jr++) {
					if (s.charAt(jl) == s.charAt(jr)) {
						subStrLen += 2;
					} else {
						break;
					}
				}
				if (subStrLen > subStringLen) {
					subStringLen = subStrLen;
					indexL = jl + 1;
					indexR = jr - 1;
				}
			}
		}
		return s.substring(indexL, indexR + 1);
	}
}
