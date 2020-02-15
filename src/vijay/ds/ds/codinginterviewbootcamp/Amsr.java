package vijay.ds.ds.codinginterviewbootcamp;

public class Amsr {
		
	public static void main(String[] args) {
		Amsr amsr = new Amsr();
		System.out.println(amsr.isArmNumber(153));
	}
	
	public boolean isArmNumber(int num)
	{
	
		/***
		 *  153
		 *  sum = 0 +(3)cube
		 *  sum = (3)cube + (5)3
		 *  sum = (3)cube + (5)3 + (1)3
		 */
		int re = 0,sum = 0, temp = num;
		while(num > 0)
		{
			re = num%10;
			sum= sum+ (re*re*re);
			System.out.println(sum);
			num = num/10;
		}
		
		return temp == sum;
	}
}
