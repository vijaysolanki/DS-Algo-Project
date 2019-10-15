package vijay.ds;

public class SingleLInkedList {

	SNode head = null;
	
	public void add(int val)
	{
		if(null == head)
		{
			head = new SNode(val);
			return;
		}
		SNode temp = head;
		while(null != temp.next)
		{
			temp = temp.next;
		}
		temp.next = new SNode(val);
	}
	
	public void print()
	{
		SNode temp = head;
	   while(null != temp.next)
	   {
		  System.out.print(temp.val+ " ");
		  temp= temp.next;
	   }
	   System.out.println();
	}
	public void delete(int val)
	{
		if(null == head)
		{
			System.err.println("Queue underflow");
			return;
		}
		if(head.val == val)
		{
			head = head.next;
			return;
		}
		
		SNode temp = head,prev=null ;
		while(null != temp && temp.val != val)
		{
			prev = temp;
			temp = temp.next;
		}
		
		if(null != temp)
		{
			prev.next = temp.next;
		}
		else
		{
			System.out.println("Reached End, "+val+" not found");
		}
		
	}
	
	public static void main(String[] args) {
		SingleLInkedList s = new SingleLInkedList();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);
		s.print();
		
		s.delete(4);
		s.print();
	}

}

class SNode {
	int val;
	SNode next;

	public SNode(int val) {
		this.val = val;
	}
	
}
