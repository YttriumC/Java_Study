package cf.vbnm.chapter5.bank;

public class ConstructionBank extends Bank {
	double year;

	@Override
	public double computerInterest() {
		super.year = (int) year;
		double r = year - (int) year;
		int day = (int) (r * 1000);
		double yearInterest = super.computerInterest();
		double dayInterest = day * 0.0001 * savedMoney;
		interest = yearInterest + dayInterest;
		System.out.println("It is $" + interest + " earned that " + "$" + savedMoney +
				" saved in bank of dalian in " + super.year + " year(s) " +
				"and " + day + " day(s).");
		return interest;
	}
}
