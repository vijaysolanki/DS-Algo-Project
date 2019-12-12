import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Rare {
    public static int nthMostRare(int[] elements, int n) {
    	
    	
       // throw new UnsupportedOperationException("Waiting to be implemented.");
    	Map<Integer, Integer> rareElements = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < elements.length; i++) {
    		int elmnt = elements[i];
			Integer storeEle = rareElements.get(elmnt);
			
			if(null == storeEle)
			{
				rareElements.put(elmnt, 1);
			}
			else 
			{
					rareElements.put(elmnt, storeEle+1 );
			}
		}
    	
    	Set<Entry<Integer, Integer>> entrySet = rareElements.entrySet();
    	for (Entry<Integer, Integer> entry : entrySet) {
			if(entry.getValue() == n)
			{
				return entry.getKey();
			}
		}
    	return 0;
    }

    public static void main(String[] args) {
        int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }
}