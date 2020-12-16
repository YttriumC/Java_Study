package cf.vbnm.chapter12.buyticket;

public class Seller {
	private int ticketPrice;
	private int CNY20s;
	private int CNY10s;
	private int CNY5s;

	public Seller(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public synchronized boolean sell(String buyer, int buyerCNY20s, int buyerCNY10s, int buyerCNY5s) {
		int buyerMoney = buyerCNY20s * 20 + buyerCNY10s * 10 + buyerCNY5s * 5;
		if (buyerMoney < ticketPrice) {
			System.out.println(buyer + "的钱不够买一张票");
			return false;
		}
		int change = buyerMoney - ticketPrice;
		int changeCNY20s = 0, changeCNY10s = 0, changeCNY5s = 0;
		for (int i = change; i > 0; ) {
			if (i >= 20) {
				changeCNY20s++;
				i -= 20;
			}
			if (i >= 10) {
				changeCNY10s++;
				i -= 10;
			}
			if (i >= 5) {
				changeCNY5s++;
				i -= 5;
			}
		}

		while (changeCNY20s > CNY20s + buyerCNY20s || changeCNY10s > CNY10s + buyerCNY10s
				|| changeCNY5s > CNY5s + buyerCNY5s) {
			try {
				System.err.println("零钱不够找" + buyer + ",等待下一位");
				wait();
			} catch (InterruptedException e) {

			}
		}
		CNY20s += buyerCNY20s;
		CNY10s += buyerCNY10s;
		CNY5s += buyerCNY5s;

		CNY20s -= changeCNY20s;
		CNY10s -= changeCNY10s;
		CNY5s -= changeCNY5s;
		System.out.println(buyer + "买了一张票");
		notifyAll();
		return true;
	}

	public void setCNY20s(int CNY20s) {
		this.CNY20s = CNY20s;
	}

	public void setCNY10s(int CNY10s) {
		this.CNY10s = CNY10s;
	}

	public void setCNY5s(int CNY5s) {
		this.CNY5s = CNY5s;
	}
}
