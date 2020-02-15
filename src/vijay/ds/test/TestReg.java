package vijay.ds.test;

import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {
    public static void main(String[] args) {
      TestReg testReg = new TestReg();
      String number = "-1.2345678901";
      System.out.println(testReg.isvalidNumber(number));
    }
    
    
    /**
     * valid number (+ or - or float) 
     * @param number
     */
    public boolean isvalidNumber(String number)
    {
      String regex = "[+-]?[0-9]+(\\.[0-9]+)?([+-]?[0-9]+)?"; 
      Pattern compile = Pattern.compile(regex, Pattern.MULTILINE);
      Matcher matcher = compile.matcher(number);
      return matcher.matches();
    }
    
    
}
