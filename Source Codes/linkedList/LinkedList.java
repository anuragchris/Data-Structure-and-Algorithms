package linkedList;

public class LinkedList {
    public int Length(Node headNode) {
	int length = 0;
	Node currentNode = headNode;
	while (currentNode != null) {
	    length++;
	    currentNode = currentNode.getNext();
	}
	return length;
    }

    public LinkedList() {
	length = 0;
    }

    Node head;
    private int length = 0;

    public synchronized Node getHead() {
	return head;
    }

//insert node at beginning
    public synchronized void insertAtBegin(Node node) {
	node.setNext(head);
	head = node;
	length++;
    }

//insert node at end
    public synchronized void insertAtEnd(Node node) {
	if (head == null)
	    head = node;
	else {
	    Node p;
	    p = head;
	    while (p.getNext() != null) {
		p = p.getNext();
	    }
	    p.setNext(node);
	}
	Node p = head;
	int newlen = 0;
	while (p.getNext() != null) {
	    newlen++;
	    p = p.getNext();
	}
	length = ++newlen;
    }

    public void insert(Node data, int position) {
	{
	    if (position < 0)
		position = 0;
	}
	if (position > length) {
	    position = length;
	}
	if (head == null) {
	    head = data;
	} else if (position == 0) {
	    Node temp = data;
	    temp.next = head;
	    head = temp;
	} else {
	    Node temp = head;
	    for (int i = 1; i < position; i++) {
		temp = temp.getNext();
	    }
	    Node newNode = data;
	    newNode.next = temp.next;
	    temp.setNext(newNode);
	}
	length += 1;
    }

    public synchronized Node removeAtBegin() {
	Node node = head;
	if (node != null) {
	    head = node.getNext();
	    node.setNext(null);
	}
	return node;
    }

    public synchronized Node removeFromEnd() {
	if (head == null)
	    return null;
	Node p = head, q = null, next = head.getNext();
	if (next == null) {
	    head = null;
	    return p;
	}
	while ((next = p.getNext()) != null) {
	    q = p;
	    p = next;
	}
	q.setNext(null);
	return p;
    }

    public synchronized void remove(int position) {
	if (position < 0) {
	    position = 0;
	}
	if (position >= length) {
	    position = length - 1;
	}
	if (head == null) {
	    return;
	}
	if (position == 0) {
	    head = head.getNext();
	} else {
	    Node temp = head;
	    for (int i = 1; i < position; i += 1) {
		temp = temp.getNext();
	    }
	    temp.setNext(temp.getNext().getNext());
	}
	length -= 1;
    }

    public int length() {
	return length;
    }

    public int getPosition(int data) {
	Node temp = head;
	int pos = 0;
	while (temp != null) {
	    if (temp.getData() == data) {
		return pos;
	    }
	    pos++;
	    temp = temp.getNext();
	}
	return Integer.MIN_VALUE;
    }

    public void printAllValues() {
	Node p = head;

	while (p.getNext() != null) {
	    System.out.print(p.getData() + " ");
	    p = p.getNext();
	}
	System.out.print(p.getData());
	System.out.println();

    }

    public void evenOdd() {
	int len = 0;
	Node p = head;
	while (p.getNext() != null) {
	    len++;
	    p = p.getNext();
	}
	p = p.getNext();
	len++;
	if (len % 2 == 0) {
	    System.out.println("Even Numbers of Nodes :)");
	    Node q = head;
	    System.out.print("Even Nodes are : " + q.getData() + " ");
	    for (int i = 0; i < len; i++) {
		q = q.getNext();
		if (i % 2 == 0) {
		    System.out.print(q.getData() + " ");
		}
	    }
	    System.out.println();
	} else if (len % 2 != 0) {
	    System.out.println("Odd Numbers of Nodes :)");
	    Node q = head;
	    System.out.print("Odd Nodes are : " + q.getData() + " ");
	    for (int i = 0; i < len; i++) {
		q = q.getNext();
		if (i % 2 != 0) {
		    System.out.print(q.getData() + " ");
		}
	    }
	    System.out.println();
	} else {
	    System.out.print("No Nodes");
	    System.out.println();
	}

    }

    public void reverse() {
	int len = length();
	Node current = head;
	Node th = head;
	Node temp = null;
	for (int i = 0; i < len; i++) {
	    if (temp == null) {

		temp = current;
		th = current.getNext();
		current = th;
		temp.setNext(null);
	    } else {
		th = th.getNext();
		current.setNext(temp);
		temp = current;
		current = th;
	    }
	}
	head = temp;
	System.out.println();
	for (int i = 1; i < length(); i++) {
	    System.out.print(temp.getData() + " ");
	    temp = temp.getNext();
	}
    }

    public void loop() {
	Node p = head;
	Node q = head;
	int flag = 0;
	while (q.getNext() != null && q != null) {
	    p = p.getNext();
	    q = q.getNext().getNext();
	    if (p == q) {
		System.out.println("Loop Detected");
		flag = 1;
		break;
	    }
	}
	if (flag == 0) {
	    System.out.println("Loop not Detected");
	}
    }

    public void loopList(int data) {
	Node newNode = new Node(data);
	newNode.setNext(head);
	head = newNode;
    }
}
