package vijay.ds.ds.codinginterviewbootcamp;

/**
 * 
 * @author ashokv
 *
 *	1. Using StringBuffer, Charactor.toUpperCase() and subString()
 *	2. Using Array , Charactor.toUpperCase()
 *	3. Using StringBuffer.setCharAt() and Charactor.toUpperCase()
 *	4. Using split and String.replaceFirst()
 */
public class FirstCaptialLater {

	
	public static void main(String[] args) {

		FirstCaptialLater fcl = new FirstCaptialLater();
		String s = "world is great place!";
		fcl.print_1(s);
		fcl.print_2(s);
		fcl.print_3(s);
		fcl.print_4(s);
	}

	public void print_1(String s) {

		System.out.println("Using StringBuffer");
		String[] split = s.split("\\s");
		StringBuffer stringBuffer = new StringBuffer();

		for (String input : split) {
			Character charAt = input.charAt(0);
			char upperCase = Character.toUpperCase(charAt);
			String temp = input.length() - 1 >= 1 ? input.substring(1) : "";
			stringBuffer.append(upperCase).append(temp);
			stringBuffer.append(" ");
			/*StringBuffer buString = new StringBuffer(input);
			buString.setCharAt(0, upperCase);
			stringBuffer.append(buString);
			stringBuffer.append(" ");*/
		}

		System.out.println(stringBuffer.toString());
	}

	public void print_2(String s) {
		System.out.println("Using CharArray");
		char[] charArray = s.trim().toCharArray();
		int i = 0;
		while (i + 1 <= charArray.length ) {

			if (i == 0) {
				charArray[i] = Character.toUpperCase(charArray[i]);
			} else if (charArray[i] == ' ') {
				charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
			}

			i++;
		}

		System.out.println(new String(charArray));

	}

	public void print_3(String s) {
		System.out.println("Using setCharAt");
		int i = 0;
		StringBuffer sb = new StringBuffer(s);
		while (i + 1 <= s.length() ) {

			// Character.toString(c).equals("\\s")
			char charAt = sb.charAt(i);
			if (i == 0) {
				sb.setCharAt(i, Character.toUpperCase(charAt));
			} else if (charAt == ' ') {
				sb.setCharAt(i + 1, Character.toUpperCase(sb.charAt(i+1)));
			}
			i++;
		}

		System.out.println(sb.toString());

	}
	public void print_4(String str)
	{
		System.out.println("Using replaceFirst");
		for(String s: str.split("\\s"))
		{
			String upperCase = String.valueOf(s.charAt(0)).toUpperCase();
			s = s.replaceFirst(String.valueOf(s.charAt(0)), upperCase);
			System.out.print(s + " ");
		}
	}
}
