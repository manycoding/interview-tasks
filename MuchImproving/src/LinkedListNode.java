public class LinkedListNode {
	LinkedListNode next = null;
	int data;
	Boolean visited;

	public LinkedListNode(int data) {
		this.data = data;
		visited = false;
	}
	


	public void appendToTail(int data) {
		LinkedListNode endNode = new LinkedListNode(data);
		LinkedListNode node = this;
		while (node.next != null) {
			node = node.next;
		}
		node.next = endNode;
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
}
