package vijay.ds.test;

public class Queue {
  
  Node front, rear;
  
  public void inque( int val)
  {
    Node n = new Node(val);
    if(null == rear)
    {
      front = rear = n;
    }
    else
    {
      rear.next = n;
      rear = n;
    }
  }
  
  public Node dque()
  {
    if(null == front)
    {
     System.out.println("Empty");
     return null;
    }
    else
    {
      Node temp = front;
      front = front.next;
      temp.next = null;
      return temp;
    }
  }
}
