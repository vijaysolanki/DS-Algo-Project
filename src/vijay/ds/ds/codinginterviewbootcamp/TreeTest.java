package vijay.ds.ds.codinginterviewbootcamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeTest {

  static class Node<T> {
    T             data;
    List<Node<T>> childrens;
    
    Node(T data) {
      this.data = data;
      childrens = new ArrayList<>();
    }
    
    public void add(Node<T> node) {
      childrens.add(node);
    }
    public void add(T node) {
      Node<T> newNode = new Node<>(node);
      childrens.add(newNode);
    }
    
    public void remove(T node) {
      //      return childrens.removeIf((Node<T> n) -> n.data.equals(node));
      for(Iterator<Node<T>> it = childrens.iterator(); it.hasNext();) {
        if(it.next().data.equals(node)) {
          it.remove();
        }
      }
    }
  }
  
  static class Tree<K, T> {
    Node<T> root;
    
    Tree(Node<T> root) {
      this.root = root;
    }
    
    public void BF_Traversal() {
      List<Node<T>> list = new ArrayList<>();
      list.add(root);
      
      while(!list.isEmpty()) {
        Node<T> remove = list.remove(0);
        if(null != remove) {
          System.out.println(remove.data);
          list.addAll(remove.childrens);
        }
      }
    }
    
    public void DF_Traversal() {
      List<Node<T>> list = new ArrayList<>();
      list.add(root);
      
      while(!list.isEmpty()) {
        Node<T> remove = list.remove(0);
        if(null != remove) {
          System.out.println(remove.data);
          list.addAll(0, remove.childrens);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    Node<String> parent = new Node<>("Parent");
    
    Node<String> child1 = new Node<>("child-1");
    child1.add("1 child of 1");
    child1.add("2 child of 1");
    child1.add("3 child of 1");
    
    Node<String> child2 = new Node<>("child-2");
    Node<String> ch3 = new Node<>("1 child of 2");
    Node<String> ch4 = new Node<>("2 child of 2");
    child2.add("1 child of 2");
    child2.add("2 child of 2");
    
    parent.add(child1);
    parent.add(child2);
    
    Tree<Node, String> tree = new Tree<>(parent);
    tree.BF_Traversal();
    System.out.println("====================================");
    tree.DF_Traversal();
  }
}
