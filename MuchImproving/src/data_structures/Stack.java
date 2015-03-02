package data_structures;

public class Stack {
	public int size = 0;
	public LinkedListNode top;
	public LinkedListNode bottom;

	Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	void push(Object item) {
		LinkedListNode newNode = new LinkedListNode((int) item);
		newNode.next = top;
		top = newNode;
	}

	Object peek() {
		return top.data;
	}

}
