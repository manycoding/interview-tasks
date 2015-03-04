package tasks_Arrays_Strings;

import tests.Tests;

public class Main {

	public static void main(String[] args) {

		int[][] matrix = Tests.generateMatrix(0, 0);
		Tests.printMatrix(matrix);

		MatrixReset.setZeros(matrix);
		Tests.printMatrix(matrix);

		System.out.println(StringsRotationChecker.isRotation("test", "stte"));
	}
}
