package disjointSets;

public class FastUnion {
    private int[] s;
    private int size;

    public void MAKESET(int k) {
	size = k;
	s = new int[size];
	for (int i = size - 1; i >= 0; i--) {
	    s[i] = i;
	}
    }

    public int FIND(int x) {
	if (x < 0 || x >= size) {
	    return -1;
	}
	if (s[x] == x) {
	    return x;
	} else {
	    return FIND(s[x]);
	}
    }

    public void UNION(int root1, int root2) {
	if (FIND(root1) == FIND(root2)) {
	    return;
	}
	if (!((root1 >= 0 && root1 < size) && (root2 >= 0 && root2 < size))) {
	    return;
	}
	s[root1] = root2;
    }

    public void printSet() {
	for (int i = 0; i < s.length; i++) {
	    System.out.println(s[i]);
	}
    }
}
