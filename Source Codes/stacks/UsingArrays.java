package stacks;

public class UsingArrays {
    protected int capacity;
    public static final int CAPACITY = 16;
    protected int[] stack;
    protected int top = -1;

    public UsingArrays() {
	this(CAPACITY);
    }

    public UsingArrays(int cap) {
	capacity = cap;
	stack = new int[capacity];
    }

    public int size() {
	return (top + 1);
    }

    public void empty() {
	if (top < 0) {
	    System.out.println("Stack Empty");
	} else {
	    System.out.println("Stack Not Empty");
	}
    }

    public boolean isEmpty() {
	return (top < 0);
    }

    public void push(int data) throws Exception {
	if (size() == capacity) {
	    throw new Exception("Stack is Full");
	}
	top += 1;
	stack[top] = data;
    }

    public int displayTop() throws Exception {
	if (top < 0) {
	    throw new Exception("Stack is Empty");
	} else {
	    return stack[top];
	}
    }

    public int pop() throws Exception {
	int data;
	if (top < 0) {
	    throw new Exception("Stack is Empty");
	    // System.exit(0);
	} else {
	    data = stack[top];
	    stack[top--] = Integer.MIN_VALUE;
	    return data;
	}
    }

    public String display() {
	String s;
	s = "{";
	if (top < 0) {
	    s = "Empty Stack";
	    return s;
	} else {
	    if (size() > 0) {
		for (int i = 0; i < size(); i++) {
		    s += stack[i] + ",";
		}
	    }
	    return s + "}";
	}
    }

    public void shrink() throws Exception {
	if (top < 0) {
	    throw new Exception("Stack is Empty");
	}
	int p = size();
	int j = p * 3 / 4;
	if (j > (top + 1)) {
	    int a = (top + 1) / 2;
	    int c[] = new int[a];
	    System.arraycopy(stack, 0, c, 0, top + 1);
	    stack = c;
	}
    }

    public void popAndShrink() throws Exception {
	if (top < 0) {
	    throw new Exception("Empty Stack");
	}
	int data = stack[top];
	stack[top--] = Integer.MAX_VALUE;
	shrink();
	System.out.println("Top removed: " + data);
    }

    public void reverseStack() throws Exception {
	if (isEmpty()) {
	    return;
	}
	int temp = pop();
	reverseStack();
	insertAtBottom(temp);
    }

    public void insertAtBottom(int data) throws Exception {
	if (isEmpty()) {
	    push(data);
	    return;
	}
	int temp = pop();
	insertAtBottom(data);
	push(temp);
    }

    public int[] FindingSpans(int[] inputArray) {
	int[] span = new int[inputArray.length];
	for (int i = 0; i < inputArray.length; i++) {
	    int s = 1;
	    int j = i - 1;
	    while (j >= 0 && inputArray[j] <= inputArray[j + 1]) {
		s++;
		j--;
	    }
	    span[i] = s;
	}

	return span;

    }

    public String FindingSpansUsingStacks(int[] inputArray) throws Exception {
	String a = null;
	int b = inputArray.length;
	int c = capacity;
	int s = 1;
	push(s);
	// for (int i = 0; i < inputArray.length; i++) {
	s = 1;
	int i = 0;
	if (!isEmpty()) {
	    while ((i + 1) < b && (i + 1) < c) {
		if (inputArray[i] < inputArray[i + 1]) {
		    if (i == 0) {
			s = displayTop() + s;
			push(s);
		    } else if (displayTop() == 1) {
			push(2);
		    } else {
			s = 1;
			s = displayTop() + s;
			push(s);
		    }
		    i++;
		} else if (inputArray[i] >= inputArray[i + 1]) {
		    push(1);
		    i++;

		}

	    }
	    a = display();
	}
	return a;
    }
}
