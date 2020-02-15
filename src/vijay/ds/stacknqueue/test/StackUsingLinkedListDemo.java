package vijay.ds.stacknqueue.test;

public class StackUsingLinkedListDemo {
  
  public static void main(String[] args) {
    StackUsingLinkedList stack = new StackUsingLinkedList();
    stack.push(1);
    stack.push(3);
    stack.push(6);
    stack.push(8);
    stack.printStack();
    System.out.println("pop : " + stack.pop());
    stack.printStack();
    System.out.println("pop : " + stack.pop());
    stack.printStack();
    System.out.println("pop : " + stack.pop());
    stack.printStack();
    System.out.println("pop : " + stack.pop());
    stack.printStack();
    
  }
}


class StackUsingLinkedList {
  private SNode headNode;
  
  public void push(int val) {
    
    SNode newNode = new SNode(val);
    if(null == headNode) {
      headNode = newNode;
    }
    else {
//      SNode temp = headNode;
      newNode.next = headNode;
      headNode = newNode;
    }
  }
  
  public int pop() {
    
    int data = -1;
    if(null == headNode) {
      System.out.println("Empty Stack");
    }
    else {
      data = headNode.data;
      headNode = headNode.next;
    }
    
    return data;
  }
  
  public void printStack() {
    
    if(null == headNode) {
      System.out.println("Empty stack");
    }
    SNode temp = headNode;
    while(null != temp) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}


class SNode {
  int   data;
  SNode next;
  
  SNode(int data) {
    this.setData(data);
    this.next = null;
  }
  
  public int getData() {
    return data;
  }
  
  public void setData(int data) {
    this.data = data;
  }
  
}
