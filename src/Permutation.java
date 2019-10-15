
public class Permutation {

	public static void main(String... s) {
		String input = "abc";
		permutation(input,0,input.length() );
	}

	private static void permutation(String input, int start, int end) {
		if(start == end -1)
		{
			System.out.println(input);
		}
		else
		{
			for (int i = start; i < end; i++) {
				input = swap(input, start,i);
				permutation(input, start+1, end);
				input =swap(input, start, i);
			}
		}
		
	}

	private static String swap(String input, int i, int j) {
		char[] charArray = input.toCharArray();
		char c = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = c;
		
		return String.valueOf(charArray);
	}



}
