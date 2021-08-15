//Link For Problem : https://leetcode.com/problems/clone-graph/

package graphProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}

	static Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Queue<Node> q = new LinkedList<Node>();
		HashMap<Integer, Node> h = new HashMap<Integer, Node>();
		q.add(node);
		h.put(node.val, new Node(node.val));
		while (!q.isEmpty()) {
			Node t = q.poll();
			for (Node c : t.neighbors) {
				if (!h.containsKey(c.val)) {
					h.put(c.val, new Node(c.val));
					q.add(c);
				}
				h.get(t.val).neighbors.add(h.get(c.val));
			}
		}
		return h.get(node.val);
	}
}
