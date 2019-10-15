package vijay.ds.linkedlist.test;

public class SingleLinkedListDemo {
  
  public static void main(String[] args) {
    SingleLinkedList list = new SingleLinkedList();
    list.insert(1);
    list.insert(3);
    list.insert(6);
    list.insert(8);
    list.printLinkedList();
    list.delete(18);
    list.printLinkedList();
    
  }
  
}


class SingleLinkedList {
  
  public Node headNode;
  
  public void insert(int val) {
    Node newNode = new Node(val);
    
    if(null == headNode) {
      headNode = newNode;
    }
    else {
      Node temp = headNode;
      while(null != temp.next) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }
  
  public void delete(int val) {
    if(null == headNode)
      return;
    
    if(headNode.data == val) {
      headNode = headNode.next;
      return;
    }
    
    Node curNode = headNode, prevNode = null;
    while(null != curNode && curNode.data != val) {
      prevNode = curNode;
      curNode = curNode.next;
    }
    
    if(null != curNode) {
      prevNode.next = curNode.next;
    }
    else {
      System.out.println("\nNO element found :  " + val);
    }
  }
  /* public void delete(int val) {
    System.out.println("\nDeleting value : " + val);
    if(null == headNode) {
      System.out.println("Empty SingleLinkedList");
    }
    else {
      Node currentNode = headNode, prevNode = null;
      while(null != currentNode) {
        if(currentNode.data == val) {
          break;
        }
        prevNode = currentNode;
        currentNode = currentNode.next;
      }
      if(null != currentNode && null == prevNode) {
        headNode = currentNode.next;
      }
      else if(null != currentNode) {
        prevNode.next = currentNode.next;
      }
      else {
        System.out.println("value not found");
      }
    }
  }*/
  
  public void printLinkedList() {
    if(null == headNode) {
      System.out.println("Empty SingleLinkedList");
    }
    else {
      Node temp = headNode;
      System.out.print("SingleLinkedList : ");
      while(null != temp) {
        System.out.print(" " + temp.data);
        temp = temp.next;
      }
    }
    System.out.println();
  }
}


class Node {
  
  int  data;
  Node next;
  
  Node(int data) {
    this.data = data;
    next = null;
  }
  
  public Object getData() {
    return data;
  }
  
  public void setData(int data) {
    this.data = data;
  }
  
  public Node getNext() {
    return next;
  }
  
  public void setNext(Node next) {
    this.next = next;
  }
  
}
