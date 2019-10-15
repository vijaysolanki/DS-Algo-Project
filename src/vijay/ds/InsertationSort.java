package vijay.ds;
import java.util.Arrays;

public class InsertationSort {


	public void print(int data[], String msg) {
		System.out.println(msg + "-> " + Arrays.toString(data));
	}
	
	
	public static void main(String[] args) {
		int data[] = {100,8,7,6,5,4,3,2,1};
		InsertationSort insertationSort = new InsertationSort();
		insertationSort.print(data, "Unsorted Array");
		insertationSort.insertationSort(data);
		insertationSort.print(data, "Sorted Array");
	}


	private void insertationSort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			for (int j = i; j > 0; j--) {
				if(data[j] < data[j-1])
				{
					int temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		}
		
	}
}
