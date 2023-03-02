//Link For Problem: https://leetcode.com/problems/satisfiability-of-equality-equations/

package graphProblems;

public class SatisfiabilityOfEqualityEquations {

	public boolean equationsPossible(String[] equations) {
		int parent[] = new int[26];

		for (int i = 0; i < 26; i++)
			parent[i] = i;

		for (String e : equations) {
			if (e.charAt(1) == '=')
				parent[find(e.charAt(0) - 'a', parent)] = find(e.charAt(3) - 'a', parent);
		}

		for (String e : equations) {
			if (e.charAt(1) == '!' && find(e.charAt(0) - 'a', parent) == find(e.charAt(3) - 'a', parent))
				return false;
		}

		return true;
	}

	int find(int x, int parent[]) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x], parent);
	}
}
