package vijay.ds.stacknqueue.test;

public class StackUsingArrayDemo {
  
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(3);
    stack.push(6);
    stack.push(8);
    stack.printStack();
    System.out.println("Pop : " + stack.pop());
    stack.printStack();
    System.out.println("Pop : " + stack.pop());
    stack.printStack();
    System.out.println("Pop : " + stack.pop());
    stack.printStack();
    System.out.println("Pop : " + stack.pop());
    stack.printStack();
    
  }
}


class Stack {
  int MAX = 100;
  int top = -1;
  int array[];
  
  Stack() {
    array = new int[MAX];
  }
  
  public void push(int val) {
    
    if(top >= MAX - 1) {
      System.out.println("Stack overflow");
    }
    else {
      array[++top] = val;
    }
    System.out.println("added : "+ val);
  }
  
  public int pop() {
    if(top < 0) {
      System.out.println("Empty stack");
      return top;
    }
    else {
      return array[top--];
    }
  }
  
  public void printStack() {
    if(top < 0) {
      System.out.println("Empty Stack");
    }
    int i = top;
    while(i >= 0) {
      System.out.println(array[i--] );
    }
    System.out.println();
  }
}
