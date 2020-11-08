package cf.vbnm.chapter4.book_computer;

public class PC {
	private CPU cpu=new CPU();
	private HardDisk hardDisk=new HardDisk();

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}
	public void show(){
		System.out.println("The CPU's speed is "+cpu.getSpeed()+"MHz");
		System.out.println("The HardDisk's amount is "+hardDisk.getAmount()+"GB");
	}
}
