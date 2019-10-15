package vijay.ds.linkedlist.test;

public class DoublyLinkedListDemo {
  
  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    list.insert(1);
    list.insert(3);
    list.insert(6);
    list.insert(8);
    list.printLinkedList();
    list.delete(6);
    list.printLinkedList();
    
  }
  
}


class DoublyLinkedList {
  
  public DNode headNode;
  
  public void insert(int val) {
    DNode newNode = new DNode(val);
    
    if(null == headNode) {
      headNode = newNode;
    }
    else {
      DNode temp = headNode;
      while(null != temp.next) {
        temp = temp.next;
      }
      temp.next = newNode;
      newNode.prev = temp;
    }
  }
  
  public void delete(int val) {
    if(null == headNode)
      return;
    
    if(headNode.data == val) {
      headNode = headNode.next;
      headNode.prev = null;
      return;
    }
    
    DNode curNode = headNode;
    
    while(null != curNode && curNode.data != val) {
      curNode = curNode.next;
    }
    
    if(null != curNode) {
      DNode prev = curNode.prev;
      DNode next = curNode.next;
      prev.next = next;
      next.prev = prev;
      
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
    System.out.println();
    if(null == headNode) {
      System.out.println("Empty DoublyLinkedList");
    }
    else {
      DNode temp = headNode;
      System.out.print("DoublyLinkedList : ");
      while(null != temp) {
        System.out.print(" " + temp.data);
        temp = temp.next;
      }
    }
  }
}


class DNode {
  
  int   data;
  DNode next;
  DNode prev;
  
  DNode(int data) {
    this.data = data;
    next = null;
    prev = null;
  }
  
  public Object getData() {
    return data;
  }
  
  public void setData(int data) {
    this.data = data;
  }
  
  public DNode getNext() {
    return next;
  }
  
  public void setNext(DNode next) {
    this.next = next;
  }
  
  public DNode getPrev() {
    return prev;
  }
  
  public void setPrev(DNode prev) {
    this.prev = prev;
  }
  
}
