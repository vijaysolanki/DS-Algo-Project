import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("bbba");
		list.add("abba");
		list.add("acaa");
		list.add("aaac");
		strokesRequired(list);
		
	}

	
	 static int countSubarrays(int[] arr, 
	            int k) { 
		 int totalSubArray = 0; 
		  
		    for (int i = 0; i <= k - 1; i++) 
		    { 
		        int sum = 0; 
		        for (int j = i; j <= k - 1; j++) 
		        { 
		            sum = sum + arr[j]; 
		            if (sum % 2 == 0) 
		                    totalSubArray++; 
		        } 
		    } 
		  
		    return (totalSubArray); 
	    } 
	
	
	
	public static int strokesRequired(List<String> picture) {
		
		int[][] strock = new int[picture.size()][picture.get(0).length()];
		for (int j = 0; j< picture.size(); j++) {
			 char[] picArray = picture.get(j).toCharArray();
			 
			 for (int i = 0; i < picArray.length ; i++) {
				if(i+1 < picArray.length && picArray[i] != picArray[i+1] && j+1 < picture.size() && picture.get(j).toCharArray()[i]!= picture.get(j+1).toCharArray()[i+1])
				{
					strock[j][i]= 1;
				}
				else if (i != 0 && picArray[i-1] != picArray[i] && j != 0 && picture.get(j-1).toCharArray()[i] != picture.get(j).toCharArray()[i])
				{
					strock[j][i]= 1;
				}
			}
		}
		
		int totoalSt = 0;
		for (int[] is : strock) {
			for (int i : is) {
				if(i == 1)
				{
					totoalSt++;
				}

			}
		}
		return totoalSt;
	}

}
