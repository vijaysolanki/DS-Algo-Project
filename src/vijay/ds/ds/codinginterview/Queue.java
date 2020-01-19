package vijay.ds.ds.codinginterview;

import java.util.Arrays;

public class Queue<K> {
	
	private Object data[];
	private int index ;
	Queue(int size)
	{
		data = new Object[size];
		index= -1;
	}
	
	 void inqueue(K value)
	{
		if(index > data.length -1 )
		{
		 throw new RuntimeException("Queue is full");
		}
		data[++index] = value;
	}
	
	 K dequeue()
	{
		if(index  < 0 )
		{
		 throw new RuntimeException("Queue is Empty");
		}
		
		K val = (K)data[0];
		for (int i = 0; i <= index -1; i++) {
			data[i]= data[i +1];
		}
		index = index -1;
		return val;
	}
	 
	public void print()
	{
		System.out.println("Index :  " + index);
		for (int i = 0; i <= index ; i++) {
			System.out.print( data[i] + " ");
		}
		System.out.println();
	}
	
	
	public K peek()
	{
		if(index < 0 || index > data.length -1)
		{
			return null;
		}
		
		return (K)data[index];
		
	}
	
	public int size()
	{
		return data.length;
	}
	
	public Queue<Object> weave(Queue q1, Queue q2)
	{
		Queue<Object> newQ = new Queue<Object>(q1.size() + q2.size());
		
		for (int i = 0; i <= newQ.size() -1; i++) {
			
			if(null == q1.peek() && null == q2.peek())
			{
				return newQ;
			}
			if(null != q1.peek()  )
			{
				newQ.inqueue(q1.dequeue());
			}
			if(null != q2.peek() )
			{
				newQ.inqueue(q2.dequeue());
			}
			
		}
		return newQ;
	}
	
	static public void main(String ...args)
	{
		Queue<Integer> queue = new Queue<Integer>(5);
		queue.inqueue(1);
		queue.inqueue(2);
		queue.inqueue(3);
		queue.inqueue(4);
		queue.inqueue(5);
//		queue.inqueue(1);
		queue.print();
		
		System.out.println("Peek :  " + queue.peek());
		System.out.println("dequeu = " + queue.dequeue());
		queue.print();
		System.out.println("Peek :  " + queue.peek());
		System.out.println("dequeu = " + queue.dequeue());
		queue.print();
		System.out.println("Peek :  " + queue.peek());
		System.out.println("dequeu = " + queue.dequeue());
		queue.print();
		System.out.println("Peek :  " + queue.peek());
		System.out.println("dequeu = " + queue.dequeue());
		queue.print();
		System.out.println("Peek :  " + queue.peek());
		System.out.println("dequeu = " + queue.dequeue());
		queue.print();
		/*System.out.println("dequeu = " + queue.dequeue());
		queue.print();*/
		
		System.out.println("Weave===========");
		
		Queue<String> queue1 = new Queue<String>(3);
		queue1.inqueue("Hi");
		queue1.inqueue("To");
		queue1.inqueue("you");
		queue1.print();
		
		Queue<Integer> queue2 = new Queue<Integer>(4);
		queue2.inqueue(1);
		queue2.inqueue(2);
		queue2.inqueue(3);
		queue2.inqueue(4);
		queue2.print();
		
		
		Queue que3 = queue.weave(queue1, queue2);
		que3.print();
		
	}
	
}
