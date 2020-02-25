package vijay.ds.ds.codinginterviewbootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySeachTree {
  
  public static void main(String[] args) {
    
    /*TNode<Integer> parent = new TNode<>(10);
    
    TNode<Integer> child1 = new TNode<>(0);
    TNode<Integer> ch1 = new TNode<>(-1);
    TNode<Integer> ch2 = new TNode<>(4);
    // invalid entry 15
    ch2.childerns[0] = new TNode<>(15);
    child1.childerns[0] = ch1;
    child1.childerns[1] = ch2;
    
    TNode<Integer> child2 = new TNode<>(12);
    TNode<Integer> ch3 = new TNode<>(11);
    TNode<Integer> ch4 = new TNode<>(17);
    child2.childerns[0] = ch3;
    child2.childerns[1] = ch4;
    
    parent.childerns[0] = child1;
    parent.childerns[1] = child2;
    
    preOrder(parent);
    System.out.println("===================");
    System.out.println(validateBinarySearchTree(parent));*/
    
     BSTNode node = new BSTNode(10);
    node.insert(0);
    node.insert(12);
    node.insert(-1);
    node.insert(100);
    node.insert(4);
    node.insert(11);
    node.insert(20);
    node.insert(17);
    node.insert(99);
    travel_BS(node);
    System.out.println("============");
    boolean validateBinarySearchTree = validateBinarySearchTree(node);
    System.out.println(validateBinarySearchTree);
    
  }
  
 /* private static void preOrder(TNode<Integer> parent) {
    if(null != parent)
    {
     System.out.println(parent.data);
     preOrder(parent.childerns[0]);
     preOrder(parent.childerns[1]);
    }
  }

  public static boolean validateBinarySearchTree(TNode<Integer> node) {
    List<TNode<Integer>> list = new ArrayList<TNode<Integer>>();
    list.add(node);
    
    while(!list.isEmpty()) {
      
      TNode<Integer> removed = list.remove(0);
      
      if(null != removed) {
        if(null == removed.childerns[0] && null == removed.childerns[1]) {
          continue;
        }
        
        list.add(removed.childerns[0]);
        list.add(removed.childerns[1]);
        
        if(null != removed.childerns[0] && !(removed.childerns[0].data < removed.data)) {
          return false;
        }
        else if(null != removed.childerns[1] && !(removed.childerns[1].data > removed.data)) {
          return false;
        }
        
        /**
         * if we consider that each node will always have atleast 2 child nodes 
         */
        /*if(null == removed.left || null == removed.right)
        {
          return false;
        }
        
        list.add(removed.left);
        list.add(removed.right);
        
        if(! (removed.left.data < removed.data) || !(removed.right.data > removed.data) )
        {
          return false;
        }
      }
    }
    return true;
  }
  */
  
  public static boolean validateBinarySearchTree(BSTNode node) {
    List<BSTNode> list = new ArrayList<BSTNode>();
    list.add(node);
    
    while(!list.isEmpty()) {
      BSTNode removed = list.remove(0);
      
      if(null != removed) {
        if(null == removed.left && null == removed.right) {
          continue;
        }
        
        list.add(removed.left);
        list.add(removed.right);
        
        if(null != removed.left && !(removed.left.data < removed.data)) {
          return false;
        }
        else if(null != removed.right && !(removed.right.data > removed.data)) {
          return false;
        }
        
        /**
         * if we consider that each node will always have atleast 2 child nodes 
         */
        /*if(null == removed.left || null == removed.right)
        {
          return false;
        }
        
        list.add(removed.left);
        list.add(removed.right);
        
        if(! (removed.left.data < removed.data) || !(removed.right.data > removed.data) )
        {
          return false;
        }*/
      }
    }
    return true;
  }
  
  static public void travel_BS(BSTNode node) {
    List<BSTNode> list = new ArrayList<>();
    list.add(node);
    
    while(!list.isEmpty()) {
      BSTNode removed = list.remove(0);
      if(null != removed) {
        System.out.println(removed.data);
        list.add(removed.left);
        list.add(removed.right);
      }
    }
    
  }
}


class BSTNode {
  Integer data;
  BSTNode left;
  BSTNode right;
  
  public BSTNode(int data) {
    this.data = data;
    left = right = null;
  }

  public void insert(int data) {
    if(data < this.data && null != this.left) {
      this.left.insert(data);
    }
    else if(data < this.data) {
      this.left = new BSTNode(data);
    }
    else if(data > this.data && null != this.right) {
      this.right.insert(data);
    }
    else if(data > this.data) {
      this.right = new BSTNode(data);
    }
  }
  
  
  public BSTNode contains(int data) {
    if(this.data == data) {
      return this;
    }
    
    if(data < this.data && null != this.left) {
      return this.left.contains(data);
    }
    else if(data > this.data && null != this.right) {
      return this.right.contains(data);
    }
    
    return null;
  }
  

  public static void preorder(BSTNode node) {
    if(null != node) {
      System.out.println(node.data);
      preorder(node.left);
      preorder(node.right);
    }
  }
  
  /* public void insertHelper(int data)
  {
    insert(this,data);
  }
  public BSTNode insert(BSTNode root, int data)
  {
    if(null == root)
    {
      BSTNode newNode = new BSTNode(data);
      root = newNode;
      return root;
    }
    
    if(data < root.data )
    {
      return root.left = insert(root.left, data);
    }
    else 
    {
      return root.right = insert(root.right, data);
    }
  }*/
  

}
