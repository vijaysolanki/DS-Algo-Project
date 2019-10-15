
package vijay.ds.linkedlist.test;

public class CircularDoublyLinkedListDemo {
  
  public static void main(String[] args) {
    CircularDoublyLinkedList list = new CircularDoublyLinkedList();
    list.insert(1);
    list.insert(3);
    list.insert(6);
    list.insert(8);
    list.printLinkedList();
    list.delete(6);
    list.printLinkedList();
  }
  
}


class CircularDoublyLinkedList {
  
  public CDNode headNode;
  
  public void insert(int val) {
    CDNode newNode = new CDNode(val);
    
    if(null == headNode) {
      headNode = newNode;
    }
    else {
      CDNode temp = headNode;
      while(null != temp.next && temp.next != headNode) {
        temp = temp.next;
      }
      temp.next = newNode;
      newNode.prev = temp;
      //circular
      newNode.next = headNode;
      headNode.prev = newNode;
    }
  }
  
  public void delete(int val) {
    if(null == headNode)
      return;
    
    if(headNode.data == val) {
      CDNode next = headNode.next;
      CDNode prev = headNode.prev;
      next.prev = prev;
      headNode = next;
      prev.next = headNode;
      return;
    }
    
    CDNode curNode = headNode;
    
    while(headNode != curNode.next && null != curNode && curNode.data != val) {
      curNode = curNode.next;
      
    }
    
    if(curNode != headNode) {
      CDNode prev = curNode.prev;
      CDNode next = curNode.next;
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
      CDNode temp = headNode;
      System.out.print("DoublyLinkedList : ");
      while(null != temp) {
        System.out.print(" " + temp.data);
        temp = temp.next;
        if(temp == headNode) {
          break;
        }
      }
    }
  }
}


class CDNode {
  
  int    data;
  CDNode next;
  CDNode prev;
  
  CDNode(int data) {
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
  
  public CDNode getNext() {
    return next;
  }
  
  public void setNext(CDNode next) {
    this.next = next;
  }
  
  public CDNode getPrev() {
    return prev;
  }
  
  public void setPrev(CDNode prev) {
    this.prev = prev;
  }
  
}
