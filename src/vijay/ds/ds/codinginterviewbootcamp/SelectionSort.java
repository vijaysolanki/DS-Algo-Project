package vijay.ds.ds.codinginterviewbootcamp;

import java.util.Arrays;

/**
 * record the min value index and try to find any value which min to this min indexed value
 * 
 * @author ashokv
 *
 */
public class SelectionSort {
  
  public static int[] sort(int[] arr) {

    for(int i = 0; i < arr.length; i++) {
      int min = i;
      for(int j = i + 1; j < arr.length; j++) {
        if(arr[min] > arr[j]) {
          min = j;
        }
      }
      if(min != i) {
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
        System.out.println(Arrays.toString(arr));
      }
    }
    return arr;
  }
  
  public static void main(String[] args) {
    int arr[] = {8, 3, 9, 2, 4, 6, 0, 1, -9};
    
    System.out.println("Orinal array: " + Arrays.toString(arr));
    System.out.println("Sorted array: " + Arrays.toString(sort(arr)));
  }
}
