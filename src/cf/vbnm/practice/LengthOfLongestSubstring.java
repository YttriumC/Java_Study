package cf.vbnm.practice;

public class LengthOfLongestSubstring {
	public static void main(String[] args) {

		System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(
				"ab"));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || "".equals(s))
			return 0;
		int index1 = 0, index2 , max = 1;
		for (index2 = 1; index2 < s.length(); index2++) {
			for (int j = index1; j < index2; j++) {
				if (s.charAt(j) == s.charAt(index2)) {
					index1 = j + 1;
					break;
				}
				max = Math.max(index2 - index1, max);
			}
		}
		max = Math.max(max, index2 - index1 );
		return max;
	}


}
