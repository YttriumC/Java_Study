package cf.vbnm.chapter5.people;

public class AmericanPeople extends People {
	@Override
	/*2*/ public void speakHello() {
		System.out.println("How do you do");
	}

	@Override
	/*3*/ public void averageHeight() {
		height=176;
		System.out.println("American's average height:"+height+"cm");
	}

	@Override
	public void averageWeight() {
		weight=75;
		System.out.println("American's average weight:"+weight+"Kg");
	}

	public void americanBoxing() {
		System.out.println("直拳,勾拳,组合拳");
	}
}
