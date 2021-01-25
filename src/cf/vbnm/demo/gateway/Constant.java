package cf.vbnm.demo.gateway;

public final class Constant {
	/**
	 * 状态指示:
	 * 初始:
	 * 初始化    0
	 * 查找设备:
	 * 失败      1
	 * 成功      2
	 * 打开设备:
	 * 失败      3
	 * 成功      4
	 * 准备就绪:
	 * 5
	 * 关闭设备:
	 * 6
	 */
	public static final int WINPCAP_INIT = 0;
	public static final int WINPCAP_FIND_DEV_FAILURE = 1;
	public static final int WINPCAP_FIND_DEV_SUCCESS = 2;
	public static final int WINPCAP_OPEN_FAILURE = 3;
	public static final int WINPCAP_DEV_READY = 4;
	public static final int WINPCAP_OPEN_LOOP_CAPPING = 5;
	public static final int WINPCAP_CLOSED = 6;
}
