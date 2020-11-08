package cf.vbnm.chapter7.check;

public class DangerException extends Exception {
	private String message;

	public DangerException() {
		message = "危险品!";
	}

	public void toShow() {
		System.out.println(message + "  ");
	}
}
