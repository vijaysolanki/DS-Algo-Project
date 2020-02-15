package vijay.ds;

public class QueueArray {

	static class Queue
	{
		int rear =  -1;
		int front = -1;
		int data[] ;
		final int MAX = 5;
		
		public void inQueue(int value)
		{
			if(rear == -1 )
			{
				data = new int[MAX];
			}
			if(rear >= MAX -1)
			{
				System.err.println("Queue Over flow");
			}
			data[++rear] = value;
		}
		
		public int deQueue()
		{
			if(rear < 0)
			{
				System.err.println("Queue Underflow");
				return -1;
			}
			else
			{
				return data[++front];
			}
			
		}
		
		public void print()
		{
			for(int i = front+1; i <= rear; i++)
			{
				System.out.print(data[i] +" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.inQueue(1);
		queue.inQueue(2);
		queue.inQueue(3);
		queue.inQueue(4);
		queue.inQueue(5);
		queue.print();
		
		int dequeue = queue.deQueue();
		System.out.println("dequeued : " + dequeue);
		queue.print();
		
		 dequeue = queue.deQueue();
		System.out.println("dequeued : " + dequeue);
		queue.print();
		
		
		 dequeue = queue.deQueue();
		System.out.println("dequeued : " + dequeue);
		queue.print();
		
	}
}
