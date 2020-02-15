package vijay.ds.ds.codinginterviewbootcamp;

import java.util.HashMap;
import java.util.Map;

public class MemoizationWithRecursion {
	
	
	Map<Long, Long> cache = new HashMap<>();
	
	public static void main(String ... args)
	{
		MemoizationWithRecursion memo = new MemoizationWithRecursion();
		long size = 50;
		System.out.println (memo.feb(size -1));
	}
	
	public Long feb(Long size)
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
		
		long result = feb(size -1) + feb(size -2);
		cache.put(size, result);
		return result;
//		return feb(size -1) + feb(size -2);
	}
	
	
}
