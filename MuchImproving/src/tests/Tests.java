package tests;

import java.util.Random;

import data_structures.LinkedListNode;

public abstract class Tests {
	public static int[][] generateMatrix(int rows, int columns) {
		if (rows == 0 || columns == 0)
			return null;

		int[][] matrix = new int[rows][columns];
		Random random = new Random();

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				matrix[i][j] = random.nextInt(11);

		return matrix;
	}

	public static void printMatrix(int[][] matrix) {
		if (matrix == null)
			return;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + "  ");
			System.out.println("");
		}
		System.out.println("");
	}

	public static LinkedListNode generateLinkedList(int size, int upperBound) {
		if (size == 0 || upperBound == 0)
			return null;

		Random random = new Random();
		LinkedListNode head = new LinkedListNode(random.nextInt(upperBound));
		LinkedListNode previous = head;

		for (int i = 1; i < size; i++) {
			LinkedListNode node = new LinkedListNode(random.nextInt(upperBound));
			previous.next = node;
			previous = node;
		}
		return head;
	}

	public static void printLinkedListNode(LinkedListNode node) {
		if (node == null)
			return;
		while (node != null) {
			System.out.print(node.data + "\t");
			node = node.next;
		}
		System.out.println("");
	}
}
