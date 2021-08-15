//Link For Problem : https://leetcode.com/problems/largest-component-size-by-common-factor/

package graphProblems;

import java.util.HashMap;

public class Largest_Component_By_Size_Factor {
	static int largestComponentSize(int[] nums) {
		int n = nums.length;
		int parent[] = new int[100001];
		for (int i = 0; i < 100001; i++) {
			parent[i] = -1;
		}
		for (int i = 0; i < n; i++) {
			for (int k = 2; k <= Math.sqrt(nums[i]); ++k) {
				if (nums[i] % k == 0) {
					union(nums[i], k, parent);
					union(nums[i], nums[i] / k, parent);
				}
			}
		}
		int count = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int p = find(nums[i], parent);
			count = Math.max(count, 1 + hm.getOrDefault(p, 0));
			hm.put(p, 1 + hm.getOrDefault(p, 0));
		}
		return count;
	}

	static void union(int x, int y, int parent[]) {
		int xp = find(x, parent);
		int yp = find(y, parent);
		if (xp != yp) {
			parent[yp] = xp;
		}
	}

	static int find(int x, int parent[]) {
		if (parent[x] == -1) {
			return x;
		}
		parent[x] = find(parent[x], parent);
		return parent[x];
	}
}
