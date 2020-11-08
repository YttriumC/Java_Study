package cf.vbnm.chapter5.book_animal;

public class Application {
	public static void main(String[] args) {
		Simulator simulator=new Simulator();
		simulator.playSound(new Cat());
		simulator.playSound(new Dog());
	}
}
