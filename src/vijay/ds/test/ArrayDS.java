package vijay.ds.test;

import java.util.Arrays;

public class ArrayDS {
  
  static class Array {
    public int[] add(int[] arr, int index, int value) {
      //index:  0,1,2,3,4,5,6
      //Array:  1,2,3,4,5,6,7
      //Update: 1,2,3,4,8,5,6,7
      //index = 4 and value = 8;
      int temp[] = new int[arr.length + 1];
      for(int i = 0; i < index; i++) {
        temp[i] = arr[i];
      }
      
      temp[index] = value;
      for(int i = index + 1; i < temp.length; i++) {
        temp[i] = arr[i - 1];
      }
      return temp;
    }
    
    public int search(int[] arr, int value) {
      for(int i = 0; i < arr.length; i++) {
        if(arr[i] == value) {
          return i;
        }
      }
      return -1;
    }
    
    public int[] delete(int[] arr, int value) {
      //index:  0,1,2,3,4,5,6
      //Array:  1,2,3,4,5,6,7
      //Update: 1,2,3,5,6,7
      // value = 4 (index = 3 );
      
      int index = search(arr, value);
      
      if(index >= 0) {
        for(int i = index + 1; i < arr.length; i++) {
          arr[i - 1] = arr[i];
        }
      }
      else {
        return null;
      }
      return Arrays.copyOf(arr, arr.length - 1);
    }
  }
  
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    System.out.println("existing array : " + Arrays.toString(arr));
    
    Array objA = new Array();
    int[] add = objA.add(arr, 4, 8);
    System.out.println("new  array : " + Arrays.toString(add));
    
    System.out.println("search found : " + objA.search(arr, 17));
    System.out.println("removing element : " + Arrays.toString(objA.delete(arr, 4)));
  }
}
