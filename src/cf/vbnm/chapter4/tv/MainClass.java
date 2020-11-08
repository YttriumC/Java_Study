package cf.vbnm.chapter4.tv;

public class MainClass {
	public static void main(String[] args) {
		TV haierTV=new TV();
		/*2*/haierTV.setChannel(5);
		/*after experiment*/
		//haierTV.setChannel(5);
		//不能收看0频道
		/*after experiment*/
		System.out.println("haierTV's channel is "+haierTV.getChannel());
		Family zhangSanFamily=new Family();
		/*3*/zhangSanFamily.buyTV(haierTV);
		System.out.println("zhangsanFamily is watching now");
		zhangSanFamily.seeTV();
		int m=2;
		System.out.println("zhangsanFamily changed the channel to "+m+"channel");
		zhangSanFamily.remoteControl(m);
		System.out.println("haierTV's channel is "+haierTV.getChannel());
		System.out.println("zhangsanFamily is watching now ");
		zhangSanFamily.seeTV();
		/*after experiment*/
		Family lisiFamily=new Family();
		lisiFamily.buyTV(haierTV);
		lisiFamily.seeTV();
		//李四和张三使用了同一台电视,张三对电视的操作会同时反映到李四上面
		/*after experiment*/
	}

}
