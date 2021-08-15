package stacks;

import java.util.EmptyStackException;

public class TwoStacksInOneArray {
    int array[];
    int size;
    int firsttop;
    int secondtop;

    public TwoStacksInOneArray(int size) {
	if (size < 2) {
	    throw new IllegalStateException("size <2 is not valid");
	}
	array = new int[size];
	this.size = size;
	firsttop = -1;
	secondtop = size;
    }

    public void push(int id, int data) {
	if (secondtop == firsttop + 1) {
	    throw new StackOverflowError("Stack is Full");

	}
	if (id == 1) {
	    array[++firsttop] = data;

	} else if (id == 2) {
	    array[--secondtop] = data;
	} else {
	    return;
	}
    }

    public int pop(int id) {
	if (id == 1) {
	    if (firsttop == -1) {
		throw new EmptyStackException();
	    }
	    int temp = array[firsttop];
	    array[firsttop--] = Integer.MAX_VALUE;
	    return temp;
	} else if (id == 2) {
	    if (secondtop == this.size) {
		throw new EmptyStackException();
	    }
	    int temp = array[secondtop];
	    array[secondtop++] = Integer.MAX_VALUE;
	    return temp;
	} else {
	    return Integer.MAX_VALUE;
	}
    }

    public int top(int id) {
	if (id == 1) {
	    if (firsttop == -1) {
		throw new EmptyStackException();
	    }
	    int temp = array[firsttop];
	    return temp;
	} else if (id == 2) {
	    if (secondtop == this.size) {
		throw new EmptyStackException();
	    }
	    int temp = array[secondtop];
	    return temp;
	} else {
	    return Integer.MAX_VALUE;
	}
    }

    public boolean isEmpty(int id) {
	if (id == 1) {
	    return firsttop == -1;
	} else if (id == 2) {
	    return secondtop == this.size;
	} else {
	    return true;
	}
    }
}