package vijay.ds.graph.test;

import java.util.LinkedList;

public class GraphUsingAdjacencyListDemo {
  
  public static void main(String[] args) {
    
    Graph graph = new Graph(5);
    graph.addEdges(0, 1);
    graph.addEdges(0, 4);
    graph.addEdges(1, 2);
    graph.addEdges(1, 3);
    graph.addEdges(1, 4);
    graph.addEdges(2, 3);
    graph.addEdges(3, 4);
    
    graph.printGraph();
  }
  
  static class Graph {
    int                 vertaxCount = 0;
    LinkedList<Integer> adjArray[];
    
    public Graph(int size) {
      vertaxCount = size;
      adjArray = new LinkedList[size];
      for(int i = 0; i < size; i++) {
        adjArray[i] = new LinkedList<Integer>();
      }
    }
    
    public void addEdges(int source, int destination) {
      adjArray[source].add(destination);
      adjArray[destination].add(source);
    }
    
    public void printGraph() {
      for(int i = 0; i < vertaxCount; i++) {
        System.out.print("Adjacency list for vertax " + i + " is ");
        for(Integer ver : adjArray[i]) {
          System.out.print("-> " + ver);
        }
        System.out.println();
      }
    }
  }
}
