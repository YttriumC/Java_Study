package cf.vbnm.practice;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"fast", "fastly", "faster", "fastest"}));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		int minStrLen = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			minStrLen = Math.min(minStrLen, strs[i].length());
		}
		for (int i = 0; i < minStrLen; i++) {
			char content = strs[0].charAt(i);
			for (String str : strs) {
				if (str.charAt(i) != content)
					return strs[0].substring(0, i);
			}
		}
		return strs[0].substring(0, minStrLen);
	}
}
