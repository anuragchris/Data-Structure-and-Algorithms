package priorityQueueAndHeaps;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {

    void printMax(int arr[], int k) {
	Deque<Integer> q = new LinkedList<Integer>();
	int i;
	for (i = 0; i < k; i++) {
	    while (!q.isEmpty() && arr[i] >= q.peekLast()) {
		q.removeLast();
	    }
	    q.addLast(arr[i]);
	}
	for (; i < arr.length; i++) {
	    System.out.println(q.peek());
	    while (!q.isEmpty() && q.peek() <= arr[i]) {
		q.removeFirst();
	    }
	    while (!q.isEmpty() && arr[i] >= q.peekLast()) {
		q.removeLast();
	    }
	    q.addLast(arr[i]);
	}
	System.out.println(q.peek());
    }

    void printMaxUsingTwoPointers(int arr[], int k) {
	if (k == 1) {
	    for (int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
	    }
	    return;
	}
	int p = 0, q = k - 1;
	int temp = p;
	int max = arr[k - 1];
	while (q < arr.length) {
	    if (arr[p] > max) {
		max = arr[p];
	    }
	    p += 1;
	    if (q == p && p != arr.length) {
		System.out.println(max);
		q++;
		p = ++temp;
		if (q < arr.length) {
		    max = arr[q];
		}
	    }
	}
    }

    public void maxSum(int arr[], int k) {
	int max = 0;
	for (int i = 0; i < k; i++) {
	    max = max + arr[i];
	}
	int current_sum = max;
	for (int i = k; i < arr.length; i++) {
	    current_sum += arr[i] - arr[i - k];
	    max = Math.max(max, current_sum);
	}
	System.out.println(max);
    }

    public static void main(String[] args) {
	SlidingWindow sw = new SlidingWindow();
	int arr[] = { 2, 5, 1, 8, 1, 3, 9 };
	// sw.printMax(arr, 3);
	// sw.printMaxUsingTwoPointers(arr, 2);
	// sw.maxSum(arr, 2);
    }
}
