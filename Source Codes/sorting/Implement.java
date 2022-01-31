package sorting;

public class Implement {
	public static void main(String Args[]) {

		// 1. Bubble Sort
		// int a[] = { 1, 3, 4, 6, 5, 7, 2, 9, 99, 58, 31 };
		// BubbleSort bs = new BubbleSort();
		// bs.bubbleSort(a);
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i] + " ");
		// }

		// int a[] = { 1, 9, 8, 2, 5, 6, 7 };
		// BubbleSort bs = new BubbleSort();
		// if (bs.alreadySort(a)) {
		// System.out.println("Already Sorted");
		// } else {
		// System.out.println("Not Sorted");
		// }

		// 2. Selection Sort

		// int a[] = { 5, 4, 3, 2, 1, 11, 99, 101, 1000, 5000, 600 };
		// SelectionSort ss = new SelectionSort();
		// ss.selectionSort(a);

		// 3. Insertion Sort
		// int a[] = { 1, 9, 8, 2, 5, 6, 7 };
		// InsertionSort is = new InsertionSort();
		// is.ascendingOrder(a);

		// 4. Merge Sort
		// int arr[] = { 12, 11, 13, 5, 6, 7 };
		// for (int i = 0; i < arr.length; i++) {
		// System.out.print(arr[i] + " ");
		// }
		// MergeSort ms = new MergeSort();
		// ms.sort(arr, 0, arr.length - 1);
		// System.out.println();
		// System.out.println();
		// for (int i = 0; i < arr.length; i++) {
		// System.out.print(arr[i] + " ");
		// }

		int a[] = { 14, 13, 67, 2, 8, 4, 99, 6 };
		QuickSort qs = new QuickSort();
		System.out.print("Original Array : ");
		qs.printArray(a);
		System.out.println();
		qs.quickSort(a, 0, a.length - 1);
		System.out.print("Sorted Array : ");
		//		qs.printArray(a);

		// 6. Counting Sort
		// int k = 5;
		// int[] input = { 4, 3, 2, 5, 4, 3, 5, 1, 0, 2, 5 };
		// CountingSort cs = new CountingSort();
		// int a[] = cs.sort(input, k);
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i] + " ");
		// }

		// 7. Radix Sort
		// int[] data = { 121, 432, 564, 23, 1, 45, 788, 2, 3, 22, 32, 22, 33, 33, 44,
		// 44 };
		// int size = data.length;
		// RadixSort rs = new RadixSort();
		// rs.radixSort(data, size);
		// for (int i = 0; i < data.length; i++) {
		// System.out.print(data[i] + " ");
		// }
	}
}
