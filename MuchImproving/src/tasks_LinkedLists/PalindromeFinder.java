package tasks_LinkedLists;

import java.util.Stack;
import data_structures.LinkedListNode;

//2.7 Implement a function to check if a linked list is a palindrome

public class PalindromeFinder {
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null)
			slow = slow.next;

		while (slow != null) {
			int top = stack.pop();

			if (top != slow.data)
				return false;

			slow = slow.next;
		}

		return true;
	}

	static class Result {
		public LinkedListNode node;
		public boolean result;

		Result(LinkedListNode node, boolean result) {
			this.node = node;
			this.result = result;
		}
	}

	private static Result isPalindromeRecurse(LinkedListNode head, int length) {
		if (head == null || length == 0)
			return new Result(null, true);
		else if (length == 1)
			return new Result(head.next, true);
		else if (length == 2)
			return new Result(head.next.next, head.data == head.next.data);

		Result res = isPalindromeRecurse(head.next, length - 2);
		if (!res.result || res.node == null) {
			return res;
		} else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}

	static boolean isPalindrome(LinkedListNode head, int size) {
		Result p = isPalindromeRecurse(head, size);
		return p.result;
	}
}