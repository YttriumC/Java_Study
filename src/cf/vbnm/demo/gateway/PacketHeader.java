package cf.vbnm.demo.gateway;

public class PacketHeader {
	private int len;
	private int caplen;
	private TimeVal ts;

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getCaplen() {
		return caplen;
	}

	public void setCaplen(int caplen) {
		this.caplen = caplen;
	}

	public void setSec(long sec) {
		ts.setTv_sec(sec);
	}

	public void setUSec(long uSec){
		ts.setTv_usec(uSec);
	}
}

class TimeVal {
	private long tv_sec;
	private long tv_usec;

	public long getTv_sec() {
		return tv_sec;
	}

	public void setTv_sec(long tv_sec) {
		this.tv_sec = tv_sec;
	}

	public long getTv_usec() {
		return tv_usec;
	}

	public void setTv_usec(long tv_usec) {
		this.tv_usec = tv_usec;
	}
}