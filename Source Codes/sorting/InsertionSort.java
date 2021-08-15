package sorting;

public class InsertionSort {
    public void ascendingOrder(int a[]) {
	System.out.print("Original Array : ");
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + " ");
	}
	int i;
	for (i = 1; i <= a.length - 1; i++) {
	    int key = a[i];
	    while (a[i - 1] > key && i >= 1) {
		a[i] = a[i - 1];
		i--;
	    }
	    a[i] = key;
	}
	System.out.print(" \n \nSorted Array : ");
	for (int m = 0; m < a.length; m++) {
	    System.out.print(a[m] + " ");
	}
    }
}
