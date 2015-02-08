package tasks_LinkedLists;

import data_structures.LinkedListNode;
import tests.Tests;

public class Tester {

	public static void main(String[] args) {
		LinkedListNode l1 = Tests.generateLinkedList(3, 10);
		LinkedListNode l2 = Tests.generateLinkedList(3, 10);
		
		Tests.printLinkedList(l1);
		Tests.printLinkedList(l2);
		
		Tests.printLinkedList(Sum.addLists(l1, l2, 0));
		System.out.println();
		
		LinkedListNode l3 = Tests.generateLinkedList(5, 3);
		Tests.printLinkedList(l3);
		System.out.println(PalindromeFinder.isPalindrome(l3,5));

	}

}
