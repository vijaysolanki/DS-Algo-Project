
public class CharCount {

	public static void main(String[] args) {
	  System.out.println(repeatedString("aba", 10));
	}

  static long repeatedString(String s, long n) {
    long totalNumberOfPossibleSubString = n / s.length();
    long remainingPartOfString = n % s.length();

		if (!s.contains("a"))
			return 0;
		return s.length() > n ? count(s, n) : totalNumberOfPossibleSubString * count(s, s.length()) + count(s, remainingPartOfString);
	}

  static long count(String s, long e) {
		int a = 0;
		for (int i = 0; i < e; i++) {
			if (s.charAt(i) == 'a')
				a++;
		}
		return a;
	}

}
