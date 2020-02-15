package vijay.ds.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnagramString {

	public static void main(String... strings) {
		AnagramString an = new AnagramString();
		boolean anagram = an.isAnagram_1("Hello123!", "321!ollleh67");
		System.out.println(anagram);
		anagram = an.isAnagram_2("Hello123!", "321!olleh67");
		System.out.println(anagram);
		anagram = an.isAnagram_3("Hello123!", "321!ollleh");
		System.out.println(anagram);
	}

	private boolean isAnagram_3(String str1, String str2) {
		str1 = str1.toLowerCase().replaceAll("\\W", ""); // replace any symbol keep only alphnumeric values
		str1 = Arrays.stream(str1.split("")).sorted().reduce((s1,s2)->s1+s2).get();
		str2 = str2.toLowerCase().replaceAll("[^//a-z0-9]", "");
		str2 = Arrays.stream(str2.split("")).sorted().reduce((s1,s2)-> s1+s2).get();
		return str1.equals(str2);
	}

	

	public boolean isAnagram_2(String str1, String str2) {

		char[] c1 = str1.toLowerCase().replaceAll("[^/a-z]", "").toCharArray();
		Arrays.sort(c1);
		char[] c2 = str2.toLowerCase().replaceAll("[^/a-z]", "").toCharArray();
		Arrays.sort(c2);

		return Arrays.equals(c1, c2);
	}

	public boolean isAnagram_1(String str1, String str2) {
		boolean status = false;

		str1 = str1.toLowerCase().replaceAll("[^/a-z]", "").trim();
		str2 = str2.toLowerCase().replaceAll("[^//a-z]", "").trim();

//		if (str1.length() != str2.length()) {
//			return status;
//		}

		Map<String, Integer> m1 = new HashMap<>();
		Map<String, Integer> m2 = new HashMap<>();

		fillMap(str1, m1);
		fillMap(str2, m2);

		Set<String> set1 = m1.keySet();
		Set<String> set2 = m2.keySet();
		if (set1.size() != set2.size()) {
			return status;
		} else {
			return isContais(m1,m2) && isContais(m2,m1);
		}
	}

	private boolean isContais(Map m1, Map m2) {
		Set<String> set1 = m1.keySet(), set2 = m2.keySet();
		
		for (String s : set1) {
			if (!set2.contains(s)) {
				return false;
			}
			if(m1.get(s) != m2.get(s))
			{
				return false;
			}
		}
		return true;
	}

	private void fillMap(String str1, Map<String, Integer> m1) {
		for (String s : str1.split("")) {
			Integer integer = m1.get(s);
			if (null == integer) {
				m1.put(s, 1);
			} else {
				m1.put(s, integer + 1);
			}
		}
	}

}
