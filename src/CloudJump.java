import java.util.Scanner;


/**
 * Count min jump to reach top of the cloud.
 * 0100010
 * 1- is not safe cloud
 * 0- is safe cloud to jump
 * @author ashokv
 *
 */
public class CloudJump {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ptr = sc.next();
		
		
		int min = minJump(ptr);
		System.out.println("Min jump " + min);
	
 		
	}

	private static int minJump(String ptr) {
		int count = 0;
		int i = 0;
		while(i < ptr.length()-1 )
		{
			if(i+2 <= ptr.length() || ptr.charAt(i+2) == '1')
			{
				i++;
			}
			else
			{
				i=i+2;
			}
			count++;
		}
		return count;
	}
}
