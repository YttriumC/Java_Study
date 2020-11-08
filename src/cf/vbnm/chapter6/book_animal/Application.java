package cf.vbnm.chapter6.book_animal;

public class Application {
	public static void main(String[] args) {
		Simulator simulator = new Simulator();
		simulator.playSound(new Dog());
		simulator.playSound(new Cat());
	}
}
