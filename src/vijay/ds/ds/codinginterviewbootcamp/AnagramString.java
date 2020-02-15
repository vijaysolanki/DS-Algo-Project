package vijay.ds.ds.codinginterviewbootcamp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

/**
 * characters of string are same and equals and no special or space is considered.
 * @author ashokv
 *
 *	1. Using Array Utility Method ( replaceAll and sort)
 *	2. Using Map
 *	3. Using String Utility Method ( replaceFirst )
 *	4. Using Stream ( sort and reduce() )
 */
public class AnagramString {
	
	public static void main(String ...args)
	{
		String s1 = "rail safety !!!";
		String s2= "there hello ";
		String s3= "!!! fairy tales";
		
		AnagramString ann = new AnagramString();
		
		System.out.println(ann.isAnagram_1(s1, s2));
		System.out.println(ann.isAnagram_1(s1, s3));
		System.out.println(ann.isAnagram_2(s1, s2));
		System.out.println(ann.isAnagram_2(s1, s3));
		System.out.println(ann.isAnagram_3(s1, s2));
		System.out.println(ann.isAnagram_3(s1, s3));
		System.out.println(ann.isAnagram_4(s1, s2));
		System.out.println(ann.isAnagram_4(s1, s3));
	}
	
	public boolean isAnagram_1(String s1, String s2)
	{
		System.out.print("Using Arrays Utility Methods(  " +s1 + " , " + s2 +" ) : " );
		boolean status = false;
		
		if(s1.length() == s2.length())
		{
			String tempS1 = s1.toLowerCase().replaceAll("[^\\w]", "");
			String tempS2 = s2.toLowerCase().replaceAll("[^/a-zA-Z0-9]", "");
//			System.out.println("asfa" + s1);
			char[] s1Arr = tempS1.toCharArray();
			Arrays.sort(s1Arr);
			char[] s2Arr = tempS2.toCharArray();
			Arrays.sort(s2Arr);
			return Arrays.equals(s1Arr, s2Arr);
		}
		return status;
	}
	
	public boolean isAnagram_2(String s1, String s2)
	{
		System.out.print("Using Map (  " +s1 + " , " + s2 +" ) : " );
		boolean status = false;
		if(s1.length() != s2.length())
		{
			return status;
		}

		String tempS1 = s1.replaceAll("[^\\w]","");
		String tempS2 = s2.replaceAll("[^/a-zA-Z0-9]", "");
		Map<Character, Integer> m1 = fillAndReturnMap(tempS1);
		Map<Character, Integer> m2 = fillAndReturnMap(tempS2);
		
		if(m1.keySet().size() == m2.keySet().size())
		{
			Set<Entry<Character, Integer>> entrySet = m1.entrySet();
			for(Entry<Character, Integer> entry :entrySet)
			{
				Character key = entry.getKey();
				Integer value1 = entry.getValue();
				Integer value2 = m2.get(key);
				
				if(null == value2 ||  value1 != value2 )
				{
					return status = false;
				}
				status = true;
			}
		}
		
		return status;
	}
	
	public Map<Character, Integer> fillAndReturnMap(String s)
	{

		Map<Character, Integer> map= new HashMap<>();
		
		if(null == s || s.isEmpty())
		{
			return map;
		}
			
		int i = 0;
		int len = s.length() -1;
		while( i <= len)
		{
			char charAt = s.charAt(i);
			Integer value = map.get(charAt);

			if(null != value)
			{
				value = value +1;
				map.put(charAt, value);
			}
			else
			{
				map.put(charAt, 1);
			}
			
			i++;
		}
		return map;
	}
	
	public boolean isAnagram_3(String s1, String s2)
	{
		System.out.print("Using String Utility (  " +s1 + " , " + s2 +" ) : " );
		boolean status = false;
		if(s1.length() != s2.length())
		{
			return status;
		}

		String tempS1 = s1.replaceAll("[^\\w]","");
		String tempS2 = s2.replaceAll("[^/a-zA-Z0-9]", "");
		
		int i  = 0;
		while(i <= tempS1.length() -1)
		{
			char ch = tempS1.charAt(i);
			
			tempS2 = tempS2.replaceFirst(ch+"", "");
			i++;
		}
		
		return status = tempS2.isEmpty();
	}

	public boolean isAnagram_4(String s1, String s2)
	{
		System.out.print("Using Steams  (  " +s1 + " , " + s2 +" ) : " );
		boolean status = false;
		if(s1.length() != s2.length())
		{
			return status;
		}

		Stream<String> sorted = Stream.of(s1.split("")).sorted();
		String tempS1 = sorted.reduce( (s11, s22) -> s11+s22).get();
		String tempS2 = Stream.of(s2.split("")).sorted().reduce( (s11, s22) -> s11+s22).get();
	
		/* char[] charArray = s1.replaceAll("[^\\w]","").toLowerCase().toCharArray();
		Arrays.sort(charArray);
		String tempS1 = new String (charArray);

		 charArray = s2.replaceAll("[^\\w]","").toLowerCase().toCharArray();
			Arrays.sort(charArray);
			String tempS2 = new String (charArray);
		*/
		return tempS2.equals(tempS1);
	}

}
