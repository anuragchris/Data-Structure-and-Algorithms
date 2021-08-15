package searching;

public class LinearSearch {
    public void linearSearch(int a[], int element) {
	int left = 0;
	int right = (a.length - 1);
	int position = -1;
	int length = a.length;
	for (left = 0; left <= right;) {
	    if (a[left] == element) {
		position = left;
		System.out.println("Found at Position : " + (position + 1) + " with " + (left + 1) + " Attempt ");
		break;
	    }
	    if (a[right] == element) {
		position = right;
		System.out.println("Found at Position : " + (position + 1) + " with " + (length - right) + " Attempt ");
		break;
	    }
	    left++;
	    right--;
	}
	if (position == -1) {
	    System.out.println("Not Found");
	}

    }
}
