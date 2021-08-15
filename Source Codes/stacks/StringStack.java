package stacks;

import java.util.ArrayList;
import java.util.List;

public class StringStack {

    protected int capacity;
    public static final int CAPACITY = 16;
    protected int top = -1;
    protected String stk[];

    public StringStack() {
	this(CAPACITY);
    }

    public StringStack(int cap) {
	capacity = cap;
	stk = new String[capacity];
    }

    public int size() {
	return (top + 1);
    }

    public boolean isEmpty() {
	return (top < 0);
    }

    public void push(String s) throws Exception {
	if (size() == capacity) {
	    expand();
	}
	stk[++top] = s;
    }

    public String pop() throws Exception {
	String s = null;
	String topelement = peek();
	if (topelement.equals("Empty")) {
	    throw new Exception("Empty Stack");
	} else {
	    s = stk[top];
	    stk[top--] = null;
	    return s;

	}
    }

    public void expand() {
	int len = size();
	String[] stknew = new String[len];
	System.arraycopy(stk, 0, stknew, 0, len);
	stk = stknew;
	this.capacity = this.capacity + 1;

    }

    public void shrink() throws Exception {
	if (isEmpty()) {
	    throw new Exception("Stack is Empty");
	}
	int p = size();
	int j = p * 3 / 4;
	if (j > (top + 1)) {
	    int a = (top + 1) / 2;
	    String[] stknew = new String[a];
	    System.arraycopy(stk, 0, stknew, 0, top + 1);
	    stk = stknew;
	}
    }

    public String displaytop() throws Exception {
	String s = null;
	if (isEmpty()) {
	    throw new Exception("Empty Stack");
	} else {
	    s = stk[top];

	}
	return s;
    }

    public String display() throws Exception {
	StringBuilder s = new StringBuilder();
	List<String> display = new ArrayList<String>();
	s.append("{");
	if (isEmpty()) {
	    throw new Exception("Empty Stack");
	} else {
	    if (size() > 0) {
		for (int i = 0; i < size(); i++) {
		    display.add(stk[i]);
		}
		s.append(String.join(",", display)).append("}");
	    }

	    return s.toString();
	}
    }

    public String peek() {
	if (isEmpty()) {
	    return "Empty";
	} else {
	    return stk[top];
	}
    }

    public boolean symbol(String s) throws Exception {
	if (s == null || s.length() == 0)
	    return true;
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == ')') {
		int j = 0;
		char b = displaytop().charAt(j);
		if (!isEmpty() && b == '(') {
		    pop();

		} else {
		    return false;
		}
	    } else if (s.charAt(i) == '}') {
		int j = 0;
		char b = displaytop().charAt(j);
		if (!isEmpty() && b == '{') {
		    pop();
		} else {
		    return false;
		}
	    } else if (s.charAt(i) == ']') {
		int j = 0;
		char b = displaytop().charAt(j);
		if (!isEmpty() && b == '[') {
		    pop();
		} else {
		    return false;
		}
	    } else {
		push(Character.toString(s.charAt(i)));
	    }
	}
	if (isEmpty()) {
	    System.out.println("Operation Successfull");
	    return true;
	} else {
	    System.out.println("Operation Unsuccessfull");
	    return false;
	}
    }

    // public void infixToPostFix(String infix) throws Exception {
    // char symbol;
    // String postfix = "";
    // for (int i = 0; i < infix.length(); i++) {
    // symbol = infix.charAt(i);
    // if (Character.isLetter(symbol)) {
    // postfix = postfix + symbol;
    // } else if (symbol == '(') {
    // push(Character.toString(symbol));
    //
    // } else if (symbol == ')') {
    // while (peek() != Character.toString('(')) {
    // String b = pop();
    // postfix = postfix + b;
    //
    // }
    // pop();
    // } else {
    // String topelement = peek();
    // if (topelement.equals("Empty")) {
    // push(Character.toString(symbol));
    // } else {
    // String a = peek();
    // char b = a.charAt(0);
    // while (!isEmpty() && b != ('(') && prec(symbol) <= a.charAt(0)) {
    // String c = pop();
    // postfix = postfix + c;
    // push(Character.toString(symbol));
    // }
    // }
    // }
    // while (!isEmpty()) {
    // String b = pop();
    // postfix = postfix + b;
    // System.out.println(postfix);
    // }
    // }
    // }

    // static int prec(char x) {
    // if (x == '+' || x == '-')
    // return 1;
    // if (x == '*' || x == '/' || x == '%')
    // return 2;
    // return 0;
    // }

}