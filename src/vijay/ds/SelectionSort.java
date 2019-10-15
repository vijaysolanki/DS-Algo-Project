package vijay.ds;
import java.util.Arrays;

public class SelectionSort {


	public void print(int data[], String msg) {
		System.out.println(msg + "-> " + Arrays.toString(data));
	}

	public static void main(String[] args) {
		
		int data[] = {100,8,7,6,5,4,3,2,1};
		SelectionSort sort = new SelectionSort();
		sort.print(data, "Unsorted Array");
		sort.selectionSort(data);
		sort.print(data, "Sorted Array");
	}

	private void selectionSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int min = i;
			for (int j = i; j < data.length; j++) {
				if(data[min] > data[j])
				{
					min = j;
				}
			}
			int temp = data[min];
			data[min]= data[i];
			data[i]= temp;
		}
		
	}
}
