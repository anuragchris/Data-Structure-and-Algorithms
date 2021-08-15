package hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
	LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();
	lhm.put(1, "Anurag");
	lhm.put(2, "Chauhan");
	lhm.put(3, "CSE");
	System.out.println(lhm);
	System.out.println(lhm.get(1));
	System.out.println(lhm.size());
	System.out.println(lhm.containsValue("Anurag"));
	for (Map.Entry<Integer, String> me : lhm.entrySet()) {
	    System.out.println(me.getKey() + ": " + me.getValue());
	}
    }
}
