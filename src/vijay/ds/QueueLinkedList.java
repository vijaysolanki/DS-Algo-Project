package vijay.ds;

public class QueueLinkedList {
	static class Queue {
		Node front, rear;

		class Node {
			int value;
			Node next;

			public Node(int value) {
				this.value = value;
			}
		}

		public void inQueue(int value) {
			Node newValue = new Node(value);
			if (null == rear) {
				front = rear = newValue;
			} else {
				Node temp = rear;
				temp.next = newValue;
				rear = newValue;

			}
		}

		public int Dequeue() {
			if (null == front) {
				System.err.println("Queue underflow");
				return -1;
			} else {
				Node temp = front;
				front = front.next;
				return temp.value;
			}
		}

		public void print() {
			if (null == front || null == rear) {
				System.err.println("Queue underflow");
			} else {
				Node temp = front;
				while (null != temp) {
					System.out.print(temp.value + " ");
					temp = temp.next;
				}
				System.out.println();
			}

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
		
		int dequeue = queue.Dequeue();
		System.out.println("dequeued : " + dequeue);
		queue.print();
		
		 dequeue = queue.Dequeue();
		System.out.println("dequeued : " + dequeue);
		queue.print();
		
		
		 dequeue = queue.Dequeue();
		System.out.println("dequeued : " + dequeue);
		queue.print();
		
		
		
	}
}
