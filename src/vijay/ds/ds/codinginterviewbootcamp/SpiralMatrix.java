package vijay.ds.ds.codinginterviewbootcamp;

import java.util.Arrays;

/**
		1	2	3
		8	9	4
		7	6	5
		
	 @author ashokv
*/
public class SpiralMatrix {
	static public void main(String ...args)
	{
		SpiralMatrix matrix = new SpiralMatrix();
		int dim = 5;
		matrix.printSpiralMatrix(dim);
	}
	
	public void printSpiralMatrix(int dim)
	{
		int[][] matrix = new int[dim][dim];
		
		int count = 1;
		int strRow = 0, endRow = dim -1, strClm = 0, endClm = dim -1;
		
		while(strRow <= endRow && strClm <= endClm)
		{
			// first row ( top row) 
			// 1	2	3
			//
			for(int i = strClm; i <= endClm; i++)
			{
				matrix[strRow][i] =  count;
				count++;
			}
			
			// ( rightmost side column )
			//		3
			//		4
			//		5			
			strRow++;
			for(int i = strRow; i <= endRow; i++)
			{
				matrix[i][endClm] = count;
				count++;
			}
			
			//bottom row
			//[7, 6, 5]
			endClm--;
			for(int i = endClm; i >= strClm; i--)
			{
				matrix[endRow][i] = count;
				count++;
			}
			
			//leftmost column
			// 1
			// 8
			// 7
			endRow--;
			for(int i = endRow; i >=strRow; i--)
			{
				matrix[i][strClm] = count;
				count++;
			}
			
			strClm++;
			
			for(int i = 0; i < dim; i++)
			{
				System.out.println(Arrays.toString(matrix[i]));
			}
			System.out.println("=====================");

		}
	}
	
}
