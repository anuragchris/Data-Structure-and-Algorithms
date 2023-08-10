//Link For Problem: https://leetcode.com/problems/design-hashmap/

package hashing;

class Node {
	public int key;
	public int value;

	public Node next;

	public Node(int key, int value, Node next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
}

public class DesignHashMap {
	private Node elements[];
	private int capacity;
	private int size;

	public DesignHashMap() {
		this.size = 0;
		this.capacity = 10000;

		this.elements = new Node[this.capacity];

		for (int i = 0; i < this.capacity; i++)
			this.elements[i] = null;
	}

	private int hash(int key) {
		if (key < 0)
			return key * (-1) & this.capacity;

		return key % this.capacity;
	}

	public void put(int key, int value) {
		int index = this.hash(key);
		Node current = this.elements[index];

		while (current != null) {
			if (current.key == key) {
				current.value = value;
				return;
			}

			current = current.next;
		}

		Node node = new Node(key, value, this.elements[index]);

		this.elements[index] = node;
		this.size += 1;
	}

	public int get(int key) {
		int index = this.hash(key);

		Node current = this.elements[index];

		while (current != null) {

			if (current.key == key)
				return current.value;

			current = current.next;
		}

		return -1;
	}

	public void remove(int key) {
		int index = this.hash(key);

		Node prev = this.elements[index];
		Node current = this.elements[index];

		while (current != null) {

			if (current.key == key) {

				if (current == this.elements[index])
					this.elements[index] = this.elements[index].next;
				else
					prev.next = current.next;

				this.size -= 1;

				return;
			}

			prev = current;
			current = current.next;
		}
	}
}
