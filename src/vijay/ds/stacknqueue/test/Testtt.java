package vijay.ds.stacknqueue.test;

public class Testtt {
  public static void main(String[] args) {
    QueueUsingArray queue = new QueueUsingArray();
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


class QueueUsingArray_1 {
  int rear   = -1;
  int data[] = new int[4];
  
  public void inqueue(int val) {
    if(rear > data.length) {
      System.out.println("Overflow");
    }
    else {
      data[++rear] = val;
    }
  }
  
  public int dequeue() {
    if(rear < 0) {
      System.out.println("Empty Queue");
      return -1;
    }
    else {
      int val = data[0];
      for(int i = 0; i <= rear; i++) {
        data[i] = data[i + 1];
      }
      rear--;
      return val;
    }
    
  }
  
  public void printQueue() {
    if(rear < 0) {
      System.out.println("Empty Queue");
    }
    else {
      for(int i = 0; i < rear; i++) {
        System.out.print(data[i] + " ");
      }
    }
    
  }
}
