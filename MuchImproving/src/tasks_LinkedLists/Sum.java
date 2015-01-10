package tasks_LinkedLists;

import data_structures.LinkedListNode;

public abstract class Sum {
	
//	You have two numbers represented by a linked list, where each node contains a
//	single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
//	of the list. Write a function that adds the two numbers and returns the sum as a
//	linked list.

	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2,
			int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null;

		LinkedListNode result = new LinkedListNode(carry);
		int value = carry;
		if (l1 != null)
			value += l1.data;
		if (l2 != null)
			value += l2.data;

		result.data = value % 10;

		if (l1 != null || l2 != null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next,
					l2 == null ? null : l2.next, value >= 10 ? 1 : 0);

			result.next = more;
		}

		return result;
	}

	
//	FOLLOW UP
//	Suppose the digits are stored in forward order. Repeat the above problem.
}
