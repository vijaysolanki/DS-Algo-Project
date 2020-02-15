package vijay.ds.sorting.test;

public class BubbleSortDemo {
  
  public static void main(String[] args) {
    
    BubbleSort bSort = new BubbleSort();
    int data[] = {12, 6, 8, 2, 20, 9, 7};
    bSort.print(data);
    bSort.bubbleSort(data);
    bSort.print(data);
  }
  
}


class BubbleSort {
  public void bubbleSort(int arr[]) {
    int len = arr.length - 1;
    
    for(int i = 0; i < len; i++) {
      for(int j = 0; j < len - i; j++) {
        if(arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
        System.out.print("i : " + i + " J: " + j + "->");
        this.print(arr);
      }
      System.out.println("After iteration " + i + " sorted array : ");
      //      this.print(arr);
    }
  }
  
  public void print(int[] data) {
    for(int i : data) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
