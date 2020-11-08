package cf.vbnm.chapter5.bank;

public class BankOfDalian extends Bank {
	double year;

	public double computerInterest() {
		super.year = (int) year;
		double r = year - (int) year;
		int day = (int) (r * 1000);
		double yearInterest = super.computerInterest();
		double dayInterest = day * 0.00012 * savedMoney;
		interest = yearInterest + dayInterest;
		System.out.println("It is $" + interest + " earned that " + "$" +
				savedMoney + " saved in construction bank in " + super.year + " year(s) " +
				"and " + day + " day(s).");
		return interest;
	}
}
