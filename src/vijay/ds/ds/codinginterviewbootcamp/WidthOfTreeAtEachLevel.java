package vijay.ds.ds.codinginterviewbootcamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Give the root node of a tree return an array where each element is the width of tree at each level.
 * @author ashokv
 *
 *
 *      0
 *    1 2 3
 *    4   5
 *    
 *   -- ans:[1, 3, 5]
 */
public class WidthOfTreeAtEachLevel<T> {
  
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(0);
    Node<Integer> c1 = new Node<>(1);
    c1.child.add(new Node<Integer>(4));
    Node<Integer> c2 = new Node<>(2);
    Node<Integer> c3 = new Node<>(3);
    c3.child.add(new Node<Integer>(5));
    root.child.add(c1);
    root.child.add(c2);
    root.child.add(c3);
    
    WidthOfTreeAtEachLevel widthOfTreeAtEachLevel = new WidthOfTreeAtEachLevel();
    List elementsAtEachLevel = widthOfTreeAtEachLevel.elementsAtEachLevel(root);
    System.out.println(elementsAtEachLevel);
    
  }
  
  public List<Integer> elementsAtEachLevel(Node<T> root) {
    List<Integer> counter = new ArrayList<>();
    List<Object> list = new ArrayList<>();
    
    /**
     * add root element and stopper marker
     */
    String stopper = "s";
    list.add(root);
    list.add(stopper);
    
    /**
     * initialize with 0
     */
    counter.add(0);
    
    while(list.size() > 1) {
      //remove first element
      Object remove = list.remove(0);
      if(remove instanceof Node) {
        Node node = (Node) remove;
        System.out.println(node.data);
        list.addAll(node.child);
        Integer c = counter.remove(counter.size() - 1);
        counter.add(c.intValue() + 1);
      }
      else {
        list.add(stopper);
        counter.add(0);
      }
    }
    return counter;
  }
  
  static class Node<T> {
    T             data;
    List<Node<T>> child;
    
    Node(T data) {
      this.data = data;
      child = new ArrayList<Node<T>>();
    }
    
    public void add(Node<T> node) {
      child.add(node);
    }
    
    public void remove(T node) {
      //      child.removeIf(n-> n.data.equals(node));
      for(Iterator<Node<T>> it = child.iterator(); it.hasNext();) {
        Node<T> n = it.next();
        if(n.data.equals(node)) {
          it.remove();
        }
      }
    }
  }
  
}


