// package whatever; // don't place package name!
import java.util.*;

//suppose given array is :
//[-5,1,0,-2,-1,4,3,2,6,9,10,7,15,12]
// and maximum number of consecutive element array


import java.io.*;

public class MyCode {
	public static void main (String[] args) {
		System.out.println("Hello Java");
   // countDistancePos(4, 4);
   int [] values = new int[]{-5,1,0,-2,-1,4,3,2,6,9,10,7,15,12};
      consecutiveElements(values);
	}
  
  
  public static void consecutiveElements(int[] values)
  {
	  
	  int max = -1;  
	  List list = new ArrayList();
	for (int i = 0; i < values.length; i++) {
		List chnk = new ArrayList(); 
        int start = values[i];
        chnk.add(start);
        start++;
		for (int j = 0; j < values.length; j++) {
			if(start == values[j])
			{
				start++;
				chnk.add(start);
			}
		}
		list.add(chnk);
		if( -1  == max)
        {
          max = chnk.size();
        }
        
        if( max < chnk.size()) 
        {
          max = chnk.size();
        }
	}
	System.out.println(list);
	
	
  /*  Arrays.sort(values);
    int max = -1;
    for(int i = 0; i < values.length -1; )
    {
        List chnk = new ArrayList(); 
        int start = values[i];
        chnk.add(chnk);
        for (int j = i+1; j < values.length; j++)
        {
          if(++start == values[j])
          {
            chnk.add(values[j]);
          }  
          else 
          {
            if( -1  == max)
            {
              max = chnk.size();
            }
            
            if( max < chnk.size()) 
            {
              max = chnk.size();
            }
            //skip already verified elements
            i = j;
            break;
          }
        }
    }*/
    System.out.println("Max consecutiveElements size :" + max );       
  }
  
  
  
  
  public static  void  countDistancePos(int distance, int step)
  {
    // if( distance <=1)
    // {
    //   System.out.println(distance);
    // }
    
    //else
    {
      int combinations = 0;
      for(int i = 1; i < step; i++ )
      {
        int total =0;
        while(total <= distance)
        {
          total = total + i;  
        }
        
        if( total == distance && step > 1)
        {
           countDistancePos(distance,i);
          combinations ++;
        }
        
      }
      
      System.out.println("Total steps : " + combinations);
    }
  }
}

