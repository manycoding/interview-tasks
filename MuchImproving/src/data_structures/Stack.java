package data_structures;

public class Stack {
	LinkedListNode top;

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
