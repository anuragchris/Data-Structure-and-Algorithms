//Link For Problem: https://leetcode.com/problems/merge-k-sorted-lists/

package priorityQueueAndHeaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	//	  Definition for singly-linked list.
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

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0)
			return null;

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);

		for (ListNode l : lists)
			if (l != null)
				pq.offer(l);

		ListNode head = new ListNode(0);
		ListNode point = head;

		while (!pq.isEmpty()) {
			ListNode temp = pq.poll();
			head.next = temp;
			head = head.next;

			if (temp.next != null)
				pq.offer(temp.next);
		}
		head.next = null;

		return point.next;
	}

	public ListNode usingSort(ListNode[] lists) {

		if (lists.length == 0)
			return null;

		ArrayList<ListNode> al = new ArrayList<ListNode>();

		for (ListNode l : lists) {
			ListNode temp = l;

			while (temp != null) {
				al.add(temp);
				temp = temp.next;
			}
		}

		if (al.size() == 0)
			return null;

		Collections.sort(al, (o1, o2) -> o1.val - o2.val);

		for (int i = 0; i < al.size() - 1; i++)
			al.get(i).next = al.get(i + 1);

		al.get(al.size() - 1).next = null;

		return al.get(0);
	}
}
