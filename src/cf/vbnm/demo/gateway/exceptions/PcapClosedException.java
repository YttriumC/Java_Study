package cf.vbnm.demo.gateway.exceptions;

public class PcapClosedException extends WinPcapException{
	public PcapClosedException(String message) {
		super(message);
	}
}
