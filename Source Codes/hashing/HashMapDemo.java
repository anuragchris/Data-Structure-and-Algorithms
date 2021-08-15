package hashing;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
	HashMap<String, Integer> hm = new HashMap<>(10, 0.75f);
	hm.put("Anurag", 100);
	hm.put("Chauhan", 200);
	hm.put("Valorant", 300);
	System.out.println("Size: " + hm.size());
	System.out.println(hm);
	if (hm.containsKey("Anurag")) {
	    int value = hm.get("Anurag");
	    System.out.println("Value of Anurag : " + value);
	}
	for (Map.Entry<String, Integer> e : hm.entrySet()) {
	    System.out.println(e.getKey() + ": " + e.getValue());
	}
	hm.computeIfAbsent("Jett", k -> 500);
	System.out.println(hm);
	hm.computeIfPresent("Jett", (key, val) -> 600);
	System.out.println(hm);

    }
}
