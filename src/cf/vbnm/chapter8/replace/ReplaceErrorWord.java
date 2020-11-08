package cf.vbnm.chapter8.replace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceErrorWord {
	public static void main(String[] args) {
		String str = "忘记密码,不要惊慌失错,请登陆sin.lu7fer.tk或登陆la.vbnm.cf";
		Pattern pattern;
		Matcher matcher;
		String regex = "登陆";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(str);
		while (matcher.find()) {
			String s = matcher.group();
			System.out.println(matcher.start() + "位置出现");
			System.out.println(s);
		}
		System.out.println("将\"登陆\"替换为\"登录\"的字符串:");
		String result = matcher.replaceAll("登录");
		System.out.println(result);
		pattern = Pattern.compile("惊慌失错");
		matcher = pattern.matcher(result);
		System.out.println("将\"惊慌失错\"替换为\"惊慌失措\"的字符串:");
		result = matcher.replaceAll("惊慌失措");
		System.out.println(result);
	}
}
