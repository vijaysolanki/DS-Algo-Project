package vijay.ds.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrChunking {

	public static void main(String... args) {
		ArrChunking arrChunking = new ArrChunking();
		arrChunking.buildChunks_1(new int[] { 1, 2, 3, 4, 5 }, 2);
		arrChunking.buildChunks_2(new int[] { 1, 2, 3, 4, 5 }, 2);
	}

	private void buildChunks_2(int[] arr, int size) {
		System.out.println("Using Array");
		int tmp[][] = new int[arr.length/2+arr.length%2][size];
		int i  = 0, j = 0;
		while( i < arr.length)
		{
			tmp[j] = getChunks(arr,size, i);
			j++;
			i = i + size;
		}
		
		i = 0; j = 0;
		
		while( i < arr.length)
		{
			int[] copyOfRange = Arrays.copyOfRange(arr, i, i+size);
			System.out.println("Inbuilt Cpy function: " + Arrays.toString(copyOfRange));
//			tmp[j] = getChunks(arr,size, i);
			j++;
			i = i + size;
		}
		
		for(int []a : tmp )
		{
			System.out.println(Arrays.toString(a));
		}
	}

	private int[] getChunks(int[] arr, int size, int position) {
		int temp[] = new int[size];
		int i = 0;
		while(i < size && position < arr.length)
		{
			temp[i] = arr[position];
			i++;
			position++;
		}
		return temp;
	}

	public void buildChunks_1(int[] array, int size) {
		System.out.println("Using ArrayList");
		int pslChnks = (array.length / 2) + (array.length % 2);

		List<List<Integer>> chunks = new ArrayList<>();

		for (int i : array) {
			List<Integer> list = !chunks.isEmpty() ? chunks.get(chunks.size() - 1) : null;

			if(null == list || list.size() == size)
			{
				list = new ArrayList<>();
				list.add(i);
				chunks.add(list);
			} else {
				list.add(i);
			}

		}
		chunks.forEach(ch -> System.out.println(ch));
	}
}
