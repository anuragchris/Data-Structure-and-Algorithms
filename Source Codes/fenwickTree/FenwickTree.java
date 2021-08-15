package fenwickTree;

public class FenwickTree {

	static int[] constructBIT(int arr[], int n) {

		int[] bit = new int[arr.length + 1];

		for (int i = 0; i <= n; i++) {
			bit[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			updateBIT(bit, n, i, arr[i]);
		}
		return bit;
	}

	static void updateBIT(int bit[], int n, int index, int val) {
		index = index + 1;
		while (index <= n) {

			// Add 'val' to current node of BIT Tree
			bit[index] += val;

			// Update index to that of parent
			// in update View
			index += index & (-index);
		}
	}

	static int getSum(int bit[], int index) {
		int sum = 0; // Initialize result

		// index in BITree[] is 1 more than
		// the index in arr[]
		index += 1;

		// Traverse ancestors of BITree[index]
		while (index > 0) {

			// Add current element of BITree
			// to sum
			sum += bit[index];

			// Move index to parent node in
			// getSum View
			index -= index & (-index);
		}
		return sum;
	}

	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 4, 5, 6, 7 };
		int binaryIndexedTree[] = constructBIT(input, input.length);
		System.out.println(getSum(binaryIndexedTree, 5));
		updateBIT(binaryIndexedTree, input.length, 3, 6);
		System.out.println(getSum(binaryIndexedTree, 5));
		System.out.println(getSum(binaryIndexedTree, 5));
	}
}
