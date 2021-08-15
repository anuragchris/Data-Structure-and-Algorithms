package priorityQueueAndHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public Node mergeKSortedList(Node arr[], int k) {
	Node head = null, last = null;
	PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
	    @Override
	    public int compare(Node a, Node b) {
		return a.data - b.data;
	    }
	});
	for (int i = 0; i < k; i++) {
	    if (arr[i] != null) {
		pq.add(arr[i]);
	    }
	}

	while (!pq.isEmpty()) {
	    Node top = pq.remove();
	    if (top.next != null) {
		pq.add(top.next);
	    }
	    if (head == null) {
		head = top;
		last = top;
	    } else {
		last.next = top;
		last = top;
	    }
	}
	return head;
    }

    public Node push(int data) {
	Node newNode = new Node(data);
	newNode.next = null;
	return newNode;
    }

    public void printList(Node head) {
	while (head != null) {
	    System.out.println(head.data + " ");
	    head = head.next;
	}
    }

    public static void main(String[] args) {
	int k = 2;
	int n = 4;
	Node arr[] = new Node[k];
	arr[0] = new Node(2);
	arr[0].next = new Node(4);
	arr[0].next.next = new Node(6);
	arr[0].next.next.next = new Node(8);

	arr[1] = new Node(1);
	arr[1].next = new Node(3);
	arr[1].next.next = new Node(5);
	arr[1].next.next.next = new Node(7);
	Node head;
	MergeKLists mk = new MergeKLists();
	head = mk.mergeKSortedList(arr, k);
	mk.printList(head);
    }
}
