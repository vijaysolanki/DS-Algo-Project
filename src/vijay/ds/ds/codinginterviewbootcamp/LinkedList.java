package vijay.ds.ds.codinginterviewbootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Check the InsertFirst method carefully and head of the list if moving every time new item is added.
 * 
 * @author ashokv
 *
 * @param <T>
 */
public class LinkedList<T> {
  
  Node<T> head;
  
  public LinkedList() {
    this.head = null;
  }
  
  public void insertFirst(T data) {
    Node<T> newNode = new Node<>(data);
    if(null == head) {
      head = newNode;
    }
    else {
      newNode.next = head;
      head = newNode;
    }
  }
  
  public int size() {
    if(null == head)
    {
      return 0;
    }
    int count = 0;
    Node<T> temp = head;
    while(null != temp) {
      count++;
      temp = temp.next;
    }
    return count;
  }
  
  public void print() {
    Node<T> temp = head;
    while(null != temp) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }
  
  public T getFirst()
  {
    return head.data;
  }
  
  
  public T getLast()
  {
    Node<T> temp = head;
    if(null == temp)
    {
      return null;
    }
    
    while(null != temp.next)
    {
      temp = temp.next;
    }
    return temp.data;
  }
  
  public void clear()
  {
    //just make the head null and now we dont have any reference to any node which mean they are clear for us.
    head = null;
  }
  
  public T getValue(Node<T> node)
  {
    if(null != node){
      return node.data;
    }
    return null;
  }
  
  public T removeFirst()
  {
    if(null != head)
    {
      T val = head.data;
      Node<T> temp = head.next;
      head = temp;
      return val;
    }
    return null;
  }
  
  public void insertLast(T data)
  {
    Node<T> newNode = new Node<>(data);
    if(null == head)
    {
      head = newNode;
      return;
    }
    
    Node<T> temp = head;
    while(null != temp.next)
    {
      temp = temp.next;
    }
    temp.next = newNode;
    
  }
  
  public T removeLast(){

    if(null != head)
    {
      if(null == head.next )
      {
        T value = head.data;
        head = null;
        return value;
      }
      
      Node<T> temp = head;
      Node<T> prev = head;
      while(null != temp.next)
      {
        prev = temp;
        temp = temp.next;
      }
      prev.next = null;
      return temp.data;
    }
    return null;
  }
  
  public Node<T> removeAt(int index)
  {
    int count = 1;
    Node<T> temp = head;
    Node<T> prev = head;
    if(null == head)
    {
      head = null;
      return temp; 
    }
    
    if(index == count)
    {
      head = head.next;
      return temp;
    }
    
   
   /* Node<T> nodeAtIndex = getNodeAtIndex(index -1);
    if(null != nodeAtIndex && null != nodeAtIndex.next)
    {
      Node<T> toBeRemoved = nodeAtIndex.next;
        nodeAtIndex.next = toBeRemoved.next ;
      return toBeRemoved;
    }
    return null;*/
    
    while(null != temp )
    {
      if(count == index)
      {
        prev.next=  temp.next;
        return temp;
      }
      
      prev = temp;
      temp = temp.next;
      count++;
    }
    return null;
    
    
  }
  
  public void insertAt(T value, int index)
  {
    if(null != head )
    {
      int count = 1;
      Node<T> newNode = new Node<>(value);
      if(index <= count)
      {
        newNode.next = head;
        head = newNode;
        return;
      }
      
      Node<T> temp = head;
      Node<T> prev= head;
      while(count < index && null != temp)
      {
        prev = temp;
        temp = temp.next;
        count++;
      }
      
      prev.next = newNode;
      newNode.next = temp;
      return;
      
    }
    
    head = new Node<>(value);
    
  }
  
  public Node<T> getNodeAtIndex(int index)
  {
    
    Node<T> temp = head;
    //head is already at 0 index and we are already pointing to head.
    int count = 1;
    while(count < index && temp !=null)
    {
      temp = temp.next;
      count++;
    }
    if(null == temp)
    {
      throw new IndexOutOfBoundsException("Index is outside of list range");
    }
    return temp;
  }
  
  public void forEach(Consumer<Node<T>> function)
  {
    Node<T> temp = head;
    while(null !=temp)
    {
      function.accept(temp);
      temp = temp.next;
    }
  }
  
  public void forOfLoop(String value)
  {
    Node<T> temp = head;
    while(null !=temp)
    {
      temp.data = (T) (temp.data + value);
      temp = temp.next;
    }
  }
  
  public static void main(String... strings) {
    LinkedList<String> list = new LinkedList<String>();
    list.insertFirst("a");
//    System.out.println("size : " + list.size());
//    list.print();
    list.insertFirst("b");
    list.insertFirst("c");
    list.insertFirst("d");
    System.out.println("size : " + list.size());
    list.print();
    /*System.out.println(list.getNodeAtIndex(1));
    System.out.println(list.getNodeAtIndex(2));
    System.out.println(list.getNodeAtIndex(3));
    System.out.println(list.getNodeAtIndex(4));*/
    System.out.println("==============");
//    System.out.println("Removed :" + list.getValue(list.removeAt(5)));
//    System.out.println("Removed :" + list.getValue(list.removeAt(1)));
//    System.out.println("Removed :" + list.getValue(list.removeAt(4)));
//    System.out.println("Removed :" + list.getValue(list.removeAt(2)));
//    list.insertAt("123", 1);
//    list.insertAt("123", -1);
//    list.insertAt("123", 2);
    list.insertAt("123", 4);
    list.print();
    System.out.println("================");
    Consumer<Node<String>> con = (Node<String> n) -> {
      n.data = n.data + "-Consumer";
    };
    list.forEach(con);
    list.print();
    System.out.println("====================");
    list.forOfLoop("-Loop");
    list.print();
   /* System.out.println("Get First : " + list.getFirst());
    System.out.println("Get Last : " + list.getLast());
    System.out.println("Remove First : " + list.removeFirst());
    list.print();
    System.out.println("Remove Last : " + list.removeLast());
    list.print();*/
  }

  public void addNode(Node<T> node) {
    if(null == head)
    {
      head = node;
      return;
    }
    
    Node<T> temp = head;
    while(null != temp.next)
    {
      temp = temp.next;
    }
    temp.next = node;
  }
}


class Node<T> {
  public Node<T> next;
  public T       data;
  
  Node(T data) {
    this.data = data;
    this.next = null;
  }
  
  public T getData() {
    return data;
  }
}
