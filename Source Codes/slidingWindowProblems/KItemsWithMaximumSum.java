//Link For Problem: https://leetcode.com/problems/k-items-with-the-maximum-sum/

package slidingWindowProblems;

public class KItemsWithMaximumSum {

	public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
		if (k <= numOnes)
			return k;

		if (k <= (numOnes + numZeros))
			return numOnes;

		return numOnes - (k - (numOnes + numZeros));
	}
}
