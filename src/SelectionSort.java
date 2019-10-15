import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args) {
		int data[] ={1,5,4,9,2,0,3};
		print(data);
		sort(data);
		print(data);
		
	}
	
	public static void print(int[] data)
	{
		System.out.println(Arrays.toString(data));
	}
	
	public static void sort(int[] data)
	{
		for (int i = 0; i < data.length ; i++) {
			int min = i;
			for (int j = i+1; j < data.length ; j++) {
				if (data[min] > data[j]) {
					min = j;
				}
			}
			int temp = data[i];
			data[i] = data[min];
			data[min] = temp;
		}
	}
}
