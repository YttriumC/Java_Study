package cf.vbnm.chapter5.people;

public class BeijingPeople extends ChinaPeople {
	@Override
	public void speakHello() {
		super.speakHello();
	}

	@Override
	/*4*/public void averageHeight() {
		height=172.5;
		System.out.println("北京人的平均身高:"+height+"cm");
	}

	@Override
	public void averageWeight() {
		weight=70;
		System.out.println("北京人的平均体重是:"+weight+"Kg");
	}

	public void beijingOpera(){
		System.out.println("花脸,青衣,花旦和老生");
	}
}
