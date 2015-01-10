package data_structures;

import tests.Tests;

public class Main {

	public static void main(String[] args) {
		LinkedListNode node = Tests.generateLinkedList(10, 10);
		Tests.printLinkedList(node);

		Tests.printLinkedList(node.partition(node, 5));

	}
}
