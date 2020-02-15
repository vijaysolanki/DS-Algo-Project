package vijay.ds.sorting.test;

import java.util.Arrays;

public class InsertationSortDemo {
  
  public static void main(String[] args) {
    int data[] = {5, 2, 3, 1, 4};
    System.out.println(Arrays.toString(data));
    InsertationSort iSort = new InsertationSort();
    iSort.insertationSort(data);
    System.out.println(Arrays.toString(data));
    
  }
}


class InsertationSort {
  
  public void insertationSort(int[] data) {
    int temp = -1;
    for(int i = 1; i < data.length; i++) {
      for(int j = i; j > 0; j--) {
        if(data[j - 1] > data[j]) {
          temp = data[j - 1];
          data[j - 1] = data[j];
          data[j] = temp;
        }
      }
    }
  }
  
}
