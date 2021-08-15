package linkedList;

public class CircularRun {
	public static void main(String args[]) {
		CircularLinkedList list1=new CircularLinkedList();
		Node node1=new Node(2);
		list1.insertAtEnd(node1);
		Node node2=new Node(3);
		list1.insertAtEnd(node2);
		Node node3=new Node(4);
		list1.insertAtEnd(node3);
		Node node4=new Node(5);
		list1.insertAtEnd(node4);
		Node node5=new Node(6);
		list1.insertAtEnd(node5);
		list1.displayCircular();
		System.out.println();
		System.out.println(list1.Length());
		System.out.println(list1.elementFromEnd());
		System.out.println(list1.twoPointerSol());
		//list1.loop();
	}

}
