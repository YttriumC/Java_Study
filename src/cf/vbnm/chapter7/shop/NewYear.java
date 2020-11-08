package cf.vbnm.chapter7.shop;

class MobileShop {


	private int mobileAmount;
	InnerPurchaseMoney purchaseMoney1;
	InnerPurchaseMoney purchaseMoney2;
	public void setMobileAmount(int mobileAmount) {
		this.mobileAmount = mobileAmount;
	}
	MobileShop() {
		purchaseMoney1 = new InnerPurchaseMoney(20000);
		purchaseMoney2 = new InnerPurchaseMoney(10000);
	}

	public int getMobileAmount() {
		return mobileAmount;
	}

	class InnerPurchaseMoney {
		int moneyValue;

		InnerPurchaseMoney(int m) {
			moneyValue = m;
		}

		void buyMobile() {
			if (moneyValue >= 20000) {
				mobileAmount -= 6;
				System.out.println("用价值" + moneyValue + "的内部购买券买了6部手机");
			} else if (moneyValue < 20000 && moneyValue >= 10000) {
				mobileAmount -= 3;
				System.out.println("用价值" + moneyValue + "的内部购买券买了3部手机");
			}
		}
	}
}

public class NewYear {
	public static void main(String[] args) {
		MobileShop shop =new MobileShop();
		shop.setMobileAmount(30);
		System.out.println("手机专卖店目前有"+shop.getMobileAmount()+"部手机");
		shop.purchaseMoney1.buyMobile();
		shop.purchaseMoney2.buyMobile();
		System.out.println("手机专卖店目前有"+shop.getMobileAmount()+"部手机");
	}
}
