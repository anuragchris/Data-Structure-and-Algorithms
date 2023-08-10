//Link For Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package slidingWindowProblems;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int buy = Integer.MAX_VALUE, sell = 0;

		for (int i : prices) {
			buy = Math.min(buy, i);
			sell = Math.max(sell, i - buy);
		}

		return sell;
	}
}
