package vijay.ds.sorting.test;

import java.util.Arrays;

public class QuickSortDemo {
  
  public static void main(String[] args) {
    int[] data = {10, 80, 30, 90, 40, 50, 70};
    System.out.println("Unsorted Data ->  " + Arrays.toString(data));
    QuickSort qSort = new QuickSort();
    qSort.quickSort(data);
    System.out.println("Sorted Data ->  " + Arrays.toString(data));
  }
}


class QuickSort {
  public void quickSort(int[] data) {
    qSort(data, 0, data.length - 1);
  }
  
  private void qSort(int[] data, int start, int end) {
    
    if(start < end) {
      int pi = partision(data, start, end);
      qSort(data, start, pi - 1);
      qSort(data, pi + 1, end);
    }
  }
  
  private int partision(int[] data, int start, int end) {
    int i = start - 1; //starting index to keep track of smaller item index ( start with -1)
    int pi = data[end];// last index is pivot element
    //0 1 2 3
    //2 5 3 4 -> 2 3 5 4
    
    for(int j = start; j < end; j++) {
      if(data[j] <= pi) {
        i++; // j=0 : i= 0, j=2:i=1; 
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
      }
    }
    //2 3 5 4 -> 2 3 4 5
    int temp = data[end];
    data[end] = data[i + 1];
    data[i + 1] = temp;
    return i + 1; //return the next index from min found as pivot element is also replace here.
  }
}
