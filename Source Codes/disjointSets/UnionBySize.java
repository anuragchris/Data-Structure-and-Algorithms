package disjointSets;

public class UnionBySize {
    private int[] s;
    private int size;

    public void MAKESET(int k) {
	size = k;
	s = new int[size];
	for (int i = size - 1; i >= 0; i--) {
	    s[i] = -1;
	}
    }

    public int FIND(int x) {
	if (x < 0 || x >= size) {
	    return Integer.MIN_VALUE;
	}
	if (s[x] == -1) {
	    return x;
	} else {
	    return FIND(s[x]);
	}
    }

    public void UNION(int root1, int root2) {
	int x = FIND(root1), y = FIND(root2);
	if (x == y) {
	    return;
	}
	if (x < y) {
	    s[x] = y;
	} else if (y < x) {
	    s[y] = x;
	} else {
	    s[y] = x;
	    s[x] = s[x] + 1;
	}
    }

    public void printSet() {
	for (int i = 0; i < s.length; i++) {
	    System.out.print(s[i] + " ");
	}
    }
}
