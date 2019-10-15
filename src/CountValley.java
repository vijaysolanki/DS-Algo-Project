import java.util.Scanner;

public class CountValley {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String ptr = sc.next();
			
			int valley = getValley(ptr);
			System.out.println("Valley :  " + valley);
			
		}
		
		
	
		public static int getValley(String ptr)
		{
			int valley = 0;
			int steps = 0;
			
			for (int i = 0; i < ptr.toLowerCase().length(); i++) {
				char stp = ptr.charAt(i);
				
				if(stp == 'u')
				{
					steps++;
				}
				else if(stp == 'd')
				{
					if(0 == steps){
						valley++;
					}
					steps--;
				}
			}
			return steps < 0 ? valley -1: valley ;
		}
		
}
