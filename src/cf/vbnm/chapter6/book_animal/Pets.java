package cf.vbnm.chapter6.book_animal;

class Dog implements Animal {
	@Override
	public void cry() {
		System.out.println(getAnimalName()
				+ ":汪汪");
	}

	@Override
	public String getAnimalName() {
		return "dog";
	}
}

class Cat implements Animal {
	@Override
	public void cry() {
		System.out.println(getAnimalName()
				+ ":喵喵");
	}

	@Override
	public String getAnimalName() {
		return "cat";
	}
}