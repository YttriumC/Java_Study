package cf.vbnm.chapter6.book_animal;

class Dog implements Animal{
	@Override
	public void cry() {
		System.out.println(getAnimalName()+":wang wang");
	}

	@Override
	public String getAnimalName() {
		return "dog";
	}
}

class Cat implements Animal{
	@Override
	public void cry() {
		System.out.println(getAnimalName()+":miao miao");
	}

	@Override
	public String getAnimalName() {
		return "cat";
	}
}