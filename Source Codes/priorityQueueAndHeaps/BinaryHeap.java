package priorityQueueAndHeaps;

public class BinaryHeap {
    public int[] array;
    public int count;
    public int capacity;
    public int heap_type;

    public BinaryHeap(int capacity, int heap_type) {
	this.heap_type = heap_type;
	this.count = 0;
	this.capacity = capacity;
	this.array = new int[capacity];
    }

    public int getParent(int i) {
	if (i <= 0 || i > this.count) {
	    return -1;
	} else {
	    return this.array[(i - 1) / 2];
	}
    }

    public int getLeftChild(int i) {
	int left = (2 * i) + 1;
	if (left >= this.count) {
	    return -1;
	} else {
	    // System.out.println(this.array[left]);
	    return left;
	}
    }

    public int getRightChild(int i) {
	int right = (2 * i) + 2;
	if (right >= this.count) {
	    return -1;
	} else {
	    // System.out.println(this.array[right]);
	    return right;
	}
    }

    public int getMaximum() {
	if (this.count == 0) {
	    return -1;
	} else {
	    return this.array[0];
	}
    }

    public void percolateDown(int i) {
	int left, right, max, temp;
	left = getLeftChild(i);
	right = getRightChild(i);
	if (left != -1 && this.array[left] > this.array[i]) {
	    max = left;
	} else {
	    max = i;
	}
	if (right != -1 && this.array[max] < this.array[right]) {
	    max = right;
	}
	if (max != i) {
	    temp = this.array[i];
	    this.array[i] = this.array[max];
	    this.array[max] = temp;
	    percolateDown(max);
	}
    }

    public void insert(int data) {
	int i;
	if (this.count == capacity) {
	    reSizeHeap();
	}
	this.count++;
	i = this.count - 1;
	if (i == 0) {
	    this.array[i] = data;
	    return;
	}
	while (i >= 0 && data > this.array[(i - 1) / 2]) {
	    this.array[i] = this.array[(i - 1) / 2];
	    i = (i - 1) / 2;
	}
	this.array[i] = data;
    }

    public void reSizeHeap() {
	int array_old[] = new int[this.capacity];
	System.arraycopy(this.array, 0, array_old, 0, this.count - 1);
	this.array = new int[this.capacity * 2];
	if (this.array == null) {
	    System.out.println("Memory Error");
	    return;
	}
	for (int i = 0; i < this.capacity; i++) {
	    this.array[i] = array_old[i];
	}
	this.capacity *= 2;
	array_old = null;
    }

    public int deleteMax() {
	if (this.count == 0) {
	    return -1;
	}
	int data = this.array[0];
	this.array[0] = this.array[this.count - 1];
	this.count--;
	percolateDown(0);
	return data;
    }

    public void displayHeap() {
	for (int i = 0; i < this.array.length; i++) {
	    System.out.println(this.array[i]);
	}
    }

    public void buildHeap(BinaryHeap h, int a[], int n) {
	if (h == null) {
	    return;
	}
	while (n > this.capacity) {
	    h.reSizeHeap();
	}
	for (int i = 0; i < n; i++) {
	    h.array[i] = a[i];
	}
	h.count = n;
	for (int i = (n - 1) / 2; i >= 0; i--) {
	    h.percolateDown(i);
	}
    }

    public void heapSort(int a[], int n) {
	BinaryHeap h = new BinaryHeap(n, 0);
	int oldSize, i, temp;
	buildHeap(h, a, n);
	oldSize = h.count;
	for (i = n - 1; i > 0; i--) {
	    temp = h.array[0];
	    h.array[0] = h.array[h.count - 1];
	    h.array[h.count - 1] = temp;
	    h.count--;
	    h.percolateDown(0);
	}
	h.count = oldSize;
	System.arraycopy(h.array, 0, a, 0, n);
    }

    public void smallerElements(int key) {
	for (int i = 0; i < this.count; i++) {
	    if (key > this.array[i]) {
		System.out.println(this.array[i]);
	    }
	}
    }

    public void smallerElementUsingTree(int key, int pos) {
	if (pos >= this.count) {
	    return;
	}
	if (this.array[pos] < key) {
	    System.out.println(this.array[pos]);
	}
	// System.out.println(this.array[pos]);
	smallerElementUsingTree(key, (2 * pos) + 1);
	smallerElementUsingTree(key, (2 * pos) + 2);
    }

    public void mergeHeap(BinaryHeap bh, int a[], int b[]) {
	int alen = a.length;
	int blen = b.length;
	int mergeHeap[] = new int[alen + blen];
	System.arraycopy(a, 0, mergeHeap, 0, alen);
	System.arraycopy(b, 0, mergeHeap, alen, blen - 1);
	buildHeap(bh, mergeHeap, mergeHeap.length);
    }

    public int KthLargestElement(BinaryHeap bh, int k) {
	for (int i = 1; i < k; i++) {
	    bh.deleteMax();
	}
	return bh.deleteMax();
    }
}
