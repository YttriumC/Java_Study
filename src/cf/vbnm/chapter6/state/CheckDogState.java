package cf.vbnm.chapter6.state;

interface DogState {
	public void showState();
}

class SoftlyState implements DogState {
	public void showState() {
		System.out.println("听主人命令");
	}
}

class MeetEnemyState implements DogState {
	@Override
	public void showState() {
		System.out.println("attack");
	}
}

class MeetFriendState implements DogState {
	@Override
	public void showState() {
		System.out.println("swing tail");
	}
}

class MeetAnotherDog implements DogState {
	@Override
	public void showState() {
		System.out.println("fall in love/play");
	}
}

class Dog {
	DogState state;

	public void show() {
		state.showState();
	}

	public void setState(DogState state) {
		this.state = state;
	}
}

public class CheckDogState {
	public static void main(String[] args) {
		Dog yellowDog = new Dog();
		System.out.print("在主人面前:");
		yellowDog.setState(new SoftlyState());
		yellowDog.show();
		System.out.print("受到攻击:");
		yellowDog.setState(new MeetEnemyState());
		yellowDog.show();
		System.out.print("狗遇到朋友:");
		yellowDog.setState(new MeetFriendState());
		yellowDog.show();
		System.out.print("狗遇到同伴:");
		yellowDog.setState(new MeetAnotherDog());
		yellowDog.show();

	}
}
