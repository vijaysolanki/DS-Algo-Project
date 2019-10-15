import java.util.Arrays;

/**
 * // 12345 -> left shift 4 elements -> 51234 
 * @author ashokv
 *
 */
public class LeftRotateArray {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(rotLeft(a, 4)));
	}

	static int[] rotLeft(int[] a, int d) {

		int temp[] = new int[a.length];
		int i = 0, j = d;
		while (j < a.length) {
			temp[i++] = a[j++];
		}
		int p = 0;
		while (p < d) {
			temp[i++] = a[p++];
		}
		return temp;

	}
}
