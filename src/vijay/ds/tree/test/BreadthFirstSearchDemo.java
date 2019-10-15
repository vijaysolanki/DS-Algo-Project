package vijay.ds.tree.test;

import vijay.ds.tree.test.BinarySearchTree.BNode;

public class BreadthFirstSearchDemo {
  
  public static void main(String[] args) {
    BreadthFirstSearch bfs = new BreadthFirstSearch();
    bfs.traverse();
  }
}


class BreadthFirstSearch {
  BNode root;
  
  public BreadthFirstSearch() {
    root = new BNode(1);
    root.left = new BNode(2);
    root.right = new BNode(3);
    //    root.left.left = new BNode(4);
    root.left.right = new BNode(5);
    root.right.left = new BNode(6);
    //    root.right.right = new BNode(7);
  }
  
  public void traverse() {
    int hLevel = getHighestLevel(root);
    for(int i = 0; i < hLevel; i++) {
      print(root, i);
    }
  }
  
  private void print(BNode root, int level) {
    if(null == root) {
      return;
    }
    if(level == 0) {
      System.out.println(root.data);
      return;
    }
    if(level > 0) {
      print(root.left, level - 1);
      print(root.right, level - 1);
    }
  }
  
  private int getHighestLevel(BNode root) {
    
    if(null == root) {
      return 0;
    }
    int highestLevel = getHighestLevel(root.left);
    int highestLevel2 = getHighestLevel(root.right);
    int max = Math.max(highestLevel, highestLevel2);
    int i = 1 + max;
    return i;
    
  }
}
