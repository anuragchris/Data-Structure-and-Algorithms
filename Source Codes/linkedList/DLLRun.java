package linkedList;

public class DLLRun {
public static void main(String args[])
{
	DLLlist list1=new DLLlist();
	DLLNode node1=new DLLNode(4);
	list1.insertAtBegin(node1);
	DLLNode node2=new DLLNode(5);
	list1.insertAtEnd(node2);
	DLLNode node3=new DLLNode(6);
	list1.insert(node3, 1);
	//list1.deleteAtBegin();
	//list1.deleteAtEnd();
	list1.printDLL();
	System.out.print("Length :" + list1.dlllength());
	
}
}
