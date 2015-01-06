public class Queue {
	LinkedListNode first;
	LinkedListNode last;

	public void enqueue(Object item) {
		if (first == null) {
			last = new LinkedListNode((int) item);
			first = last;
		} else {
			last.next = new LinkedListNode((int) item);
			last = last.next;
		}
	}

	public Object dequeue() {
		if (first != null) {
			Object item = first.data;
			first = first.next;
			return item;
		}
		return null;
	}

}
