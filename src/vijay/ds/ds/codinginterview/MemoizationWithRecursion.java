package vijay.ds.ds.codinginterview;

import java.util.HashMap;
import java.util.Map;

public class MemoizationWithRecursion {
	
	
	Map<Integer, Integer> cache = new HashMap<>();
	
	public static void main(String ... args)
	{
		MemoizationWithRecursion memo = new MemoizationWithRecursion();
		int size = 6;
		System.out.println (memo.feb(size -1 ));
	}
	
	public int feb(int size)
	{
		if(size < 2)
		{
//			System.out.println(size);
			return size;
		}
		
		if(cache.containsKey(size))
		{
			return cache.get(size);
		}
		
		int result = feb(size -1) + feb(size -2);
		cache.put(size, result);
		return result;
	}
	
	
}
