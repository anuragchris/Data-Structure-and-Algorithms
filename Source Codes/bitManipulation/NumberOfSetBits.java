package bitManipulation;

public class NumberOfSetBits {
	static int usingRightShift(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) != 0)
				count++;
			n = n >> 1;
		}
		return count;
	}

	static int efficientObservation(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(usingRightShift(11));
		System.out.println(efficientObservation(11));
	}
}
