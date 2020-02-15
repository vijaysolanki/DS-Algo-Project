package vijay.ds.ds.codinginterviewbootcamp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * 
 * @author ashokv
 *	1. Using StringBuffer : 
 *	2. Using split() and reduce() :
 *	3. Using charAt() :
 *	4. Using toCharArray() : 
 *	5. Using Temp variable :
 */

public class StringReverse {
	public static void main(String[] args) {
		StringReverse stringReverse = new StringReverse();
		String str =  "abcdef!";
		System.out.println("Actualy String :  " + str);
		stringReverse.reverseString_1(str);
		stringReverse.reverseString_2(str);
		stringReverse.reverseString_3(str);
		stringReverse.reverseString_4(str);
		stringReverse.reverseString_5(str);
		
	}
	
	public void reverseString_1(String str)
	{
		System.out.print("Using StringBuffer : ");
		System.out.println(new StringBuffer(str).reverse());
		
	}
	
	public void reverseString_2(String str)
	{
		System.out.print("Using split() and reduce() : ");
		String[] split = str.split("");
		BinaryOperator<String> biOper = (s1, s2) -> s2+s1;
		Optional<String> reduce = Arrays.stream(split).reduce(biOper);
		System.out.println(reduce.get());
		Optional<String> min = Arrays.stream(split).min(Comparator.naturalOrder());
		System.out.println("min " + min);
	}
	
	public void reverseString_3(String str)
	{
		System.out.print("Using charAt() : ");
		int i = str.length() -1;
		while(i >= 0)
		{
			System.out.print(str.charAt(i));
			i--;
		}
		System.out.println();
	}
	
	public void reverseString_4(String str)
	{
		System.out.print("Using toCharArray() : ");
		char[] charArray = str.toCharArray();
		int i = charArray.length -1;
		while(i >= 0)
		{
			System.out.print(charArray[i]);
			i--;
		}
		System.out.println();
	}
	
	public void reverseString_5(String str)
	{
		System.out.print("Using Temp variable : ");
		String reverse = "";
		
		for(char s : str.toCharArray())
		{
			reverse = s + reverse;
		}
		System.out.println(reverse);
	}
	
	
}
