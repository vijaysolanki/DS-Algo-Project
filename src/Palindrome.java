import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Palindrome Program in Java. Palindrome number in java: A palindrome number is
 * a number that is same after reverse. For example 545, 151, 34543, 343, 171,
 * 48984 are the palindrome numbers
 * 
 * @author ashokv
 *
 */
public class Palindrome {
		public static void main(String[] args) {
			
			System.out.println("===================Number ==========================");
			Scanner sc = new Scanner(System.in);
			int nextInt = sc.nextInt();
			int temp = nextInt;
			int r = 0, s = 0;
			
			while ( temp > 0)
			{
				r = temp%10;
				temp = temp/10;
				s =s*10+r;
			}
			System.out.println( "Palindrome Status : " + (s==nextInt));
			
			System.out.println("===================String ==========================");
			String input =  "abba";
			System.out.println(new StringBuffer(input).reverse().toString().equals(input));
			
		}
}
