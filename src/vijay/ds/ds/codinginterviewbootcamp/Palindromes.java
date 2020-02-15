package vijay.ds.ds.codinginterviewbootcamp;

import java.util.Arrays;
/**
 * 
 * @author ashokv
 *	1. Using StringBuffer.reverse()
 *  2. Loops : charAt or toCharArray ( reverse looping)
 *  3. Using split() and reduce()
 */
public class Palindromes {
	public static void main(String[] args) {
		String str1 = "abcde!";
		String str2 = "!edcba";
		String str3 = "abcdef!";
		String str4 = "!fedcba";
		System.out.println(isPalindromes_1(str1, str2));
		System.out.println(isPalindromes_1(str1, str3));
		System.out.println(isPalindromes_1(str3, str4));
		System.out.println(isPalindromes_1(str2, str4));
		System.out.println("=============================");
		String str5 = "abba";
		String str6 = "aba";
		String str7 = "abcba";
		String str8 = "abcbav";
		System.out.println(isPalindromes_2(str5));
		System.out.println(isPalindromes_2(str6));
		System.out.println(isPalindromes_2(str7));
		System.out.println(isPalindromes_2(str8));
		System.out.println("=====================================");
		System.out.println(isPalindromes_3(str5));
		System.out.println(isPalindromes_3(str6));
		System.out.println(isPalindromes_3(str7));
		System.out.println(isPalindromes_3(str8));
	}
	
	public static boolean isPalindromes_1 (String str1, String str2)
	{
		boolean status = false;
		
		if(str1.length() == str2.length())
		{
			int i = 0;
			status = true;
			int length = str1.length() -1;
			while( i <= length && i != length -i)
			{
				if(str1.charAt(i) != str2.charAt(length - i))
				{
					status = false;
					return status;
				}
				i++;
			}
		}
		
		return status;
	}
	
	public static boolean isPalindromes_2 (String str)
	{
		boolean status = true;

		int i = 0;
		int length = str.length() - 1;
		while (/*i <= length &&*/ i < length - i) {
			if (str.charAt(i) != str.charAt(length - i)) {
				status = false;
				return status;
			}
			i++;
		}
	
		return status;
	}
	
	public static boolean isPalindromes_3(String str)
	{
		return Arrays.stream(str.split("")).reduce((s1, s2) -> s2+s1 ).get().equals(str);
	}
	
}
