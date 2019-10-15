package vijay.ds.search.test;

public class LinearAndBinarySearchDemo {
  
  public static void main(String[] args) {
    int[] data = {3, 8, 10, 15, 45, 59, 60};
    LinearSearch ls = new LinearSearch();
    int found = ls.search(data, 45);
    System.out.println("Linear Search found element at : " + found);
    
    BinarySearch bs = new BinarySearch();
    int binarySearch = bs.binarySearch(data, 0, data.length, 6);
    System.out.println("Binary Search found element at : " + binarySearch);
  }
  
  static class BinarySearch {
    
    public int binarySearch(int data[], int start, int end, int val) {
      if(end >= start) {
        int mid = start + (end - start) / 2;
        
        if(data[mid] == val) {
          return mid;
        }
        if(val < data[mid]) {
          return binarySearch(data, start, mid - 1, val);
        }
        return binarySearch(data, mid + 1, end, val);
      }
      return -1;
    }
  }
  
  static class LinearSearch {
    
    public int search(int data[], int val) {
      int result = -1;
      
      for(int i = 0; i < data.length; i++) {
        if(data[i] == val) {
          return result = i;
        }
      }
      return result;
    }
  }
}
