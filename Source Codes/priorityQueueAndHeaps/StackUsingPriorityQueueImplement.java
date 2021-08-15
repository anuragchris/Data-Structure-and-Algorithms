package priorityQueueAndHeaps;

public class StackUsingPriorityQueueImplement {
    public static void main(String[] args) {
	StackUsingPriorityQueue q1 = new StackUsingPriorityQueue();
	q1.push(5);
	q1.push(10);
	q1.push(20);
	System.out.println(q1.getSize());
	System.out.println(q1.pop());
	System.out.println(q1.getTop());
    }
}
