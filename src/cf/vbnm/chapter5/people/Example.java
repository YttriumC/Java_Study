package cf.vbnm.chapter5.people;

public class Example {
	public static void main(String[] args) {
		ChinaPeople chinaPeople=new ChinaPeople();
		AmericanPeople americanPeople=new AmericanPeople();
		BeijingPeople beijingPeople=new BeijingPeople();
		chinaPeople.speakHello();
		americanPeople.speakHello();
		beijingPeople.speakHello();
		chinaPeople.averageHeight();
		americanPeople.averageHeight();
		beijingPeople.averageHeight();
		chinaPeople.averageWeight();
		americanPeople.averageWeight();
		beijingPeople.averageWeight();
		chinaPeople.chinaKongFu();
		americanPeople.americanBoxing();
		beijingPeople.beijingOpera();
		beijingPeople.chinaKongFu();
	}
}
