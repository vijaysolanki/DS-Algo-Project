import java.util.Arrays;

public class InsertationSort {
	
	public static void main(String[] args) {
		int data[] = {100,8,7,6,5,4,3,2,1};
		sort(data);
		print(data);
	}
	
	
	public static void print(int data[]) {
		System.out.println( Arrays.toString(data));
	}

	public static void sort(int[] data)
	{
		for (int i = 1; i < data.length; i++) {
			for (int j = i; j > 0; j--) {
				if(data[j] < data[j-1])
				{
					int tmp = data[j];
					data[j]= data[j-1];
					data[j-1]= tmp;
				}
			}
//			print(data);
		}
	}
}
