package vijay.ds.sorting.test;

import java.util.Arrays;

public class MergeSortDemo {
  
  public static void main(String[] args) {
    MergeSort mSort = new MergeSort();
    int data[] = {5, 3, 4, 2, 1};
    mSort.mergeSort(data);
    System.out.println(Arrays.toString(data));
  }
}


class MergeSort {
  int data[];
  int temp[];
  
  public void mergeSort(int[] data) {
    this.data = data;
    this.temp = new int[this.data.length];
    
    doMergeSort(0, this.data.length - 1);
    
  }
  
  private void doMergeSort(int start, int end) {
    if(start < end) {
      int mid = start + (end - start) / 2;
      doMergeSort(start, mid);
      doMergeSort(mid + 1, end);
      mergePart(start, mid, end);
      System.out.println("After Merge : " + Arrays.toString(data));
    }
    
  }
  
  private void mergePart(int start, int mid, int end) {
    for(int i = start; i <= end; i++) {
      temp[i] = data[i];
    }
    
    int i = start;
    int j = mid + 1;
    int k = start;
    
    while(i <= mid && j <= end) {
      if(temp[i] < temp[j]) {
        data[k] = temp[i];
        i++;
      }
      else {
        data[k] = temp[j];
        j++;
      }
      k++;
    }
    
    while(i <= mid) {
      data[k] = temp[i];
      k++;
      i++;
    }
  }
  
}
