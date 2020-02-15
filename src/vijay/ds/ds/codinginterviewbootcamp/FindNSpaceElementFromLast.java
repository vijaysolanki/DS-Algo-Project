package vijay.ds.ds.codinginterviewbootcamp;

public class FindNSpaceElementFromLast {
  public static void main(String[] args) {
    
    LinkedList<String> list = new LinkedList<String>();
    
    int i = 1;
    while(i <= 10)
    {
      Node<String> node = new Node<String>("A-" + i);
      list.addNode(node);
      i++;
    }
    list.print();
    System.out.println("========================");
    System.out.println(list.getValue(findElement(list, 2)));
    
  }
  
  static public Node<String> findElement(LinkedList<String> list, int n)
  {
    Node<String> slow, fast = null;
    //head
    slow =fast= list.getNodeAtIndex(0);
    int i = 0;
    while(i < n)
    {
      fast = fast.next;
      i++;
    }
    System.out.println("fast : " + list.getValue(fast));
    
    while(null != fast.next)
    {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
