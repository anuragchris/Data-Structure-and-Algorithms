package queue;

public class QueueImplement {
    public static void main(String args[]) throws Exception {
	// CircularArray q1 = new CircularArray();
	// q1.enQueue(2);
	// q1.enQueue(3);
	// q1.enQueue(4);
	// System.out.println(q1.size());
	// System.out.println(q1.toString());
	// System.out.println(q1.deQueue());
	// System.out.println(q1.isEmpty());
	// System.out.println(q1.size());
	// q1.shrink();
	// q1.enQueue(1);
	// q1.enQueue(5);
	// q1.enQueue(7);
	// q1.shrink();
	// q1.enQueue(9);
	// q1.shrink();
	// LinkedQueue q2 = new LinkedQueue();
	// q2.enQueue(1);
	// q2.enQueue(2);
	// q2.enQueue(3);
	// q2.enQueue(4);
	// System.out.println(q2.display());
	// q2.reverse();
	// System.out.println(q2.display());
	// QueueWithTwoStacks q1 = new QueueWithTwoStacks();
	// q1.enQueue(1);
	LinkedQueue q3 = new LinkedQueue();
	q3.enQueue(1);
	q3.enQueue(2);
	q3.enQueue(3);
	q3.queueToStack();

    }
}
