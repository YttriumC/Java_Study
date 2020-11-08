package cf.vbnm.chapter5.people;

public class ChinaPeople extends People {
	@Override
	public void speakHello() {
		System.out.println("你好");
	}

	@Override
	public void averageHeight() {
		height=168.78;
		System.out.println("中国人平均身高:"+height+"cm");
	}

	@Override
	/*1*/public void averageWeight() {
		weight=65;
		System.out.println("中国人平均体重:"+weight+"Kg");
	}

	public void chinaKongFu(){
		System.out.println("坐如钟,站如松,睡如弓");
	}
}
