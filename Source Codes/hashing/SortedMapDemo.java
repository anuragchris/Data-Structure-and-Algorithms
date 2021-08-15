package hashing;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
	SortedMap<Integer, String> sm = new TreeMap<Integer, String>();
	sm.put(1, "Anurag");
	sm.put(3, "Chauhan");
	sm.put(2, "CSE");
	Set s = sm.entrySet();
	Iterator i = s.iterator();
	while (i.hasNext()) {
	    Map.Entry m = (Map.Entry) i.next();
	    int key = (int) m.getKey();
	    String value = (String) m.getValue();
	    System.out.println(key + ": " + value);
	}
	for (Map.Entry<Integer, String> me : sm.entrySet()) {
	    System.out.println(me.getKey() + ": " + me.getValue());
	}
    }
}
