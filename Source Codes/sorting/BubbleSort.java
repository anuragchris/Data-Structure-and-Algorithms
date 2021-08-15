package sorting;

public class BubbleSort {
    public void bubbleSort(int a[]) {
	for (int pass = a.length - 1; pass >= 0; pass--) {
	    for (int i = 0; i < pass - 1; i++) {
		if (a[i] > a[i + 1]) {
		    int temp = a[i];
		    a[i] = a[i + 1];
		    a[i + 1] = temp;
		}
	    }
	}
    }

    public boolean alreadySort(int a[]) {
	boolean swap = false;
	for (int i = 0; i < a.length - 1; i++) {
	    // swap = false;
	    for (int j = 0; j < a.length - i - 1; j++) {
		if (a[j] > a[j + 1]) {
		    int temp = a[j];
		    a[j] = a[j + 1];
		    a[j + 1] = temp;
		    swap = true;
		}
	    }
	    if (swap == false) {
		break;
	    }
	}
	if (swap == false) {
	    return true;
	} else {
	    return false;
	}
    }
}
