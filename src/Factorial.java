import java.util.Scanner;

public class Factorial {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int nextInt = sc.nextInt();
		int fac = 1;
		
		/*while(nextInt > 0)
		{
			fac = fac*nextInt--;
		}
		System.out.println("Factorial of " + nextInt + " is -> " + fac);*/
		
		int factorial = factorial(nextInt);
		
		System.out.println("Recursion : Factorial of " + nextInt + " is -> " + factorial);
	}

	private static int factorial(int nextInt) {
		if(nextInt == 1)
		{
			return 1;
		}
		
		return nextInt*factorial(--nextInt);
		
	}
}
