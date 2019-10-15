import java.util.Arrays;

public class BubbleSort {
	
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
	
	public static void sort(int[] data) {
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length -1 -i; j++) {
				if(data[j] > data[j+1])
				{
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
		
	}
}
