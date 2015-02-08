package tasks_LinkedLists;

import data_structures.LinkedListNode;

//2.6 Given a circular linked list, implement an algorithm which returns the node at the
//beginning of the loop.

public class LoopFinder {
	public static LinkedListNode findBeggining(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}

		if (fast == null || fast.next == null)
			return null;

		slow = head;

		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast;
	}

}
