//Link For Problem: https://leetcode.com/problems/palindrome-linked-list/

package twoPointer;

public class PalindromeLinkedList {

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

	public boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head;
		ListNode prev, temp;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		prev = slow;
		slow = slow.next;
		prev.next = null;

		while (slow != null) {
			temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}

		fast = head;
		slow = prev;

		while (slow != null) {
			if (slow.val != fast.val)
				return false;

			fast = fast.next;
			slow = slow.next;
		}

		return true;
	}
}
