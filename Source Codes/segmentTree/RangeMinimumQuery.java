package segmentTree;

public class RangeMinimumQuery {
	static int[] constructST(int arr[], int n) {
		// Height of Segment Tree
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

		// Maximum Size of Segment Tree
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		int st[] = new int[max_size];
		constructSTUtil(arr, 0, n - 1, st, 0);
		return st;
	}

	static int constructSTUtil(int arr[], int ss, int se, int st[], int si) {
		// If there is one element in array, store it in current node of
		// segment tree and return
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}
		// If there are more than one elements, then recur for left and
		// right subtrees and store the sum of values in this node
		int mid = getMid(ss, se);
		st[si] = Math.min(constructSTUtil(arr, ss, mid, st, (2 * si) + 1),
		        constructSTUtil(arr, mid + 1, se, st, (2 * si) + 2));
		return st[si];
	}

	static int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	// Return minimum of elements in range
	// from index qs (query start) to
	// qe (query end). It mainly uses RMQUtil()
	static int RMQ(int st[], int n, int qs, int qe) {

		// Check for erroneous input values
		if (qs < 0 | qe > n - 1) {
			System.out.println("Invalid Input");
			return 0;
		}
		return RMQUtil(st, 0, n - 1, qs, qe, 0);
	}

	/*
	 * A recursive function to get the minimum value in a given range of array
	 * indexes. The following are parameters for this function.
	 * st --> Pointer to segment tree 
	 * index --> Index of current node in the segment tree. Initially 0 is passed as root is always at index 0 
	 * ss & se --> Starting and ending indexes of the segment represented by current node, i.e., st[index]. 
	 * qs & qe --> Starting and ending indexes of query range
	 */
	static int RMQUtil(int st[], int ss, int se, int qs, int qe, int index) {

		// If segment of this node is a part
		// of given range, then return
		// the min of the segment
		if (qs <= ss && qe >= se)
			return st[index];

		// If segment of this node
		// is outside the given range
		if (se < qs || ss > qe)
			return Integer.MAX_VALUE;

		// If a part of this segment
		// overlaps with the given range
		int mid = getMid(ss, se);
		return Math.min(RMQUtil(st, ss, mid, qs, qe, (2 * index) + 1),
		        RMQUtil(st, mid + 1, se, qs, qe, (2 * index) + 2));
	}

	static void updateValue(int st[], int n, int i, int newValue) {
		if (i < 0 || i > n - 1) {
			System.out.println("Invalid Update Index");
			return;
		}
		updateValueUtil(st, 0, n - 1, i, newValue, 0);
	}

	static void updateValueUtil(int st[], int ss, int se, int i, int newValue, int si) {
		if (i < ss || i > se)
			return;
		if (ss == se) {
			st[si] = newValue;
			return;
		}
		int mid = getMid(ss, se);
		updateValueUtil(st, ss, mid, i, newValue, (2 * si) + 1);
		updateValueUtil(st, mid + 1, se, i, newValue, (2 * si) + 2);
		st[si] = Math.min(st[(2 * si) + 1], st[(2 * si) + 2]);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int st[] = constructST(arr, arr.length);
		int qs = 0, qe = 5;
		System.out.println(RMQ(st, arr.length, qs, qe));
		updateValue(st, arr.length, 0, 10);
		System.out.println(RMQ(st, arr.length, qs, qe));
	}
}
