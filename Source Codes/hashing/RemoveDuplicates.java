package hashing;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public int removeDuplicates(int a[]) {
	if (a.length == 0 || a.length == 1) {
	    return 0;
	}
	int j = 0;
	for (int i = 0; i < a.length - 1; i++) {
	    if (a[i] != a[i + 1]) {
		a[j] = a[i];
		j++;
	    }
	}
	a[j] = a[a.length - 1];
	j++;
	return j;
    }

    public void usingSet(int a[]) {
	LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
	for (int i = 0; i < a.length; i++) {
	    lhs.add(a[i]);
	}
	System.out.println(lhs);
    }

    public void usingHashMap(int a[]) {
	HashMap<Integer, Boolean> hm = new HashMap<>();
	for (int i = 0; i < a.length; i++) {
	    if (hm.get(a[i]) == null) {
		System.out.println(a[i]);
		hm.put(a[i], true);
	    }
	}
    }

    public static void main(String[] args) {
	int a[] = { 1, 1, 1, 2, 2, 5, 5, 6, 7, 8, 9, 3, 3 };
	RemoveDuplicates rd = new RemoveDuplicates();
	// int i = rd.removeDuplicates(a);
	// for (int j = 0; j < i; j++) {
	// System.out.println(a[j]);
	// }
//	rd.usingSet(a);
	rd.usingHashMap(a);
    }
}
