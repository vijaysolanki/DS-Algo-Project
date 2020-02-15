package vijay.ds.ds.codinginterviewbootcamp;

public class FindLinkedListIsCircular {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<String>();
    Node<String> node1 = new Node<>("A");
    Node<String> node2 = new Node<>("B");
    Node<String> node3 = new Node<>("C");
    Node<String> node4 = new Node<>("D");
    Node<String> node5 = new Node<>("E");
    
    list.addNode(node1);
    list.addNode(node2);
    list.addNode(node3);
    list.addNode(node4);
    list.addNode(node5);
    list.addNode(node5);
//    list.print();
//    list.insertFirst("A");
//    list.insertFirst("B");
//    list.insertFirst("C");
//    list.insertFirst("D");
//    list.insertFirst("E");
//    list.insertFirst("D");
    System.out.println("isCircular : " + isListCircular(list));
  }
  
  static public boolean isListCircular(LinkedList<String> list)
  {
    //head
    Node<String> slow = list.getNodeAtIndex(0);
    Node<String> fast = slow;
    
    if(null == slow)
    {
      return false;
    }
    
   /* fast= fast.next;
    if(null != fast && fast.next.data.equals(slow.data))
    {
      return true;
    }
    fast= fast.next.next;
    if(null != fast && fast.next.data.equals(slow.data))
    {
      return true;
    }*/
    while(null!= fast.next && null != fast.next.next)
    {
      slow = slow.next;
      fast = fast.next.next;
      
      if(slow == fast)
      {
        return true;
      }
    }
    return false;
  }
}


