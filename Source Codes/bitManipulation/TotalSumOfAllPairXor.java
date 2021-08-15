package bitManipulation;

public class TotalSumOfAllPairXor {
	static long solution(int arr[]) {
		long sum = 0;
		for (int i = 0; i < 32; i++) {
			int zeroCount = 0, oneCount = 0;
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j] & (1 << i)) == 0)
					zeroCount++;
				else
					oneCount++;
			}
			int pair = zeroCount * oneCount;
			sum += (1 << i) * pair;
		}
		return sum;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 9, 7, 6 };
		System.out.println(solution(arr));
	}
}
