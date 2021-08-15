package priorityQueueAndHeaps;

public class BinaryHeapImplement {
    public static void main(String Args[]) {
	BinaryHeap bh = new BinaryHeap(8, 1);
	bh.insert(17);
	bh.insert(13);
	bh.insert(6);
	bh.insert(1);
	bh.insert(4);
	bh.insert(2);
	bh.insert(5);
	bh.insert(3);
	System.out.println(bh.KthLargestElement(bh, 4));
	// bh.displayHeap();
	// bh.smallerElements(15);
	// bh.smallerElementUsingTree(15, 0);
	// System.out.println(bh.getMaximum());
	// System.out.println(bh.getRightChild(2));
	// System.out.println(bh.getLeftChild(1));
	// System.out.println(bh.getParent(4));
	// bh.deleteMax();
	// bh.displayHeap();
	// BinaryHeap bh2 = new BinaryHeap(7, 1);
	// int a[] = { 3, 5, 2, 4, 6, 13, 17 };
	// int n = a.length;
	// bh2.buildHeap(bh2, a, n);
	// bh2.displayHeap();
	// int a[] = { 3, 5, 2, 4, 6, 13, 17 };
	// int n = a.length;
	// BinaryHeap bh3 = new BinaryHeap(7, 0);
	// bh3.heapSort(a, n);
	// for (int i = 0; i < n; i++) {
	// System.out.println(a[i]);
	// }
	// int a[] = { 3, 5, 2, 4, 6, 13, 17 };
	// int b[] = { 71, 24, 1, 0 };
	// BinaryHeap bh3 = new BinaryHeap(a.length + b.length, 1);
	// bh3.mergeHeap(bh3, a, b);
	// bh3.displayHeap();
    }
}
