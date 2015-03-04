package tasks_Arrays_Strings;

public abstract class MatrixRotation {
	public static int[][] rotateMatrix(int[][] matrix, int n) {
		if (matrix == null || n == 0)
			return null;

		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;

			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i];

				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}

		return matrix;
	}

}
