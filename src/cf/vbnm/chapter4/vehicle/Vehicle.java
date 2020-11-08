package cf.vbnm.chapter4.vehicle;

public class Vehicle {
	/*1*/ double speed;
	/*2*/ int power;

	void speedUp(int s) {
		/*after experiment*/
		this.speed = Math.min(this.speed + s, 200);
		/*after experiment*/
		/*3*/
//		this.speed += s;
		/*3*/
	}

	void speedDown(int d) {
		/*after experiment*/
		this.speed = Math.max(this.speed + d, 0);
		/*after experiment*/
		/*4*/
//		this.speed -= d;
		/*4*/
	}

	void setPower(int power) {
		/*5*/
		this.power = power;
	}

	int getPower() {
		/*6*/
		return this.power;
	}

	double getSpeed() {
		return this.speed;
	}

	/* after experiment*/
	void brake() {
		this.speed = 0;
	}
	/* after experiment*/
}
