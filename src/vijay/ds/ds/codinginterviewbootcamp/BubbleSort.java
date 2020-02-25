package vijay.ds.ds.codinginterviewbootcamp;

import java.util.Arrays;

/**
 * Find largest value and put it to end of array.
 * 
 * @author ashokv
 *
 */
public class BubbleSort {
  
  static public int[] sort(int[] arr) {

    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j + 1 < arr.length - i; j++) {
        if(arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
      }
      
    }
    return arr;
  }
  
  public static void main(String[] args) {
    int arr[] = {9, 3, 8, 4, 6, 0, 1};
    

    System.out.println("Orinal array: " + Arrays.toString(arr));
    System.out.println("Sorted array: " + Arrays.toString(sort(arr)));
    
  }
}
