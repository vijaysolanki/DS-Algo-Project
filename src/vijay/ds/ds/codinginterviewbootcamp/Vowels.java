package vijay.ds.ds.codinginterviewbootcamp;

/**
 * 1. Using split and String "aeiou" contains 
 * 2. Using Regular Expression ["^/a,e,i,o,u"] and replaceAll
 * 3. Using toCharArray and {'a','e','i','o','u'};
 * @author ashokv
 *
 */
public class Vowels {
	static public void main(String ... args)
	{
		Vowels vs = new Vowels();
		String s1 = "Hi There!";
		String s2 = "Why do you ask?";
		String s3 = "Why";
		System.out.println("+++++++++++++++++++Using loops+++++++++++++++++");
		vs.findVowels_1(s1);
		vs.findVowels_1(s2);
		vs.findVowels_1(s3);
		System.out.println("+++++++++++++++++++Using RegularExpression+++++++++++++++++++");
		vs.findVowels_2(s1);
		vs.findVowels_2(s2);
		vs.findVowels_2(s3);
		System.out.println("+++++++++++++++++++Using charArray+++++++++++++++++++");
		vs.findVowels_3(s1);
		vs.findVowels_3(s2);
		vs.findVowels_3(s3);
	}
	
	public void findVowels_1(String input)
	{
		
		String vowels = "aeiou";
		String []data = input.toLowerCase().split("");
		int num= 0;
		for(String c: data)
		{
			if(vowels.contains(c))
			{
				num++;
			}
		}
		System.out.println("'"+input+"'" +" has these many no of vowels :" + num );
	}
	
	
	
	public void findVowels_2(String input)
	{
		
		String temp=  input.replaceAll("[^/a,e,o,u,i]", "");
		System.out.println("'"+input+"'" +" has these many no of vowels :" + temp.length() );
		/*int count = 0;
		Pattern p = Pattern.compile("([aeiou])", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);
		while (m.find()) {
			count++;
		}
		System.out.println("'"+input+"'" +" has these many no of vowels &&&:" + count );*/
	}
	
	public void findVowels_3(String input)
	{
		char []data = input.toLowerCase().toCharArray();
		int num= 0;
		for(char c: data)
		{
			if(isVowels(c))
			{
				num++;
			}
		}
		System.out.println("'"+input+"'" +" has these many no of vowels :" + num );
	}

	private boolean isVowels(char c) {
		char vowels[] = {'a','e','i','o','u'};
		
		for (char d : vowels) {
			if(d == c)
			{
				return true;
			}
		}
		return false;
	}
}
