package vijay.ds.ds.codinginterviewbootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Convert array to smaller chunks of given size.
 * 
 * @author ashokv
 *
 *         1. Using Array 2. Using ArrayList 3. Arrays.copyOfRange
 */
public class ArrayChunking {

	public static void main(String... ars) {
		ArrayChunking arrayChunking = new ArrayChunking();
		int[] arr = { 1, 2, 3, 4, 5 };
		int size = 2;
    arrayChunking.printChunks_1(arr, size);
    arrayChunking.printChunks_2(Arrays.asList(1, 2, 3, 4, 5), size);
    arrayChunking.printArrayChunk_3(arr, size);
	}

	public void printChunks_2(List<Integer> list, int size) {
		System.out.println("Using List");
		List<List<Integer>> listOfchunks = new ArrayList<>();

		int i = 0;
		List<Integer> existingChunk = null;
		while (i <= list.size() - 1) {
			existingChunk = !listOfchunks.isEmpty() ? listOfchunks.get(listOfchunks.size() - 1) : null;
			if (null == existingChunk || existingChunk.size() == size) {
				List<Integer> newChunk = new ArrayList<>();
				newChunk.add(list.get(i));
				listOfchunks.add(newChunk);
			} else {
				existingChunk.add(list.get(i));
			}

			i++;
		}

		listOfchunks.forEach((ch) -> System.out.println(ch));
	}

	public void printChunks_1(int[] arr, int chunkSize) {
		System.out.println("Using Array");
		int size = arr.length / chunkSize;
		int reminder = arr.length % chunkSize;
		System.out.println("Input Array :  " + Arrays.toString(arr) + ", with size of " + arr.length);
		System.out.println("Totoal Chunked ArraySize : " + (size + reminder));
		int[][] chunkedArray = new int[size + reminder][chunkSize];

		int i = 0, j = 0;
		while (i <= arr.length - 1) {
			int[] arrayChunk = getArrayChunk(arr, chunkSize, i);
			chunkedArray[j] = arrayChunk;
			i = i + chunkSize;
			j++;
		}

		for (i = 0; i <= chunkedArray.length - 1; i++) {
			System.out.println(Arrays.toString(chunkedArray[i]));
		}
	}

	private int[] getArrayChunk(int[] arr, int chunkSize, int startPosition) {
		int[] temp = new int[chunkSize];
		int i = 0;
		while (i < chunkSize && startPosition <= arr.length - 1) {
			temp[i] = arr[startPosition];
			i++;
			startPosition++;
		}
		return temp;
	}
	
  private static void printArrayChunk_3(int[] arr, int size) {
    
    int[][] temp = new int[arr.length / size + arr.length % size][size];
    int i = 0, j = 0, pos = size;
    while(i < arr.length) {
      int[] copyOfRange = Arrays.copyOfRange(arr, i, pos);
      temp[j] = copyOfRange;
      j++;
      i = i + size;
      pos = i + size;
    }
    for(i = 0; i <= temp.length - 1; i++) {
      System.out.println(Arrays.toString(temp[i]));
    }
    
  }
}
