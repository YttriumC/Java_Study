package cf.vbnm.chapter5.bank;

public class Bank {
	int savedMoney;
	int year;
	double interest;
	double interestRate = 0.29;

	public double computerInterest() {
		interest = year * interestRate * savedMoney;
		return interest;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
