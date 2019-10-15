
public class CharCount {

	public static void main(String[] args) {
	  System.out.println(repeatedString("aba", 10));
	}

	static int repeatedString(String s, int n) {
		int totalNumberOfPossibleSubString = n / s.length();
		int remainingPartOfString = n % s.length();

		if (!s.contains("a"))
			return 0;
		return s.length() > n ? count(s, n) : totalNumberOfPossibleSubString * count(s, s.length()) + count(s, remainingPartOfString);
	}

	static int count(String s, int e) {
		int a = 0;
		for (int i = 0; i < e; i++) {
			if (s.charAt(i) == 'a')
				a++;
		}
		return a;
	}

}
