package vijay.ds.ds.codinginterviewbootcamp;

import java.util.Arrays;

public class MergeSort {

  
  static public int[] merge(int[] left, int[] right) {
    int merged[] = new int[left.length + right.length];
    int loop = 0, i = 0, j = 0;
    System.out.println("Left : " + Arrays.toString(left));
    System.out.println("Right : " + Arrays.toString(right));
    while(loop < merged.length && i < left.length && j < right.length) {
      if(left[i] < right[j]) {
        merged[loop] = left[i];
        i++;
        loop++;
      }
      else {
        merged[loop] = right[j];
        j++;
        loop++;
      }
    }
    
    while(i < left.length) {
      merged[loop] = left[i];
      i++;
      loop++;
    }
    
    while(j < right.length) {
      merged[loop] = right[j];
      j++;
      loop++;
    }

    System.out.println("Merged : " + Arrays.toString(merged));
    return merged;
  }
  
  static public int[] mergeSort(int a[]) {
    if(a.length == 1) {
      return a;
    }
    
    int mid = a.length / 2;
    //    int[] left = Arrays.copyOfRange(a, 0, mid);
    //    int[] right = Arrays.copyOfRange(a, mid, a.length);
    return merge(mergeSort(Arrays.copyOfRange(a, 0, mid)), mergeSort(Arrays.copyOfRange(a, mid, a.length)));
  }
  
  public static void main(String[] args) {
    int arr[] = {8, 3, 9, 2, 4, 6, 0, 1, -9};
    
    System.out.println("Orinal array: " + Arrays.toString(arr));
    System.out.println("Sorted array: " + Arrays.toString(mergeSort(arr)));
  }
}
