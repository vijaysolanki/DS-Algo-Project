package vijay.codility.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CountPassedGroups {
	public static void main(String[] args) {
		String T[] = new String[] { "test1a", "test2", "test1b", "test1c", "test3" };
		String R[] = new String[] { "Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded" };
		int solution = solution(T, R);
		System.out.println("Results :  " + solution);
	}

	public static int solution(String[] T, String[] R) {
		Map<String, List<Boolean>> groupResults = new HashMap<>();

		int i = 0;
		while (i < T.length) {
			String testcase = T[i];
			int digitIndex = getDigitIndex(testcase);

			// simple name
			if (digitIndex < 0) {
				List<Boolean> list = groupResults.get(testcase);
				if (null == list) {
					list = new ArrayList<>();
				}

				if (R[i].equals("OK")) {
					list.add(true);

				} else {
					list.add(false);
				}
				groupResults.put(testcase, list);
			} else {
				String modifiedTestcase = digitIndex + 1 < testcase.length()
						? new StringBuffer(testcase).replace(digitIndex + 1, testcase.length(), "-").toString()
						: testcase;

				List<Boolean> list = groupResults.get(modifiedTestcase);
				if (null == list) {
					list = new ArrayList<>();
				}
				if (R[i].equals("OK")) {
					list.add(true);
				} else {
					list.add(false);

				}
				groupResults.put(modifiedTestcase, list);
			}
			i++;

		}
		int totalGroups = groupResults.keySet().size();
		int passed = 0;
		
		for (String group : groupResults.keySet()) {
			List<Boolean> list = groupResults.get(group);
			if(!list.contains(false))
			{
				passed++;
			}
		}

		return ((passed * 100) / totalGroups);
	}

	private static int getDigitIndex(String testcase) {

		int i = 0;
		while (i < testcase.length()) {
			if (testcase.charAt(i) > 48 && testcase.charAt(i) < 58) {
				return i;
			}
			i++;
		}
		return -1;
	}

}
