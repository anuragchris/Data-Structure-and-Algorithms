package bitManipulation;

public class RightMost_DifferentBit {
	static int rightMostDiff(int x, int y) {
		int mask = 1;
		int counter = 1;
		while ((mask & x) == (mask & y)) {
			counter++;
			mask <<= 1;
		}
		return counter;
	}

	public static void main(String[] args) {
		System.out.println(rightMostDiff(10, 14));
	}
}
