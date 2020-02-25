package vijay.ds;
import java.util.Arrays;

public class ArrayOperations {
	public static void main(String[] args) {
			int data[] = {1,2,3,4,5,6,7,8};
			MyArray ar = new MyArray();
			ar.print(data);
			int[] newArry = ar.add(data, 3, -18);
			ar.print(newArry);
    int[] delete = ar.delete(newArry, 7);
			ar.print(delete);
	}
}

class MyArray {
	public int[] add(int[]data, int pos, int val)
	{
		int temp[] = new int[data.length+1];
		
		for(int i = 0; i < pos; i++)
		{
			temp[i] = data[i];
		}
		temp[pos] = val;
		//0,1,2,3
		//1,2,3,4 
		//1,2,6,3,4
		//POS->3, VAL ->6
		for(int i = pos+1; i < temp.length; i++)
		{
			temp[i]= data[i-1];
		}
		return temp;	
	}
	
	public void print(int[] arr)
	{
		System.out.println(Arrays.toString(arr));
	}
	
	public int search(int[] data, int val)
	{
		for (int i = 0; i < data.length; i++) {
			if(data[i] == val)
			{
				return i;
			}
		}
		return -1;
	}
	public int[] delete(int[] data, int val)
	{    //1,2,6,3,4
		int[] temp = new int[data.length -1];
		int index = search(data, val);
    if(index < 0) {
      return data;
    }
		for (int i = 0; i < index; i++) {
			temp[i] = data[i];
		}
		
    for(int i = index; i < temp.length; i++) {
			temp[i] = data[i+1];
		}
		
		return temp;
	}
}
