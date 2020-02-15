package vijay.ds.ds.codinginterviewbootcamp;

/**
 * 
 * 1. Using loop
 * 2. Using recursion
 
		#  
		## 
		###

 * @author ashokv
 *
 *
 */
public class PrintSteps {
	
	public static void main(String ...args)
	{
		PrintSteps ps = new PrintSteps();
		int steps = 3;
		ps.printSteps_1(steps);
		System.out.println("Using recursion");
		ps.printSteps_2(steps, 0, new StringBuffer());
	}
	
	public void printSteps_1(int steps)
	{
		System.out.println("Using loops");
		for(int i= 1;i <= steps; i++)
		{
			for (int j = 1; j <= steps; j++) {
				
				if(j <= i)
				{
					System.out.print("#");
				}
				else 
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	
	/**
	 * // minimum args required for method
		// default values of args 
		// terminate condition ( if nothing to do return)
		// work to do, then dont forgot to call recursive method with changed values
	 * 
	 * 
	 * 
	 */
	public void printSteps_2(int steps, int row, StringBuffer sb)
	{
		//end of program nothing more to process
		if(steps == row)
		{
			return;
		}
		
		// one row is constructed
		if(sb.length() == steps)
		{
			System.out.println(sb);
			printSteps_2(steps, row+1, new StringBuffer());
			return;
		}
		
		if(sb.length() <= row)
		{
			sb.append("#");
		}
		else
		{
			sb.append(" ");
		}
		
		//process  the current row remaining part
		printSteps_2(steps, row, sb);
	}
	
}
