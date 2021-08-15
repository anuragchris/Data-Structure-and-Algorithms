package hashing;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
	Map<String, Integer> hm = new HashMap<String, Integer>();
	hm.put("a", new Integer(100));
	hm.put("b", new Integer(200));
	hm.put("c", new Integer(300));
	for (Map.Entry<String, Integer> me : hm.entrySet()) {
	    System.out.print(me.getKey() + " : ");
	    System.out.println(me.getValue());
	}
	Map<String, Integer> hm2 = new HashMap<>();
	hm2.put("a", 100);
	hm2.put("b", 200);
	hm2.put("c", 300);
	System.out.println(hm2);
	// for (Map.Entry<String, Integer> me : hm.entrySet()) {
	// System.out.print(me.getKey() + " : ");
	// System.out.println(me.getValue());
	// }
	hm2.put("a", 400);
	System.out.println(hm2);
	hm2.remove("b");
	System.out.println(hm2);
	for (Map.Entry<String, Integer> me : hm2.entrySet()) {
	    String key = me.getKey();
	    int value = me.getValue();
	    System.out.println("Key" + " " + key + " " + "Value" + " " + value);
	}
    }
}
