package vijay.ds.graph.test;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph_BFS_N_DFS_Demo {
  
  public static void main(String[] args) {
    Graph_BFS_N_DFS gf = new Graph_BFS_N_DFS(4);
    gf.addEdges(0, 1);
    gf.addEdges(0, 2);
    gf.addEdges(1, 2);
    gf.addEdges(2, 0);
    gf.addEdges(2, 3);
    System.out.println("Staring Breadth First Search");
    gf.BFS(0);
    System.out.println("Staring Depth First Search");
    gf.DFS(0);
  }
  
  static class Graph_BFS_N_DFS {
    int                 vertaxCount = 0;
    LinkedList<Integer> adjArray[];
    
    public Graph_BFS_N_DFS(int size) {
      vertaxCount = size;
      adjArray = new LinkedList[size];
      
      for(int i = 0; i < vertaxCount; i++) {
        adjArray[i] = new LinkedList<Integer>();
      }
    }
    
    public void addEdges(int src, int des) {
      adjArray[src].add(des);
    }
    
    public void DFS(int startPosition) {
      boolean visited[] = new boolean[vertaxCount];
      DFSSearch(startPosition, visited);
    }
    
    private void DFSSearch(int startPosition, boolean[] visited) {
      visited[startPosition] = true;
      System.out.println("Visiting : " + startPosition);
      
      Iterator<Integer> iterator = adjArray[startPosition].iterator();
      while(iterator.hasNext()) {
        Integer next = iterator.next();
        if(!visited[next]) {
          DFSSearch(next, visited);
        }
      }
      System.out.println();
    }
    
    public void BFS(int startPosition) {
      boolean visisted[] = new boolean[vertaxCount];
      visisted[startPosition] = true;
      
      LinkedList<Integer> visiterQueue = new LinkedList<Integer>();
      visiterQueue.add(startPosition);
      
      while(!visiterQueue.isEmpty()) {
        Integer element = visiterQueue.poll();
        System.out.print(element);
        Iterator<Integer> iterator = adjArray[element].iterator();
        while(iterator.hasNext()) {
          Integer n = iterator.next();
          if(!visisted[n]) {
            visiterQueue.add(n);
            visisted[n] = true;
          }
        }
      }
      System.out.println();
    }
  }
}
