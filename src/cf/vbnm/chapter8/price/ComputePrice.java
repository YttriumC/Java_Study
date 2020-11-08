package cf.vbnm.chapter8.price;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputePrice {
	public static void main(String[] args) {
		String menu = "北极烤鸭:189元 西芹炒肉:12.9元 酸菜鱼:69元 铁板牛柳:32元";
		Scanner sc = new Scanner(menu);
		String regex = "[^0-9.]+";
		sc.useDelimiter(regex);
		double sum = 0;
		while (sc.hasNext()) {
			try {
				double price = sc.nextDouble();
				sum += price;
				System.out.println(price);
			} catch (InputMismatchException e) {
				sc.next();
			}

		}
		System.out.println("菜单总价格:" + sum + "元");
		regex="[^(http//|www)\56?\\w+\56{1}\\w+\56{1}\\p{Alpha}]+";
		sc=new Scanner(
				"中央电视台:www.cctv.com 清华大学:www.tsinghua.edu.cn 音乐网站:www.violin.com");
		sc.useDelimiter(regex);
		while (sc.hasNext())
			System.out.println(sc.next());
	}
}
