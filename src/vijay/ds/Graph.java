package vijay.ds;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	int vertexCount =0 ;
	LinkedList<Integer> []ajList;
	
	public Graph(int count) {
			vertexCount = count;
			ajList = new LinkedList[vertexCount];
			for (int i = 0; i < vertexCount; i++) {
				ajList[i] = new LinkedList<Integer>();
			}
	}
	
	public void addEdges(int src, int des)
	{
		/*int index = Integer.toString(src).hashCode()%vertexCount;
		ajList[index].add(des);
		index = Integer.toString(des).hashCode()%vertexCount;
		ajList[index].add(src);*/
		ajList[src].add(des);
		ajList[des].add(src);
	}
	public void addEdgesForBFS(int src, int des)
	{
		ajList[src].add(des);
	}
	
	
	public void graphBFS(int source)
	{
		boolean visited[] = new boolean[vertexCount];
		LinkedList<Integer> queue= new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		while(queue.size() != 0){
			Integer poll = queue.poll();
			System.out.print(poll);
			Iterator<Integer> iterator = ajList[poll].iterator();
			while(iterator.hasNext())
			{
				Integer next = iterator.next();
				if(!visited[next])
				{
					visited[next]=true;
					queue.add(next);
				}
			}
		}
		
	}
	public void print()
	{
		
	/*	for (LinkedList<Integer> linkedList : ajList) {
			System.out.print("Adjacency list for vertax " + linkedList.element() + " is ");
			for( Integer ver: linkedList) 
			{
				System.out.print("-> " + ver);
			}
			System.out.println();
		}*/
		
		for (int i = 0; i < vertexCount; i++) {
			System.out.print("Adjacency list for vertax " + i + " is ");
			for(Integer ver : ajList[i])
			{
				 System.out.print("-> " + ver);
			}
			 System.out.println();
		}
	}
	
	public static void main(String[] args) {
		/*Graph graph = new Graph(5);
		graph.addEdges(0, 1);
	    graph.addEdges(0, 4);
	    graph.addEdges(1, 2);
	    graph.addEdges(1, 3);
	    graph.addEdges(1, 4);
	    graph.addEdges(2, 3);
	    graph.addEdges(3, 4);
	    graph.print();*/
		
		
		Graph graph = new Graph(5);
		graph.addEdgesForBFS(0, 1);
		graph.addEdgesForBFS(0, 2);
	    graph.addEdgesForBFS(1, 2);
	    graph.addEdgesForBFS(2, 0);
	    graph.addEdgesForBFS(2, 3);
	    graph.graphBFS(0);
	}
}
