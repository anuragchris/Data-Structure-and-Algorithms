//Link For Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

package twoPointer;

public class RemoveDuplicatesFromSortedList {

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}


	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode newHead = head;

		while (newHead.next != null) {

			if (newHead.val == newHead.next.val)
				newHead.next = newHead.next.next;
			else
				newHead = newHead.next;
		}

		return head;
	}
}
