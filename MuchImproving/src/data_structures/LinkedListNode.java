package data_structures;

public class LinkedListNode {
	public LinkedListNode next = null;
	public int data;

	public LinkedListNode(int data) {
		this.data = data;
	}

	public LinkedListNode getNth(int position) {
		if (position < 1 || this.next == null)
			return null;
		else if (position == 1)
			return this;
		else
			return this.getNth(position--);
	}

	public void appendToTail(int data) {
		LinkedListNode endNode = new LinkedListNode(data);
		LinkedListNode node = this;
		while (node.next != null) {
			node = node.next;
		}
		node.next = endNode;
	}

	public static boolean deleteNode(LinkedListNode node) {
		if (node == null || node.next == null)
			return false;

		LinkedListNode next = node.next;
		node.data = next.data;
		node.next = next.next;
		return true;
	}

	public LinkedListNode deleteNode(LinkedListNode headNode, int data) {
		LinkedListNode node = headNode;

		if (node.data == data)
			return headNode.next;

		while (node.next != null) {
			if (node.next.data == data) {
				node.next = node.next.next;
				return headNode;
			}
			node = node.next;
		}
		return headNode;
	}

	public static void deleteDupicates(LinkedListNode current) {
		if (current == null)
			return;

		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			current = current.next;
		}
	}

	public static int nthToLast(LinkedListNode head, int k) {
		if (head == null)
			return 0;

		int i = nthToLast(head.next, k) + 1;
		if (i == k)
			System.out.println(head.data);
		return i;
	}

	// Write code to partition a linked list around a value x, such that all
	// nodes less than x
	// come before all nodes greater than or equal to x.
	public LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeX = null;
		LinkedListNode afterX = null;

		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				node.next = beforeX;
				beforeX = node;
			} else {
				node.next = afterX;
				afterX = node;
			}
			node = next;
		}

		if (beforeX == null)
			return afterX;

		LinkedListNode head = beforeX;
		while (beforeX.next != null)
			beforeX = beforeX.next;
		beforeX.next = afterX;

		return head;
	}
}
