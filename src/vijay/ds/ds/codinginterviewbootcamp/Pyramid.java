package vijay.ds.ds.codinginterviewbootcamp;

/**
 * 1. Using Double looping
 * 2. Using Single loop
 * 3. Using Recursion
@author ashokv
           #   
          ###  
         ##### 
        #######
*/

public class Pyramid {
  public static void main(String... args) {
    Pyramid py = new Pyramid();
    int size = 4;
    py.printPyramid_1(size);
    py.printPyramid_2(size);
    System.out.println("Using recursion");
    py.printPyramid_3(size, 0, new StringBuffer());
  }
  
  public void printPyramid_1(int size) {
    System.out.println("Using iterative approach");
    for(int i = 0; i <= size - 1; i++) {
      
      for(int j = size - 1; j >= 0; j--) {
        
        if(j > i) {
          System.out.print("-");
        }
        else {
          System.out.print("#");
        }
      }
      
      for(int k = 0; k < size - 1; k++) {
        
        if(i > k) {
          System.out.print("#");
        }
        else {
          System.out.print("-");
        }
      }
      
      System.out.println();
    }
    
  }
  
  public void printPyramid_2(int size) {
    System.out.println("Using iterative approach with limits");
    int clSize = (size + (size - 1)) - 1;
    int mid = clSize / 2 + clSize % 2;
    // (2*size -1 / 2) == mid point
    for(int r = 0; r <= size - 1; r++) {
      StringBuffer sb = new StringBuffer();
      for(int c = 0; c <= clSize; c++) {
        
        if(mid - r <= c && mid + r >= c) {
          sb.append("#");
        }
        else {
          sb.append("-");
        }
      }
      
      System.out.println(sb);
    }
  }
  
  public void printPyramid_3(int size, int row, StringBuffer sb) {
    //terminate 
    if(size == row) {
      return;
    }
    
    //one row is constructed
    if(sb.length() == (2 * size - 1)) {
      System.out.println(sb);
      printPyramid_3(size, row + 1, new StringBuffer());
      return;
    }
    
    int mid = (int) Math.floor((2 * size - 1) / 2);
    if(mid - row <= sb.length() && mid + row >= sb.length()) {
      sb.append("#");
    }
    else {
      sb.append("-");
    }
    printPyramid_3(size, row, sb);
    
  }
  
}
