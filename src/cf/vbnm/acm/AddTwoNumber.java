package cf.vbnm.acm;

public class AddTwoNumber {
	public static void main(String[] args) {
		AddTwoNumber addTwoNumber = new AddTwoNumber();
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode longest, rtn;
		ListNode n1 = l1, n2 = l2;
		while (n1.next != null && n2.next != null) {
			n1.val += n2.val;
			if (n1.val > 9) {
				n1.next.val++;
				n1.val -= 10;
			}
			n2.val = n1.val;
			n1 = n1.next;
			n2 = n2.next;
		}
		n1.val += n2.val;
		n2.val = n1.val;
		longest = (n1.next == null) ? n2 : n1;
		rtn = (n1.next == null) ? l2 : l1;
		while (longest.next != null) {
			if (longest.val > 9) {
				longest.next.val++;
				longest.val -= 10;
			}
			longest = longest.next;
		}
		if (longest.val > 9) {
			longest.next = new ListNode(1);
			longest.val -= 10;
		}
		return rtn;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
