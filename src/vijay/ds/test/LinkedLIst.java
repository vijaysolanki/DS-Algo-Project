package vijay.ds.test;

public class LinkedLIst {
  Node head = null;
  

  public void inqueu(int val)
  {
    Node n = new Node(val);
    if(null == head)
    {
      head = n;
      return;
    }
    
    Node temp = head;
    while(null != temp.next)
    {
      temp = temp.next;
    }
    temp.next = n;
  }
  
  public Node dequeu(int val)
  {
    
    if(null== head)
    {
      return null;
    }
     if(head.data == val)
     {
       Node temp = head;
       head = head.next;
       return temp;
     }
     
     Node temp = head, pre= null;
     while(null != temp && temp.data == val)
     {
       pre = temp;
       temp= temp.next;
     }
     
     if(null == temp)
     {
       System.out.println("No result");
       return  null;
     }
     else
     {
       pre.next = temp.next;
       temp.next = null;;
       return temp;
     }
     
  }
  
}

class Node
{
  int data;
  Node next;
  
  Node(int data)
  {
    this.data = data;
  }
}