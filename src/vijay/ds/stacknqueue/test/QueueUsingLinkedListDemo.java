package vijay.ds.stacknqueue.test;

public class QueueUsingLinkedListDemo {
  public static void main(String[] args) {
    Queqe queqe = new Queqe();
    queqe.inqueue(1);
    queqe.inqueue(3);
    queqe.inqueue(6);
    queqe.inqueue(8);
    queqe.printQueue();
    System.out.println("Dequeuing : " + queqe.dequeue());
    queqe.printQueue();
    System.out.println("Dequeuing : " + queqe.dequeue());
    queqe.printQueue();
    System.out.println("Dequeuing : " + queqe.dequeue());
    queqe.printQueue();
    System.out.println("Dequeuing : " + queqe.dequeue());
    queqe.printQueue();
    
  }
}


class Queqe {
  QNode front;
  QNode rear;
  
  public void inqueue(int val) {
    QNode newNode = new QNode(val);
    if(null == rear) {
      front = rear = newNode;
    }
    else {
      rear.next = newNode;
      rear = newNode;
    }
  }
  
  public int dequeue() {
    if(null == front) {
      System.out.println("Empty queue");
      return -1;
    }
    else {
      QNode temp = front;
      front = front.next;
      return temp.data;
    }
  }
  
  public void printQueue() {
    if(null == front) {
      System.out.println("Empty queue");
    }
    else {
      QNode temp = front;
      while(null != temp) {
        System.out.print(temp.data + " ");
        temp = temp.next;
      }
    }
    System.out.println();
    
  }
}


class QNode {
  int   data;
  QNode next;
  
  public QNode(int data) {
    this.data = data;
  }
  
  public int getData() {
    return data;
  }
  
  public void setData(int data) {
    this.data = data;
  }
  
  public QNode getNext() {
    return next;
  }
  
  public void setNext(QNode next) {
    this.next = next;
  }
  
}
