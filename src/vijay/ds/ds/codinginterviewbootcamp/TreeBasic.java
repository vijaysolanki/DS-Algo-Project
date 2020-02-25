package vijay.ds.ds.codinginterviewbootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TreeBasic {
  
  public static void main(String[] args) {
    TNode<String> parent = new TNode<>("Parent");
    
    TNode<String> child1 = new TNode<>("child-1");
    TNode<String> ch1 = new TNode<>("1 child of 1");
    TNode<String> ch2 = new TNode<>("2 child of 1");
    TNode<String> ch3rd = new TNode<>("3 child of 1");
    child1.childerns[0]= ch1;
    child1.childerns[1]= ch2;
    child1.childerns[2]= ch3rd;
    
    TNode<String> child2 = new TNode<>("child-2");
    TNode<String> ch3 = new TNode<>("1 child of 2");
    TNode<String> ch4 = new TNode<>("2 child of 2");
    child2.childerns[0]= ch3;
    child2.childerns[1]= ch4;
    
    
    parent.childerns[0] = child1;
    parent.childerns[1] = child2;
//    parent.add("child-1");
//    parent.add("child-2");
//    parent.add("child-3");
//    parent.add("child-4");
//    parent.print();
//    System.out.println("==========");
//    parent.remove("child-4");
//    parent.remove("child-1");
    parent.print();
    
    System.out.println("==============Breath First Traversal===========");
    Tree<TNode<String>, String> tree = new Tree<>();
    tree.root = parent;
    Consumer<TNode<String>> consumer = ( TNode<String> n ) -> n.data = n.data+".";
    tree.travel_BF(consumer);
    
    System.out.println("==============Depth First Traversal===========");
    Tree<TNode<String>, String> tree2 = new Tree<>();
    tree2.root = parent;
    Consumer<TNode<String>> consumer2 = ( TNode<String> n ) -> n.data = n.data+".";
    tree2.travel_DF(consumer2);
  }
  
  
}

class Tree<T,K>{
  TNode<K> root;
  
  Tree()
  {
    root = null;
  }
  
  public void travel_BF(Consumer<TNode<K>> operation)
  {
    List<TNode<K>> allElements = new ArrayList<>();
    allElements.add(root);
    
    while(!allElements.isEmpty())
    {
      //remove the first element 
      TNode<K> node = allElements.remove(0);
      if(null != node)
      {
        operation.accept(node);
        System.out.println(node.data);
        List<TNode<K>> childrens = Arrays.asList(node.childerns);
        //add all children's to end of list
        allElements.addAll(childrens); 
      }
     
    }
  }
  
  public void travel_DF(Consumer<TNode<K>> operation)
  {
    List<TNode<K>> list = new ArrayList<>();
    list.add(root);
    while(!list.isEmpty())
    {
      //remove the first element
      TNode<K> node = list.remove(0);
      if(null != node)
      {
        operation.accept(node);
        System.out.println(node.data);
        List<TNode<K>> childerns = Arrays.asList(node.childerns);
        //add all children's to start of list
        list.addAll(0, childerns);
      }
     
    }
  }
}

class TNode<T> {
  public T          data;
  public TNode<T>[] childerns;
  
  TNode(T data) {
    this.data = data;
    childerns = new TNode[10];
  }
  
  public void add(T data) {
    int i = 0;
    while(null != childerns[i]) {
      i++;
    }
    childerns[i] = new TNode<T>(data);
  }

  /** remove ALL the elements matching data.
   * 
   * @param data
   */
  public void remove(T data)
  {
    remove(data, 0);
//    childerns = Stream.of(childerns).filter(n -> null != n && !n.data.equals(data)).collect(Collectors.toList()).toArray(new TNode[childerns.length]);
  }
  
  private void remove(T data, int i) {
    
    if(null == childerns[i]) {
      return;
    }
    
    while(null != childerns[i]) {
      if(data.equals(childerns[i].data)) {
        childerns[i] = childerns[i + 1];
        if(null != childerns[i])
        {
          remove(childerns[i].data, i+1);
        }
        return;
      }
      i++;
    }
  }
  
  public void print()
  {
    int i = 0;
    while(null != childerns[i])
    {
      System.out.println(childerns[i].data);
      i++;
    }
            
  }
}
