package vijay.ds.tree.test;

public class DepthFirstSearchDemo {
  
  public static void main(String[] args) {
    DepthFirstSearch bfs = new DepthFirstSearch();
    bfs.preOrder();
    bfs.inOrder();
    bfs.postOrder();
  }
}


class DepthFirstSearch {
  BNode root;
  
  public DepthFirstSearch() {
    root = new BNode(1);
    root.left = new BNode(2);
    root.right = new BNode(3);
    root.left.left = new BNode(4);
    root.left.right = new BNode(5);
    root.right.left = new BNode(6);
    root.right.right = new BNode(7);
  }
  
  public void preOrder() {
    System.out.println("Preorder");
    pre(root);
  }
  
  private void pre(BNode root) {
    if(null != root) {
      System.out.println(root.data);
      pre(root.left);
      pre(root.right);
    }
  }
  
  public void inOrder() {
    System.out.println("Inorder");
    in(root);
  }
  
  private void in(BNode root) {
    if(null != root) {
      pre(root.left);
      System.out.println(root.data);
      pre(root.right);
    }
  }
  
  public void postOrder() {
    System.out.println("Postorder");
    post(root);
  }
  
  private void post(BNode root) {
    if(null != root) {
      pre(root.left);
      pre(root.right);
      System.out.println(root.data);
    }
  }
  
  static class BNode {
    int   data;
    BNode left, right;
    
    public BNode(int data) {
      this.data = data;
      this.left = this.right = null;
    }
    
    public int getData() {
      return data;
    }
    
    public void setData(int data) {
      this.data = data;
    }
    
    public BNode getLeft() {
      return left;
    }
    
    public void setLeft(BNode left) {
      this.left = left;
    }
    
    public BNode getRight() {
      return right;
    }
    
    public void setRight(BNode right) {
      this.right = right;
    }
    
  }
}

