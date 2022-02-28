// Link For Problem : https://leetcode.com/problems/lru-cache/

package hashing;

import java.util.LinkedHashMap;

class LRUCache {
	private LinkedHashMap<Integer, Integer> lhm;
	private int capacity;

	public LRUCache(int capacity) {
		this.lhm = new LinkedHashMap<>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!lhm.containsKey(key))
			return -1;
		int val = lhm.get(key);
		put(key, val);
		return val;
	}

	public void put(int key, int value) {
		if (!lhm.containsKey(key) && lhm.size() == this.capacity) {
			lhm.remove(lhm.keySet().iterator().next());
		}
		lhm.remove(key);
		lhm.put(key, value);
	}
}

public class LRU_Cache {

}
