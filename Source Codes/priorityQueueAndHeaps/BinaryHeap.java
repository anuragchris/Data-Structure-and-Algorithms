package priorityQueueAndHeaps;

import java.util.ArrayList;

public class BinaryHeap {
	ArrayList<Integer> heap;

	public BinaryHeap() {
		heap = new ArrayList<Integer>();
	}

	public int size() {
		return this.heap.size();
	}

	public int getMax() {
		return this.heap.get(0);
	}

	private int getParent(int i) {
		if (i <= 0 || i > size() - 1)
			return -1;

		return (i - 1) / 2;
	}

	private int getLeftChild(int i) {
		int left = (2 * i) + 1;
		if (i < 0 || i > size() - 1 || left > size() - 1 || left < 0)
			return -1;

		return left;
	}

	private int getRightChild(int i) {
		int right = (2 * i) + 2;
		if (i < 0 || i > size() - 1 || right > size() - 1 || right < 0)
			return -1;

		return right;
	}

	private void percolateDown(int i) {
		int left = getLeftChild(i);
		int right = getRightChild(i);
		int max;

		if (left != -1 && this.heap.get(left) > this.heap.get(i))
			max = left;
		else
			max = i;

		if (right != -1 && this.heap.get(right) > this.heap.get(max))
			max = right;

		if (max != i) {
			int temp = this.heap.get(i);
			this.heap.set(i, this.heap.get(max));
			this.heap.set(max, temp);
			percolateDown(max);
		}
	}

	public void push(int data) {
		this.heap.add(data);
		int current = size() - 1;

		while (current != 0 && this.heap.get(getParent(current)) < this.heap.get(current)) {
			int temp = this.heap.get((current - 1) / 2);
			this.heap.set((current - 1) / 2, this.heap.get(current));
			this.heap.set(current, temp);
			current = getParent(current);
		}
	}

	private void increaseKey(int index, int value) {
		this.heap.set(index, value);


		while (index != 0 && this.heap.get(getParent(index)) < this.heap.get(index)) {
			int parent = getParent(index);
			int temp = this.heap.get(index);
			this.heap.set(index, this.heap.get(parent));
			this.heap.set(parent, temp);
			index = getParent(index);
		}
	}

	private void decreaseKey(int index, int value) {
		this.heap.set(index, value);
		percolateDown(index);
	}

	public void changeKey(int index, int value) {
		if (index > size() - 1)
			throw new ArrayIndexOutOfBoundsException("Invalid Index: " + index + " For Heap Size: " + size());

		int prev = this.heap.get(index);


		if (prev == value)
			return;

		if (prev > value)
			decreaseKey(index, value);
		else
			increaseKey(index, value);
	}

	public int deleteMax() {
		if (this.heap.isEmpty())
			throw new NullPointerException("Empty Heap");

		if (size() == 1)
			return this.heap.remove(0);

		int root = this.heap.get(0);

		this.heap.set(0, this.heap.get(size() - 1));
		this.heap.remove(size() - 1);

		percolateDown(0);

		return root;
	}

	public int deleteKey(int index) {
		int value = this.heap.get(index);

		increaseKey(index, Integer.MAX_VALUE);
		deleteMax();

		return value;
	}

	public void displayHeap() {
		for (int i : this.heap)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryHeap bh = new BinaryHeap();
		for (int i = 0; i < 20; i++)
			bh.push(i);
		bh.displayHeap();
		System.out.println(bh.deleteMax());
		bh.displayHeap();
		bh.changeKey(5, -1);
		bh.changeKey(4, 10000);
		bh.displayHeap();
		System.out.println(bh.deleteKey(2));
		bh.displayHeap();
		System.out.println(bh.getMax());
	}
}
