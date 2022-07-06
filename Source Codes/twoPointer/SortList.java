//Link For Problem: https://leetcode.com/problems/sort-list/

package twoPointer;

public class SortList {

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

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);

		return merge(left, right);
	}

	ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode tail = dummy;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
				tail = tail.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
				tail = tail.next;
			}
		}

		tail.next = (l1 == null) ? l2 : l1;

		return dummy.next;
	}

	ListNode getMid(ListNode head) {
		ListNode prev = null;

		while (head != null && head.next != null) {
			prev = (prev == null) ? head : prev.next;
			head = head.next.next;
		}

		ListNode mid = prev.next;
		prev.next = null;

		return mid;
	}
}
