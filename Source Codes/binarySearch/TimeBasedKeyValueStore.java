//Link For Problem: https://leetcode.com/problems/time-based-key-value-store/

package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

	class TimeMap {

		private Map<String, TreeMap<Integer, String>> map;

		public TimeMap() {
			this.map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			if (!map.containsKey(key))
				map.put(key, new TreeMap<>());

			map.get(key).put(timestamp, value);
		}

		public String get(String key, int timestamp) {
			var treeMap = map.get(key);

			if (treeMap == null)
				return "";

			Integer floor = treeMap.floorKey(timestamp);

			if (floor == null)
				return "";

			return treeMap.get(floor);
		}
	}

	class BinarySearch {

		class Node {
			private int timestamp;
			private String value;

			public Node(int timestamp, String value) {
				this.timestamp = timestamp;
				this.value = value;
			}
		}

		Map<String, List<Node>> map;

		public BinarySearch() {
			this.map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(new Node(timestamp, value));
		}

		public String get(String key, int timestamp) {
			List<Node> list = map.get(key);

			if (list == null)
				return "";

			int left = 0, right = list.size() - 1;

			while (left + 1 < right) {
				int mid = left + (right - left) / 2;

				var node = list.get(mid);

				if (node.timestamp == timestamp)
					return node.value;

				else if (node.timestamp < timestamp)
					left = mid;

				else
					right = mid;
			}

			if (list.get(right).timestamp <= timestamp)
				return list.get(right).value;

			else if (list.get(left).timestamp <= timestamp)
				return list.get(left).value;

			else
				return "";
		}
	}
}