package cf.vbnm.chapter4.tv;

public class Family {
	TV homeTV;
	void buyTV(TV tv)
	{
		/*1*/homeTV=tv;

	}
	void remoteControl(int m)
	{
		homeTV.setChannel(m);
	}
	void seeTV(){
		homeTV.showProgram();
	}
}
