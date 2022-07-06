//Link For Problem: https://leetcode.com/problems/linked-list-cycle/

package twoPointer;

public class LinkedListCycle {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;

		ListNode fast = head, slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow)
				return true;
		}

		return false;
	}
}
