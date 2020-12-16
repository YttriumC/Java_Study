package cf.vbnm.chapter12.buyticket;

public class BuyTicket {
	public static void main(String[] args) {
		Seller seller=new Seller(5);
		seller.setCNY5s(3);

		new Thread(()->{
			seller.sell("'张'",1,0,0);
		}).start();
		new Thread(()->{
			seller.sell("'李'",0,1,0);
		}).start();
		new Thread(()->{
			seller.sell("'赵'",0,1,0);
		}).start();
	}
}
