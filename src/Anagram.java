import java.util.Arrays;

/**
 * Two strings are called anagrams if they contain same set of characters but in different order.
 * 
 * @author ashokv
 *
 */
public class Anagram {
	
	public static void main(String[] args) {
		String data[] = {"keep","peek", "Mother In Law", "Hitler Woman"};
		
		
		System.out.println("First Set : " + checkAnagram(data[0],data[1]));
		System.out.println("Second Set : " + checkAnagram(data[2],data[3]));
		
	}

	private static boolean checkAnagram(String f, String s) {
		char[] fCharArray = f.replaceAll("\\s+", "").toLowerCase().toCharArray();
		char[] sCharArray = s.replaceAll("\\s+", "").toLowerCase().toCharArray();
		Arrays.sort(fCharArray);
		Arrays.sort(sCharArray);
		return Arrays.equals(fCharArray, sCharArray);
		
		
	}
}
