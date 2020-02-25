package vijay.ds.stacknqueue.test;

public class Queue<T>
{
  T[] values = null;
  int rear;
  Queue(int size)
  {
    values = (T[]) new Object[size];
    rear = -1;
  }

  public void inqueue(T data)
  {
    if(rear >= values.length - 1)
    {
      return;
    }
    values[++rear] = data;
  }

  public T dequeue()
  {
    if(rear < 0)
    {
      return null;
    }
    T data = values[0];
    for(int i = 0; i + 1 <= rear; i++) {
      values[i] = values[i + 1];
    }
    rear--;
    return data;
  }

  public void print()
  {
    for(int i = 0; i <= rear; i++)
    {
      System.out.println(values[i]);
    }
  }
  
  public static void main(String[] args) {
    Queue queue = new Queue(10);
    queue.inqueue(1);
    queue.inqueue(3);
    queue.inqueue(6);
    queue.inqueue(8);
    queue.inqueue(9);
    queue.print();
    System.out.println("Dqueueing: " + queue.dequeue());
    queue.print();
  }
}
