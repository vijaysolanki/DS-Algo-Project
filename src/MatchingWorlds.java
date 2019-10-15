import java.util.Hashtable;

import org.omg.CORBA.OMGVMCID;

/**
 * Match words of givens arrays and see if any duplicate is present.
 * 
 * @author ashokv
 *
 */
public class MatchingWorlds {

	public static void main(String[] args) {

		String[] note = "give one  grand today".split("\\s+");
		String[] magazine = "give  me one grand today night".split("\\s+");
		// String[] notes = "two times two is four".split("\\s+");
		// String[] magazine = "two times three is not four".split("\\s+");

		/*
		 * for (int i = 0; i < notes.length; i++) { boolean found = false; for
		 * (int j = 0; j < magazine.length; j++) {
		 * if(notes[i].equals(magazine[j])) { magazine[j] = ""; found = true;
		 * break; } }
		 * 
		 * if(!found) { System.out.println("NO"); return; } }
		 * System.out.println("Yes");
		 */

		Hashtable<String, Integer> counters = new Hashtable<String, Integer>();
		for (String key : magazine) {
			Integer integer = counters.get(key);
			counters.put(key, null != integer ? integer.intValue()+1:1);
		}
		
		for (String key : note) {
			
			Integer integer = counters.get(key);
			if(null == integer || integer <= 0)
			{
				System.out.println("No");
				return;
			}	
			if(integer >= 1)
			{
				counters.put(key, integer.intValue()-1);
			}
			
		}
		
		System.out.println("Yes");

	}
}
