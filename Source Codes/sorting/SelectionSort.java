package sorting;

public class SelectionSort {
    public void selectionSort(int a[]) {
	System.out.print("Original Array : ");
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + " ");
	}
	int min, i, j, temp;
	for (i = 0; i < a.length - 1; i++) {
	    min = i;
	    for (j = i + 1; j < a.length; j++) {
		if (a[j] < a[min]) {
		    min = j;
		}
	    }
	    if (min != i) {
		temp = a[i];
		a[i] = a[min];
		a[min] = temp;
	    }
	}
	System.out.print(" \n \nSorted Array : ");
	for (int m = 0; m < a.length; m++) {
	    System.out.print(a[m] + " ");
	}
    }
}
