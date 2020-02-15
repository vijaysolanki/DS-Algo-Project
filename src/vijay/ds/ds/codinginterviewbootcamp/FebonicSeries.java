package vijay.ds.ds.codinginterviewbootcamp;

import java.util.*;

public class FebonicSeries {

	public static void main(String... args) {
		FebonicSeries feb = new FebonicSeries();
		int size = 50;
//		feb.feb_1(size);
		
		long[] ar = new long[size];
		ar[0] = 0;
		ar[1] = 1;
		feb.feb_2(size, ar, 2);
	}

	public void feb_1(int size) {
		System.out.println("Using iterative:Arrays ");
		long[] feb = new long[size];
		feb[0] = 0;
		feb[1] = 1;

		for (int i = 2; i < size; i++) {
			feb[i] = feb[i - 1] + feb[i - 2];
		}

		System.out.println(Arrays.toString(feb));

		System.out.println("Requested Nth " + size + " Feb element :" + feb[size - 1]);
	}

	public void feb_2(int size, long feb[], int index) {
		if (index >= size) {
			System.out.println("Using Recursion");
			System.out.println(Arrays.toString(feb));

			System.out.println("Requested Nth " + size + " Feb element :" + feb[size - 1]);
			return;
		}

		feb[index] = feb[index - 1] + feb[index - 2];
		feb_2(size, feb, index + 1);

	}
}
