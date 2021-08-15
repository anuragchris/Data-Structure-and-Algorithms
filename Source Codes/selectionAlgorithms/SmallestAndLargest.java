package selectionAlgorithms;

public class SmallestAndLargest {
    public void findLargestElement(int a[]) {
	int len = a.length;
	int largest = a[0];
	for (int i = 1; i < len; i++) {
	    if (a[i] > largest) {
		largest = a[i];
	    }
	}
	System.out.println(largest);
    }

    public void smallestAndLargest(int a[]) {
	int smallest = a[0];
	int largest = a[0];
	for (int i = 0; i < a.length; i++) {
	    if (a[i] < smallest) {
		smallest = a[i];
	    } else if (a[i] > largest) {
		largest = a[i];
	    }
	}
	System.out.println("Smallest : " + " " + smallest);
	System.out.println("Largest : " + " " + largest);
    }

    public void smallestAndLargestWithComparison(int a[]) {
	int large = -1;
	int small = 1;
	for (int i = 0; i < a.length - 1; i++) {
	    if (a[i] < a[i + 1]) {
		if (a[i] < small) {
		    small = a[i];
		}
		if (a[i + 1] > large) {
		    large = a[i + 1];
		}
	    } else {
		if (a[i + 1] < small) {
		    small = a[i + 1];
		}
		if (a[i] > large) {
		    large = a[i];
		}
	    }
	}
	System.out.println("Smallest : " + " " + small);
	System.out.println("Largest : " + " " + large);
    }
}
