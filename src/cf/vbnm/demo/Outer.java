package cf.vbnm.demo;

public class Outer {
	class Inner{

	}
}
class Test{
	public static void main(String[] args) {
		Outer.Inner inner=new Outer().new Inner();

	}
}
