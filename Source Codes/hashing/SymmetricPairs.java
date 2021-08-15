package hashing;

import java.util.HashMap;

public class SymmetricPairs {
    static void findPairs(int a[][]) {
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	int temp = 0;
	for (int i = 0; i < a.length; i++) {
	    int first = a[i][0];
	    int second = a[i][1];
	    Integer val = hm.get(second);
	    if (val != null && val == first) {
		System.out.println("{" + first + "," + second + "} And {" + second + "," + first + "}");
		temp++;
	    } else {
		hm.put(first, second);
	    }
	}
	if (temp == 0) {
	    System.out.println("No Pair Found");
	}
    }

    public static void main(String[] args) {
	int a[][] = { { 1, 4 }, { 2, 4 }, { 4, 2 }, { 5, 6 } };
	findPairs(a);
    }
}
