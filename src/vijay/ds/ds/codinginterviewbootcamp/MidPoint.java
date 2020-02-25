package vijay.ds.ds.codinginterviewbootcamp;

public class MidPoint {

  static class Node<T> {
    T       data;
    Node<T> next;
    
    Node(T data) {
      this.data = data;
    }
  }
  
  static class LinkedList<T> {

    Node<T> head;
    
    public void add(T data) {
      Node<T> newNode = new Node<T>(data);
      if(null == head) {
        head = newNode;
        return;
      }
      Node<T> temp = head;
      while(null != temp.next) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
    
    public void print() {
      if(null == head) {
        return;
      }
      Node<T> temp = head;
      while(null != temp) {
        System.out.println(temp.data);
        temp = temp.next;
      }
    }
    
    public Node<T> findMindPoint() {
      if(null == head) {
        return null;
      }
      
      Node<T> slow = head;
      Node<T> fast = head;
      while(null != fast.next && null != fast.next.next) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
    
    public boolean isCirclarList() {
      if(null == head) {
        return false;
      }
      
      Node<T> slow = head;
      Node<T> fast = head;
      while(null != fast.next && null != fast.next.next) {

        slow = slow.next;
        fast = fast.next.next;
        
        if(slow == fast) {
          return true;
        }
      }
      return false;
    }
    
    public Node<T> findNthStepsElementFromEnd(int steps) {
      if(null == head) {
        return null;
      }
      
      Node<T> slow = head;
      Node<T> fast = head;
      int i = 0;
      while(i < steps) {
        fast = fast.next;
        i++;
      }
      
      while(null != fast) {
        slow = slow.next;
        fast = fast.next;
      }
      return slow;
      
    }
  }
  
  public static void main(String[] args) {
    
    LinkedList<String> list = new LinkedList<String>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.add("E");
    list.print();
    System.out.println("Mid Point : " + list.findMindPoint().data);
    /* list.add("F");
    list.print();*/
    
    System.out.println("Mid Point : " + list.findMindPoint().data);
  }
}
