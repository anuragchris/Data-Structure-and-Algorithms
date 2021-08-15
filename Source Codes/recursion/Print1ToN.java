package recursion;

public class Print1ToN {
	static void print1ToN(int n) {
		if (n > 0) {
			print1ToN(n - 1);
			System.out.print(n + " ");
		}
		return;
	}

	static void printNto1(int n) {
		System.out.print(n + " ");
		if (n > 1) {
			printNto1(n - 1);
		}
	}

	public static void main(String[] args) {
		print1ToN(10);
		System.out.println();
		printNto1(10);
	}
}
