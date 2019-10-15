package vijay.ds;
import java.util.Arrays;

public class BubbleSort {
	
	
	
	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int data[] = {100,8,7,6,5,4,3,2,1};
		System.out.println( "Unsorted data: " + Arrays.toString(data));
		sort.bubbleSort(data);
		System.out.println("Sorted Data : " + Arrays.toString(data));
		
	}

	private void bubbleSort(int[] data) {
		int len = data.length -1;
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < (len) -i; j++) {
				if(data[j] > data[j+1])
				{
					int temp = data[j];
					data[j]= data[j+1];
					data[j+1]= temp;
				}
			}
		}
	}

	
	
	
}
