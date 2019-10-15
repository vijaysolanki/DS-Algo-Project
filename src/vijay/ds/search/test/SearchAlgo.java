package vijay.ds.search.test;

import java.util.Scanner;

public class SearchAlgo {
  
  private static int counter;
  
  public static void main(String[] args) {
    // 1, 2,3,4,5,6,7,8,9,10
    System.out.println("Enter searched values ");
    Scanner sc = new Scanner(System.in);
    String readLine = sc.nextLine();
    String[] split = readLine.split(",");
    int data[] = new int[split.length];
    for(int i = 0; i < split.length; i++) {
      data[i] = Integer.parseInt(split[i].trim());
    }
    System.out.println("Enter number to look for");
    int elementToSearch = sc.nextInt();
    
    boolean search = search(data, 0, data.length - 1, elementToSearch);
    System.out.println("search found " + search + ", number of tries " + counter);
  }
  
  private static boolean search(int[] values, int start, int end, int find) {
    counter++;
    if(end >= start) {
      int mid = start + (end - start) / 2;
      
      // found at the center
      if(values[mid] == find) {
        return true;
      }
      //
      if(find < values[mid]) {
        return search(values, start, mid - 1, find);
      }
      return search(values, mid + 1, end, find);
    }
    return false;
    
  }
}
