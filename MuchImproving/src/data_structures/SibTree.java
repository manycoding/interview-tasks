package data_structures;

public class SibTree {
	SibTreeNode root;
	int size;

	class SibTreeNode {
		Object item;
		SibTreeNode parent;
		SibTreeNode firstChild;
		SibTreeNode nextSibling;
		private boolean visited;

		public void preorder() {
			this.visited = true;
			if (firstChild != null)
				firstChild.preorder();
			if (nextSibling != null)
				nextSibling.preorder();
		}

		public void postorder() {
			if (firstChild != null)
				firstChild.postorder();
			this.visited = true;
			if (nextSibling != null)
				nextSibling.postorder();
		}

		public boolean isVisited() {
			return visited;
		}
	}

}
