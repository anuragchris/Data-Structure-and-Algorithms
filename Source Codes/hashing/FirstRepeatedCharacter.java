package hashing;

import java.util.HashMap;

public class FirstRepeatedCharacter {
    public char usingHashMap(String s) {
	char a[] = s.toCharArray();
	HashMap<Character, Boolean> hm = new HashMap<Character, Boolean>();
	for (int i = 0; i < a.length; i++) {
	    if (hm.containsKey(a[i])) {
		return a[i];
	    } else {
		hm.put(a[i], true);
	    }
	}
	return new Integer(-1).toString().charAt(0);
    }

    public static void main(String[] args) {
	FirstRepeatedCharacter frc = new FirstRepeatedCharacter();
	String str = "geeksforgeeks";
	System.out.println(frc.usingHashMap(str));
    }
}
