package queue;

public class CircularArray {
    private int queueRep[];
    private int size, rear, front;
    private static int CAPACITY = 16;

    public CircularArray() {
	queueRep = new int[CAPACITY];
	size = 0;
	front = 0;
	rear = 0;
    }

    public CircularArray(int cap) {
	queueRep = new int[cap];
	size = 0;
	front = 0;
	rear = 0;
    }

    public void enQueue(int data) throws NullPointerException, IllegalStateException {
	if (size == CAPACITY) {
	    throw new IllegalStateException("Queue is Full : Overflow");
	} else {
	    size++;
	    queueRep[rear] = data;
	    rear = (rear + 1) % CAPACITY;

	}
    }

    public int deQueue() throws IllegalStateException {
	if (size == 0) {
	    new IllegalStateException("Empty Queue : Underflow");
	    return 0;
	} else {
	    size--;
	    int data = queueRep[(front % CAPACITY)];
	    queueRep[front] = Integer.MIN_VALUE;
	    front = (front + 1) % CAPACITY;
	    return data;
	}
    }

    public boolean isEmpty() {
	return (size == 0);
    }

    public boolean isFull() {
	return (size == CAPACITY);
    }

    public int size() {
	return size;
    }

    @Override
    public String toString() {
	String result = "[";
	for (int i = 0; i < size; i++) {
	    result += Integer.toString(queueRep[(front + i) % CAPACITY]);
	    if (i < size - i) {
		result += ",";
	    }
	}
	result += "]";
	return result;
    }

    public void expand() {
	int length = size();
	int newQueue[] = new int[length << 1];
	for (int i = front; i <= rear; i++) {
	    newQueue[i - front] = queueRep[i % CAPACITY];
	}
	this.queueRep = newQueue;
	front = 0;
	rear = size - 1;
	CAPACITY *= 2;
    }

    public void shrink() throws Exception {
	int length = size();
	int condition = CAPACITY * 3 / 4;
	if (length < condition) {
	    int newlen = CAPACITY / 2;
	    int shrinkQueue[] = new int[newlen];
	    System.arraycopy(queueRep, 0, shrinkQueue, 0, length + 1);
	    this.queueRep = shrinkQueue;
	} else {
	    throw new Exception("Condition not Fulfilled");
	}

    }

}
