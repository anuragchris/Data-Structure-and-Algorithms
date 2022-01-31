package dynammicProgramming;

public class UnboundedKnapSack {
	static int maxProfit(int wt[], int val[], int w, int n) {
		int t[][] = new int[n + 1][w + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (wt[i - 1] <= j) {
					t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][w];
	}

	static int rodCuttingProblem(int price[], int length[], int p, int n) {
		int t[][] = new int[n + 1][p + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < p + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (length[i - 1] <= j) {
					t[i][j] = Math.max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][p];
	}

	static int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int dp[][] = new int[n + 1][amount + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < amount + 1; j++) {
				if (j == 0)
					dp[i][j] = 0;
				else if (i == 0)
					dp[i][j] = (int) 1e5;
				else if (coins[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
			}
		}
		return dp[n][amount] > 1e4 ? -1 : dp[n][amount];
	}

	static int coinChangeMaxNoOfWays(int coin[], int sum, int n) {
		int t[][] = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			t[i][0] = 1;
		}
		for (int i = 1; i < sum + 1; i++) {
			t[0][i] = 0;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (coin[i - 1] <= j) {
					t[i][j] = t[i][j - coin[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][sum];
	}

	public static void main(String[] args) {
		//	int w = 100;
		//	int val[] = { 10, 30, 20 };
		//	int wt[] = { 5, 10, 15 };
		//	int n = val.length;
		//	System.out.println(maxProfit(wt, val, w, n));
		//	int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		//	int p = price.length;
		//	int length[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		//	int n = length.length;
		//	System.out.println(rodCuttingProblem(price, length, p, n));
		//	int coin[] = { 1, 2, 5 };
		//	int sum = 11;
		//	int n = coin.length;
		//	System.out.println(coinChangeMaxNoOfWays(coin, sum, n));

	}
}
