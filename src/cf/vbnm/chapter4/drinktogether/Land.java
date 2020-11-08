package cf.vbnm.chapter4.drinktogether;

import jdk.dynalink.beans.StaticClass;

public class Land {
	@SuppressWarnings("Static")
	public static void main(String[] args) {
		/*1*/
		Village.setWaterAmount(200);
		int leftWater =/*2*/Village.waterAmount;
		System.out.println("The well has " + leftWater + "L water;");
		Village zhaoZhuang, maJiaHeZhi;
		zhaoZhuang = new Village("赵庄");
		maJiaHeZhi = new Village("马家河子");
		zhaoZhuang.setPeopleNumber(80);
		maJiaHeZhi.setPeopleNumber(120);
		/*3*/zhaoZhuang.drinkWater(50);
		leftWater =/*4*/maJiaHeZhi.lookWaterAmount();
		String name = maJiaHeZhi.name;
		System.out.println(name + " discovered the well has " + leftWater + "L water");
		maJiaHeZhi.drinkWater(100);
		leftWater =/*5*/zhaoZhuang.lookWaterAmount();
		name = zhaoZhuang.name;
		System.out.println(name + " discovered the well has " + leftWater + "L water");
		int peopleNumber=zhaoZhuang.getPeopleNumber();
		System.out.println("The 赵庄's population is "+peopleNumber);
		peopleNumber= maJiaHeZhi.getPeopleNumber();
		System.out.println("The 马家河子's population is "+peopleNumber);

	}
}
