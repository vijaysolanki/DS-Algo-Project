package vijay.ds;

public class BinarySearchTree {
	public static void main(String[] args) {
			BinaryTree tree = new BinaryTree();
			tree.insert(110);
			tree.insert(112);
			tree.insert(122);
			tree.insert(31);
			tree.insert(14);
			tree.insert(51);
			tree.insert(9);
			tree.insert(12);
			tree.insert(35);
			tree.insert(45);
			BinaryTree.Node search = tree.search(51);
			System.out.println("Searched : " + search.data);
			tree.BFS_Traversal();
			System.out.println("Deleting Node:  " + 31);
			 tree.delete(31);
			tree.BFS_Traversal();
			tree.inorder();
	}

}

class BinaryTree {
	Node root;

	public void inorder() {
		System.out.println("************Inorder****************");
		inOrder_Traversal(root);
		
	}

	public void inOrder_Traversal(Node root) {
		if(null == root)
		{
			return;
		}
		inOrder_Traversal(root.left);
		System.out.println(root.data);
		inOrder_Traversal(root.right);
		
	}

	public void BFS_Traversal()
	{
		int treeLevel = getTreeLevel(root);
		for (int i = 0; i < treeLevel; i++) {
			BFS(root,i);
			System.out.println();
		}
	}
	
	private void BFS(Node root, int level) {
		
		if(null == root){
			return;
		}
		if( level == 0)
		{
			System.out.print(root.data + " ");
			return;
		}
		
		if(level > 0)
		{
			BFS(root.left, level-1);
			BFS(root.right, level -1);
		}
	}

	private int getTreeLevel(Node root) {
		
		if(null == root)
		{
			return 0;
		}
		
		return  1 + Math.max(getTreeLevel(root.left), getTreeLevel(root.right));
	}

	public void insert(int data) {
		 root = insertHelper(root, data);

	}

	private Node insertHelper(Node root, int data) {
		if (null == root) {
			root = new Node(data);
			return root;
		}

		if (data < root.data) {
			root.left = insertHelper(root.left, data);
		} else {
			root.right = insertHelper(root.right, data);
		}
		return root;
	}

	public Node search(int data)
	{
		return searchHelper(root, data);
	}
	
	private Node searchHelper(Node root, int data) {
		
		if(null == root || root.data == data)
		{
			return root;
		}
		
		if(data < root.data)
		{
			return searchHelper(root.left, data);
		}
		return searchHelper(root.right, data);
	}

	
	public void delete(int data)
	{
		 root= deleteHelper(root, data);
	}
	
	private Node deleteHelper(Node root, int data) {
		
		if(null == root )
		{
			return null;
		}

		if(data < root.data)
		{
			root.left = deleteHelper(root.left, data);
		}
		else if (data > root.data)
		{
			root.right = deleteHelper(root.right, data);
		}
		else {
			
			if(null == root.left && null == root.right )
			{
				return null;
			}
			else if(null == root.left)
			{
				return root.right;
			}
			else if(null == root.right)
			{
				return root.left;
			}
			else 
			{
				int min = findMin(root.right);
				root.data = min;
				root.right = deleteHelper(root.right, min);
			}
		}
		return root;
	}

	private int findMin(Node right) {
		int min = right.data;
		while(null != right.left)
		{
			right = right.left;
			min = right.data;
		}
		return min;
		
	}

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

}
