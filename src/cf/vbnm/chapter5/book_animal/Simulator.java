package cf.vbnm.chapter5.book_animal;

public class Simulator {
	void playSound(Animal animal) {
		System.out.print(animal.getAnimalName() + ":");
		animal.cry();
	}
}
