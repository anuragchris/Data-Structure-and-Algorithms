//Link For Problem: https://leetcode.com/problems/linked-list-cycle-ii/

package twoPointer;

public class LinkedListCycleII {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode fast = head, slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow)
				break;
		}

		if (fast == null || fast.next == null)
			return null;

		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}

		return head;
	}
}
