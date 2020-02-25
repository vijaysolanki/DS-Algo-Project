package vijay.ds.stacknqueue.test;

public class QueueUsingArrayDemo {
  public static void main(String[] args) {
    QueueUsingArray_1 queue = new QueueUsingArray_1();
    queue.inqueue(1);
    queue.inqueue(3);
    queue.inqueue(6);
    queue.inqueue(8);
    queue.inqueue(9);
    queue.printQueue();
    System.out.println("Dqueueing: " + queue.dequeue());
    queue.printQueue();
  }
}


class QueueUsingArray {
  int rear   = -1;
  int data[] = new int[4];
  
  public void inqueue(int val) {
    if(rear > data.length) {
      System.out.println("Queue overflow");
    }
    else {
      data[++rear] = val;
    }
  }
  
  public int dequeue() {
    if(rear < 0) {
      System.out.println("Empty queue");
      return -1;
    }
    else {
      int temp = data[0];
      for(int i = 0; i + 1 <= rear; i++) {
        data[i] = data[i + 1];
      }
      rear--;
      return temp;
    }
  }
  
  public void printQueue() {
    if(rear < 0) {
      System.out.println("Queue is empty");
    }
    else {
      for(int i = 0; i <= rear; i++) {
        System.out.print(data[i] + " ");
      }
    }
    System.out.println();
  }
}
