package hashing;

import java.util.HashMap;

public class TwoEqualArray {
    public boolean usingHashMap(int a[], int b[]) {
	int n = a.length;
	int m = b.length;
	if (n != m) {
	    return false;
	}
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	int count = 0;
	for (int i = 0; i < n; i++) {
	    if (hm.get(a[i]) == null) {
		hm.put(a[i], 1);
	    } else {
		count = hm.get(a[i]);
		count++;
		hm.put(a[i], count);
	    }
	}
	for (int i = 0; i < n; i++) {
	    if (!hm.containsKey(b[i])) {
		return false;
	    }
	    if (hm.get(b[i]) == 0) {
		return false;
	    }
	    count = hm.get(b[i]);
	    --count;
	    hm.put(b[i], count);
	}
	return true;
    }

    public static void main(String[] args) {
	TwoEqualArray tea = new TwoEqualArray();
	int a[] = { 3, 5, 2, 5, 2 };
	int b[] = { 2, 3, 5, 5, 5, 2 };
	System.out.println(tea.usingHashMap(a, b));
    }
}
