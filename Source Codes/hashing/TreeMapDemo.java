package hashing;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    static TreeMap<Integer, String> tm;

    void create() {
	tm = new TreeMap<Integer, String>();
	System.out.println("TreeMap Created Successfully");
    }

    void insert() {
	tm.put(1, "Anurag");
	tm.put(2, "Chauhan");
	tm.put(3, "CSE");
	System.out.println("Inserted Successfully");
    }

    void search(int key) {
	if (tm.containsKey(key)) {
	    System.out.println(tm.get(key));
	} else {
	    System.out.println(tm.containsKey(key));
	}
    }

    void search(String value) {
	System.out.println(tm.containsValue(value));
    }

    void traverse() {
	for (Map.Entry<Integer, String> me : tm.entrySet()) {
	    System.out.println(me.getKey() + ": " + me.getValue());
	}
    }

    public static void main(String[] args) {
	TreeMapDemo tmd = new TreeMapDemo();
	tmd.create();
	tmd.insert();
	tmd.search(2);
	tmd.search(6);
	tmd.search("CSE");
	tmd.traverse();
    }
}
