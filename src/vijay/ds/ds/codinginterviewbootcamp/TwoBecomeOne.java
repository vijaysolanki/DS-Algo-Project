package vijay.ds.ds.codinginterviewbootcamp;

/**
 * 2 Stack are used to create Queue
 * . add
 * . remove
 * . peek
 * @author ashokv
 *
 */
public class TwoBecomeOne {
  public static void main(String[] args) {
    /*MyStack<Integer> s1 = new MyStack();
    s1.push(1);
    s1.push(2);
    s1.push(3);
    s1.push(4);
    s1.print();
    System.out.println("------------");
    System.out.println("Poped : " + s1.pop());
    s1.print();
    System.out.println("Poped : " + s1.pop());
    s1.print();
    System.out.println("Poped : " + s1.pop());
    s1.print();*/
    
    MyQueue<Integer> queue = new MyQueue<>();
    queue.inqueue(1);
    queue.inqueue(2);
    queue.inqueue(3);
    queue.inqueue(5);
    queue.print();
    System.out.println("Dequeue : " + queue.dequeue());
    System.out.println("Dequeue : " + queue.dequeue());
    queue.print();
    System.out.println("------------ in queue new elements");
    queue.inqueue(6);
    queue.inqueue(7);
    queue.inqueue(8);
    queue.print();
    System.out.println("Dequeue : " + queue.dequeue());
    System.out.println("Dequeue : " + queue.dequeue());
    queue.print();
    
    
  }
}

class MyQueue<T>
{
  MyStack<T> s1 = null;
  MyStack<T> s2 = null;
  
  public MyQueue() {
    s1 = new MyStack<T>();
    s2 = new MyStack<T>();
  }
  
  public void inqueue(T val)
  {
    s1.push(val);
  }
  
  public T dequeue()
  {
    if(null == s1.peek())
    {
      throw new RuntimeException("Queue is empty");
    }
    while( null != s1.peek())
    {
      T pop = s1.pop();
      s2.push(pop);
    }
    T pop = s2.pop();
    while(null != s2.peek() )
    {
      T pop2 = s2.pop();
      s1.push(pop2);
    }
    
    return pop;
  }
  
  public T peek()
  {
    if(null == s1.peek())
    {
      throw new RuntimeException("Queue is empty");
    }
    while( null != s1.peek())
    {
      T pop = s1.pop();
      s2.push(pop);
    }
    T peek = s2.peek();
    while(null != s2.peek() )
    {
      T pop2 = s2.pop();
      s1.push(pop2);
    }
    return peek;
  }
  
  public void print(){
    if(null == s1.peek())
    {
      throw new RuntimeException("Queue is empty");
    }
    while( null != s1.peek())
    {
      T pop = s1.pop();
      s2.push(pop);
    }
    while(null != s2.peek() )
    {
      T pop2 = s2.pop();
      System.out.print(pop2+ " ");
      s1.push(pop2);
    }
    System.out.println();
  }
}


class  MyStack<T>
{
  final int MAX = 5;
  Object[] data = null;
  int top = -1;
  
  public MyStack() {
    data = new Object[MAX];
  }
  
  public void push(T val)
  {
    if(top >= data.length - 1)
    {
      throw new RuntimeException("Stack is full");
    }
    
    data[++top] = val;
  }
  
  public T pop()
  {
    if(top < 0)
    {
      throw new RuntimeException("Stack is empty");
    }
    
    T val = (T) data[top--];
    return val;
  }
  
  public void print()
  {
    if(top < 0)
    {
      throw new RuntimeException("Empty Stack");
    }
    for(int i = top; i >= 0; i--)
    {
      System.out.println(data[i]);
    }
  }
  
  public T peek()
  {
    if(top < 0)
    {
      return null;
    }
    
    return (T)data[top];
  }
}
