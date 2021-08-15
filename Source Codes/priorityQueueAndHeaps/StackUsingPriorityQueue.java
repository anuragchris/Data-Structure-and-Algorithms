package priorityQueueAndHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StackUsingPriorityQueue {
    private PriorityQueue<StackElement> queue = new PriorityQueue<>(10, new Comparator<StackElement>() {
	@Override
	public int compare(StackElement o1, StackElement o2) {
	    return o2.key - o1.key;
	}
    });

    private int order = 1;
    private int size = 0;

    public void push(int val) {
	StackElement element = new StackElement(order++, val);
	queue.add(element);
	System.out.println("Pushed" + " " + val);
	size++;
    }

    public Integer pop() {
	if (queue.isEmpty()) {
	    System.err.println("UnderFlow");
	    return null;
	}
	size--;
	return queue.poll().value;
    }

    public int getSize() {
	return size;
    }

    public int getTop() {
	return queue.peek().value;
    }
}