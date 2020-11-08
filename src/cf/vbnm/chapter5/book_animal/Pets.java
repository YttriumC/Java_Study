package cf.vbnm.chapter5.book_animal;

class Dog extends Animal{
	@Override
	void cry() {
		System.out.println("wang wang");
	}

	@Override
	String getAnimalName() {
		return "dog";
	}
}

class Cat extends Animal{
	@Override
	void cry() {
		System.out.println( "miao miao");
	}

	@Override
	String getAnimalName() {
		return "cat";
	}
}