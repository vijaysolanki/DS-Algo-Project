package vijay.ds.sorting.test;

public class SelectionSortDemo {
  
  public static void main(String[] args) {
    int[] data = {12, 6, 8, 2, 20, 9, 7};
    SelectionSort sSort = new SelectionSort();
    sSort.print(data);
    sSort.selectionSort(data);
    sSort.print(data);
  }
}


class SelectionSort {
  
  public void findMin(int[] data) {
    int min = 0;
    for(int i = 0; i < data.length - 1; i++) {
      if(data[min] > data[i + 1]) {
        min = i + 1;
      }
    }
  }
  
  public void selectionSort(int[] data) {
    for(int i = 0; i < data.length - 1; i++) {
      int min = i;
      for(int j = i + 1; j < data.length; j++) {
        if(data[min] > data[j]) {
          min = j;
        }
      }
      int temp = data[i];
      data[i] = data[min];
      data[min] = temp;
    }
  }
  
  public void print(int[] data) {
    for(int i : data) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
