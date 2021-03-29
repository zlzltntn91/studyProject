package hash;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class ChainHash<K, V> {

	private int size;
	private Node<K, V>[] table;

	public ChainHash(int size) {
		try {
			this.size = size;
			this.table = new Node[size];
		} catch (OutOfMemoryError e) {
			this.size = 0;
			this.table = new Node[size];
		}
	}

	public Node<K, V> search(K key) {
		int hashValue = hashValue(key);
		Node<K, V> p = table[hashValue];
		while (p != null) {
			if (p.getKey().equals(key)) {
				return p;
			}
			p = p.next;
		}
		return null;
	}

	public int add(K key, V value) {
		int hashValue = hashValue(key);
		Node p = table[hashValue];

		while (p != null) {
			if (p.getKey().equals(key)) {
				return 1;
			}
			p = p.next;
		}
		Node<K, V> thisNode = new Node<>(key, value, table[hashValue]);
		table[hashValue] = thisNode;
		return 0;
	}

	public int hashValue(K key) {
		return key.hashCode() % size;
	}

	public int remove(K key) {
		int removeFlag = 0;
		int hashValue = hashValue(key);
		Node currNode = table[hashValue];
		Node prevNode = null;

		while (currNode != null) {
			if (currNode.getKey().equals(key)) {
				removeFlag = 1;
				if (prevNode == null) {
					table[hashValue] = currNode.next;
				} else {
					prevNode.next = currNode.next;
				}
				return removeFlag;
			}
			prevNode = currNode;
			currNode = currNode.next;
		}
		return removeFlag;
	}

	public void dump() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < table.length; i++) {
			sb.append(" [").append(i).append(" ]");
			if (table[i] != null) {
				sb.append(table[i].getKey()).append(" : ").append(table[i].getValue());
				Node<K, V> nextNode = table[i].next;
				while(nextNode != null) {
					sb.append(" // ").append(nextNode);
					nextNode = nextNode.next;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	@ToString
	class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> next;

		Node(K key, V value, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		K getKey() {
			return key;
		}

		V getValue() {
			return value;
		}

		public int hashCode() {
			return key.hashCode();
		}
	}


}

