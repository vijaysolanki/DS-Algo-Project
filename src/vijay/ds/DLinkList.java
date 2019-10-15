package vijay.ds;

public class DLinkList {
	public static void main(String[] args) {
		DLList dList = new DLList();
		dList.insert(1);
		dList.insert(2);
		dList.insert(3);
		dList.insert(4);
		dList.print();
		dList.delete(2);
		dList.print();
	}
}

class DLList
{
	
	DNode head = null;
	
	public void insert(int value)
	{
		DNode n = new DNode(value);
		if(null == head)
		{
			head = n;
		}
		else
		{
			DNode temp = head;
			while(null != temp.next)
			{
				temp= temp.next;
			}
			temp.next = n;
			n.prev = temp;
		}
	}
	
	public void delete(int val)
	{
		if(head.value == val)
		{
			DNode next = head.next;
			next.prev = null;
			head = next; 
		}
		else
		{
			DNode cur = head;
			while(null != cur && val != cur.value)
			{
				cur= cur.next;
			}
			
			if(null != cur)
			{
				DNode prev = cur.prev;
				DNode next = cur.next;
				prev.next = next;
				next.prev = prev;
			}
			else
			{
				System.out.println("NO element found "  + val);
			}
				
		}
	}
	
	public void print()
	{
		DNode temp = head;
		while(null != temp)
		{
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class DNode
{
	int value;
	DNode next,prev;
	public DNode(int value) {
		this.value = value;
	}

}