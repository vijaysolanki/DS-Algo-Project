package vijay.ds.ds.codinginterview;

import java.util.HashMap;
import java.util.Map;

public class MaxCharProgram {

	public static void main(String[] args) {
		MaxCharProgram maxCharProgram = new MaxCharProgram();
		maxCharProgram.maxChar("Hello How HHHareyou hoho?");
		maxCharProgram.maxChar("111JumanJi");

	}

	public void maxChar(String input) {
		
		Map<Character, Integer> holder = new HashMap<>();
		int length = input.length() - 1;
		int i = 0;
		int max = 1;
		char ch = '~';
		
		while (i <= length) {
			char charAt = input.charAt(i);
			Integer counter = holder.get(charAt);
			
			if (null != counter) {
				counter = counter + 1;
				holder.put(charAt, counter);
				if (counter > max) {
					max = counter;
					ch = charAt;
				}

			} else {
				holder.put(charAt, 1);
			}
			i++;
		}
		System.out.println("max repeated char : " + ch + ", number of times : " + max);

	}
}
