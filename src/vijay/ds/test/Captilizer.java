package vijay.ds.test;

public class Captilizer {
	public static void main(String ...strings )
	{
		new Captilizer().cap_1("hello how are you");
		new Captilizer().cap_2("hello how are you");
	}
	
	private void cap_2(String string) {
		System.out.println("-----------");
		for(int i =0; i < string.length();i++)
		{
			char charAt = string.charAt(i);
			if(i == 0 )
			{
				System.out.print(String.valueOf(charAt).toUpperCase());
			}
			else
			{
			System.out.print(charAt);
			 if( charAt == ' ')
			 {
				 System.out.print(String.valueOf(string.charAt(++i)).toUpperCase());
			 }
			}
		}
		
	}

	public void cap_1(
			String str)
	{
		for(String s: str.split("\\s"))
		{
			String upperCase = String.valueOf(s.charAt(0)).toUpperCase();
			s = s.replaceFirst(String.valueOf(s.charAt(0)), upperCase);
			System.out.print(s + " ");
		}
	}
}
