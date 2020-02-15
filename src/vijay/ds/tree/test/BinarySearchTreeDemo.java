package vijay.ds.tree.test;

public class BinarySearchTreeDemo {
  
  /**
   *              15
   *          12      18
   *        9   13  17  20
   * @param args
   */
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(15);
    tree.insert(12);
    tree.insert(18);
    tree.insert(9);
    tree.insert(13);
    tree.insert(17);
    tree.insert(20);
    System.out.println("you are searching for  : " + tree.search(20).data);
    tree.BFSTraverse();
    //    System.out.println("Preorder");
    //    tree.preOrder();
    //    System.out.println("Inorder");
    //    tree.inorder();
    //    System.out.println("Postorder");
    //    tree.postOrder();
    System.out.println("Deleting  from tree " + 18);
    tree.delete(18);
    tree.BFSTraverse();
  }
}


class BinarySearchTree {
  BNode root;
  
  public void BFSTraverse() {
    int height = getTreeHeight(root);
    for(int i = 0; i < height; i++) {
      print(root, i);
    }
  }
  
  private void print(BNode root, int height) {
    if(null == root) {
      return;
    }
    if(height == 0) {
      System.out.println(root.data);
      return;
    }
    if(height > 0) {
      print(root.left, height - 1);
      print(root.right, height - 1);
    }
    
  }
  
  private int getTreeHeight(BNode root) {
    if(null == root) {
      return 0;
    }
    return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
  }
  
  public void preOrder() {
    preOrderTree(root);
  }
  
  private void preOrderTree(BNode root) {
    if(null != root) {
      System.out.println(root.data);
      inorderTree(root.left);
      inorderTree(root.right);
    }
  }
  
  public void inorder() {
    inorderTree(root);
  }
  
  private void inorderTree(BNode root) {
    if(null != root) {
      inorderTree(root.left);
      System.out.println(root.data);
      inorderTree(root.right);
    }
  }
  
  public void postOrder() {
    postOrderTree(root);
  }
  
  private void postOrderTree(BNode root) {
    if(null != root) {
      inorderTree(root.left);
      inorderTree(root.right);
      System.out.println(root.data);
    }
  }
  
  public BNode insert(int data) {
    return root = insertToTree(root, data);
  }
  
  public BNode search(int data) {
    return searchForTree(root, data);
  }
  
  private BNode searchForTree(BNode root, int data) {
    if(null == root || root.data == data) {
      return root;
    }
    if(data < root.data) {
      return searchForTree(root.left, data);
    }
    return searchForTree(root.right, data);
    
  }
  
  private BNode insertToTree(BNode root, int data) {
    
    if(null == root) {
      root = new BNode(data);
      return root;
    }
    
    if(data < root.data) {
      root.left = insertToTree(root.left, data);
    }
    else {
      root.right = insertToTree(root.right, data);
    }
    return root;
  }
  
  public void delete(int data) {
    root = deleteFromTree(root, data);
  }
  
  private BNode deleteFromTree(BNode root, int data) {
    if(null == root) {
      return null;
    }
    
    if(data < root.data) {
      root.left = deleteFromTree(root.left, data);
    }
    else if(data > root.data) {
      root.right = deleteFromTree(root.right, data);
    }
    else {
      if(null == root.left && null == root.right) {
        return null;
      }
      else if(null == root.left) {
        //        root.right = deleteFromTree(root.right, data);
        return root.right;
      }
      else if(null == root.right) {
        //        root.left = deleteFromTree(root.left, data);
        return root.left;
      }
      else {
        int min = minValue(root.right);
        root.data = min;
        root.right = deleteFromTree(root.right, min);
      }
    }
    return root;
  }
  
  private int minValue(BNode root) {
    
    int min = root.data;
    while(null != root.left) {
      min = root.left.data;
      root = root.left;
    }
    return min;
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
