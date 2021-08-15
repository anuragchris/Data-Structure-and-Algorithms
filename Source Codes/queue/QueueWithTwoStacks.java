package queue;

import stacks.UsingArrays;

public class QueueWithTwoStacks {
    private UsingArrays stk1 = new UsingArrays();
    private UsingArrays stk2 = new UsingArrays();

    public int enQueue(int data) {
	try {
	    stk1.push(data);
	} catch (Exception e) {

	}
	System.out.println(data + " Enqueued ");
	return data;

    }

    public int deQueue() throws Exception {
	if (stk2.isEmpty()) {
	    while (!stk1.isEmpty()) {
		try {
		    stk2.push(stk1.pop());
		} catch (Exception e) {
		}

	    }
	    return stk2.pop();
	} else if (stk1.isEmpty() && stk2.isEmpty()) {
	    throw new Exception("Empty Queue");
	} else {
	    return stk2.pop();
	}
    }
}
