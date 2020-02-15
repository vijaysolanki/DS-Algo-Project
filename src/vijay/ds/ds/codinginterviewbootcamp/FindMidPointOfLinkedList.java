package vijay.ds.ds.codinginterviewbootcamp;

public class FindMidPointOfLinkedList {
  
  public static void main(String ...strings)
  {
    LinkedList<String> list= new LinkedList<String>();
    int index = 0;
    list.insertAt("A", index);
    list.insertAt("B", index);
    list.insertAt("C", index);
    list.insertAt("D", index);
    list.insertAt("E", index);
    list.print();
    System.out.println("Mid Point : " + findMindPoint(list).data);
    list.insertAt("F", index);
    list.print();

    System.out.println("Mid Point : " + findMindPoint(list).data);
  }
  
  public static Node<String> findMindPoint(LinkedList<String> list)
  {
    Node<String> slow = list.head;
    Node<String> fast = list.head;
    if(null == list.head)
    {
      return null;
    }
    while(null != fast.next && null != fast.next.next)
    {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  
}
