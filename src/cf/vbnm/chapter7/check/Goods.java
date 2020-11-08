package cf.vbnm.chapter7.check;

public class Goods {
	private boolean isDanger;
	private String name;

	public void setIsDanger(boolean danger) {
		isDanger = danger;
	}

	public boolean isDanger() {
		return isDanger;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
