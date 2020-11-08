package cf.vbnm.acm;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
		System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
	}

	//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
	public String longestPalindrome(String s) {
		int max = 1, index = 0;
		String rtn;
		for (int i = 1; i < s.length() - max; i++) {
			for (int j = 0; j < i; j++) {

			}
		}
		rtn = s.substring(Math.min(index - max, 0), Math.min(index + max + 1, s.length()));
		return rtn;
	}
}
