package vijay.ds.ds.codinginterviewbootcamp;

/**
 * Merge two queue into one.
 * 
 *            Weave===========
   Queue 1    Hi To you 
   Queue 2    1 2 3 4 
              ----------
              Hi 1 
              ----------
              Hi 1 To 2 
              ----------
              Hi 1 To 2 you 3 
              ----------
              Hi 1 To 2 you 3 4 
              Hi 1 To 2 you 3 4

 * @author ashokv
 *
 * @param <K>
 */
public class Queue<K> {
	
	private Object data[];
	private int rear ;
	
	Queue(int size)
	{
		data = new Object[size];
		rear= -1;
	}
	
	public  void inqueue(K value)
	{
    if(rear >= data.length - 1)
		{
		 throw new RuntimeException("Queue is full");
		}
		data[++rear] = value;
	}
	
	public K dequeue()
	{
		if(rear  < 0 )
		{
		 throw new RuntimeException("Queue is Empty");
		}
		
		K val = (K)data[0];
    for(int i = 0; i + 1 <= rear; i++) {
			data[i]= data[i +1];
		}
		rear = rear -1;
		return val;
	}
	 
	public void print()
	{
		System.out.println("Index :  " + rear);
		for (int i = 0; i <= rear ; i++) {
			System.out.print( data[i] + " ");
		}
		System.out.println();
	}
	
	
	public K peek()
	{
		if(rear < 0 || rear > data.length -1)
		{
			return null;
		}
		
    return (K) data[0];
		
	}
	
	public int size()
	{
		return data.length;
	}
	
	public Queue<Object> weave(Queue q1, Queue q2)
	{
		Queue<Object> newQ = new Queue<Object>(q1.size() + q2.size());
		
    while(null != q1.peek() || null != q2.peek()) {
      
			if(null != q1.peek()  )
			{
				newQ.inqueue(q1.dequeue());
			}
			if(null != q2.peek() )
			{
				newQ.inqueue(q2.dequeue());
			}
			System.out.println("----------");
			newQ.print();
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
