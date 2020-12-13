package cf.vbnm.chapter10.book;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AveragePrice {
	public static void main(String[] args) {
		try {
			double totalPrice = 0;
			int totalGoods = 0;
			Scanner sc = new Scanner(new FileReader("out\\averagePrice.txt"));
			sc.useDelimiter("[^0-9\\.]+");
			while (sc.hasNext()) {
				try {
					totalPrice += sc.nextDouble();
					totalGoods++;
				} catch (Exception e) {
					sc.next();
				}
			}
			System.out.printf("平均价格:%.2f\n",totalPrice/totalGoods);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
