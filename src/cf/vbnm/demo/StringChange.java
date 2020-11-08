package cf.vbnm.demo;
import java.util.Scanner;
public class StringChange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner strSc = new Scanner(sc.nextLine());
		String out = "";
		while (strSc.hasNext()) {
			String in = strSc.next();
			out += in.replaceFirst("" + in.charAt(0), "" + Character.toUpperCase(in.charAt(0))) + " ";
		}
		System.out.println(out.substring(0, out.length() - 1));
	}
}
/*	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String in = sc.nextLine();//读取一行
			String[] split = in.split("\\s+"); //以一个或多个空白字符分割字符串
			String out = "";
			for (int i = 0; i < split.length; i++) {//对每个单词进行处理
				if (split[i].length() > 1) {//单词长度大于1
					out += split[i].substring(0, 1).toUpperCase();//提取第一个字母并大写
					out += split[i].substring(1);//提取其余字母
				} else {//单词长度等于一
					out += split[i].toUpperCase();//直接转为大写
				}
				if (i < split.length - 1)
					out += " ";//在每个单词后添加空格
			}
			System.out.println(out);//输出
			other();
		}
	*/