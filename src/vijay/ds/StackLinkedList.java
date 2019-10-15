package vijay.ds;

public class StackLinkedList {

	Node top;
	public  void push(int val)
	{
		Node newNode = new Node(val); 
		if(null == top )
		{
			top = newNode;
		}
		else
		{
			newNode.next = top;
			top = newNode;
		}
	}
	
	public int pop()
	{
		
		if(null == top)
		{
			return -1;
		}
		else
		{
			Node temp = top;
			top = top.next;
			return temp.val;
		}
	}
	
	public void print()
	{ 
		Node temp = top;
		while(null != temp)
		{
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	static class Node
	{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	
	
	public static void main(String[] args) {
		StackLinkedList list = new StackLinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.print();
		int pop = list.pop();
		System.out.println("Poped :  " + pop);
		 pop = list.pop();
		System.out.println("Poped :  " + pop);
		 pop = list.pop();
		System.out.println("Poped :  " + pop);
		list.print();
	}
	
	
	
	
}


