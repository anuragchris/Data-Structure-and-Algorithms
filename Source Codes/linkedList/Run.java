package linkedList;

public class Run {
    public static void main(String args[]) {
	LinkedList list = new LinkedList();
	Node node1 = new Node(6);
	list.insertAtBegin(node1);
	Node node2 = new Node(8);
	list.insert(node2, 1);
	Node node7 = new Node(7);
	list.insert(node7, 1);
	Node node3 = new Node(9);
	list.insert(node3, 2);
	Node node8 = new Node(10);
	Node node9 = new Node(50);
	list.insertAtEnd(node9);
	list.insert(node8, 4);
	//
	// list.printAllValues();
	// list.evenOdd();
	// list.reverse();
	// System.out.println(list.length());
	// list.loop();
	LinkedList list2 = new LinkedList();
	Node node4 = new Node(10);
	list2.insertAtBegin(node4);
	Node node5 = new Node(11);
	list2.insert(node5, 1);
	Node node6 = new Node(12);
	list2.insert(node6, 2);
	list2.insertAtEnd(list.getHead().getNext().getNext());
	// System.out.println(list2.length());
	// list2.printAllValues();
	// BruteForceMerge merge=new BruteForceMerge();
	// merge.bruteForceMerge(list, list2);
	TimeSave merger = new TimeSave();
	merger.SaveTime(list, list2);
	// }
	// LinkedList list3=new LinkedList();
	// list3.loopList(2);
	// list3.loopList(3);
	// list3.loopList(4);
	// list3.loopList(5);
	// list3.head.next.next.next.next=list3.head;
	// list3.loop();
    }
}
