package data_structures;

public class BinaryTree {
	BinaryTreeNode root;
	int size;

	public class BinaryTreeNode {
		int item;
		BinaryTreeNode parent;
		BinaryTreeNode left;
		BinaryTreeNode right;
		boolean visited;

		public boolean isVisited() {
			return visited;
		}

		public void inorder() {
			if (left != null)
				left.inorder();
			this.visited = true;
			if (right != null)
				right.inorder();
		}

		public Object find(int k) {
			BinaryTreeNode node = root;
			while (node != null) {
				if (k < item)
					node = node.left;
				else if (k > item)
					node = node.right;
				else
					return node.item;
			}
			return null;
		}

	}
}
