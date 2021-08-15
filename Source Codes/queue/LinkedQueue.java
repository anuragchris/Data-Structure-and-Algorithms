package queue;

import linkedList.Node;
import stacks.UsingArrays;

public class LinkedQueue {
    private int length;
    private Node front, rear;

    public LinkedQueue() {
	length = 0;
	front = rear = null;
    }

    public boolean isEmpty() {
	return (length == 0);
    }

    public void enQueue(int data) {
	Node newNode = new Node(data);
	if (isEmpty()) {
	    front = newNode;
	} else {
	    rear.setNext(newNode);
	}
	rear = newNode;
	length++;
    }

    public int deQueue() throws Exception {
	if (isEmpty()) {
	    throw new Exception("Empty Queue");
	}
	int data = front.getData();
	front = front.getNext();
	length--;
	if (isEmpty()) {
	    rear = null;
	}
	return data;
    }

    public int first() throws Exception {
	if (isEmpty()) {
	    throw new Exception("Empty Queue");
	}
	int data = front.getData();
	return data;
    }

    public int size() {
	return length;
    }

    public String display() {
	String result = "";
	Node current = front;
	while (current != null) {
	    result = result + current.getData() + "\n";
	    current = current.getNext();
	}
	return result;
    }

    public void reverse() throws Exception {
	UsingArrays stk = new UsingArrays();
	while (!isEmpty()) {
	    int data = first();
	    deQueue();
	    stk.push(data);
	}
	while (!stk.isEmpty()) {
	    int data = stk.pop();
	    enQueue(data);
	}
    }

    public void queueToStack() throws Exception {
	UsingArrays stk = new UsingArrays();
	int len = size();
	int[] temp = new int[len];
	for (int i = 0; i < len; i++) {
	    int j = deQueue();
	    temp[i] = j;
	}

	for (int i = len - 1; i >= 0; i--) {
	    stk.push(temp[i]);
	}
	System.out.println(stk.display());
    }
}
