package bitManipulation;

public class AllPairSumXOR {
	static int allPairSumXor(int arr[]) {
		int ans = 0;
		for (int i : arr) {
			ans ^= (2 * i);
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 1 };
		System.out.println(allPairSumXor(arr));
	}
}
