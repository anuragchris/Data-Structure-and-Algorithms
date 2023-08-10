// Link For Problem: https://leetcode.com/problems/merge-two-sorted-lists/

package linkedList;

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

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(0);
		ListNode tail = head;

		while (list1 != null && list2 != null) {

			if (list1.val < list2.val) {
				tail.next = list1;
				list1 = list1.next;
				tail = tail.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
				tail = tail.next;
			}
		}

		while (list1 != null) {
			tail.next = list1;
			list1 = list1.next;
			tail = tail.next;
		}

		while (list2 != null) {
			tail.next = list2;
			list2 = list2.next;
			tail = tail.next;
		}

		return head.next;
	}
}
