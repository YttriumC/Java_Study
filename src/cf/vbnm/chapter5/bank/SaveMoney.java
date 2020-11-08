package cf.vbnm.chapter5.bank;

public class SaveMoney {
	public static void main(String[] args) {
		int amount = 8000;
		ConstructionBank bank1 = new ConstructionBank();
		bank1.savedMoney = amount;
		bank1.year = 8.236;
		bank1.setInterestRate(0.035);
		double interest1 = bank1.computerInterest();
		BankOfDalian bank2 = new BankOfDalian();
		bank2.savedMoney = amount;
		bank2.year = 8.236;
		bank2.setInterestRate(0.035);
		double interest2 = bank2.computerInterest();
		System.out.println("Two banks's earn difference is $" + Math.abs(interest2 - interest1));

		/*after experiment*/
		CommercialBank commercialBank=new CommercialBank();
		commercialBank.year=8.236;
		commercialBank.savedMoney=8000;
		commercialBank.setInterestRate(0.035);
		commercialBank.computerInterest();
		/*after experiment*/
	}
}
