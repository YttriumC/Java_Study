package cf.vbnm.chapter4.vehicle;

public class User {
	public static void main(String[] args) {
		Vehicle car1,car2;
		/*7*/car1=new Vehicle();
		/*8*/car2=new Vehicle();
		car1.setPower(128);
		car2.setPower(76);
		System.out.println("The power of car1 is "+car1.getPower());
		System.out.println("The power of car2 is "+car2.getPower());
		/*9*/car1.speedUp(80);
		/*10*/car2.speedUp(80);
		System.out.println("The speed of car1 now is "+car1.getSpeed());
		System.out.println("The speed of car2 now is "+car2.getSpeed());
		car1.speedDown(10);
		car2.speedDown(20);
		System.out.println("The speed of car1 now is "+car1.getSpeed());
		System.out.println("The speed of car2 now is "+car2.getSpeed());
	}
}
