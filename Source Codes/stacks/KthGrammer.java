//Link For Problem : https://leetcode.com/problems/k-th-symbol-in-grammar/

package stacks;

public class KthGrammer {
	static int kthGrammar(int n, int k) {
		if (n == 1) {
			return 0;
		}
		int mid = (int) ((Math.pow(2, n - 1)) / 2);
		if (k <= mid) {
			return kthGrammar(n - 1, k);
		} else {
			return (kthGrammar(n - 1, k - mid)) ^ 1;
		}
	}

	public static void main(String[] args) {
		System.out.println(kthGrammar(2, 2));
	}
}
