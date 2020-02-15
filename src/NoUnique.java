import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoUnique {
    public static void main(String[] args) {
      ArrayList<Integer> arrayList = new ArrayList<Integer>();
      arrayList.add(1);
      arrayList.add(2);
      arrayList.add(3);
      arrayList.add(4);
      arrayList.add(5);
      arrayList.add(6);
      arrayList.add(1);
      System.out.println(countNonUnique(arrayList));
      
    }
    
    public static int countNonUnique(List<Integer> numbers) {
      int counter = 0;
      
      Map<Integer,Integer> elements = new HashMap<>();
      
      for(Integer num : numbers) {
        Integer cont = elements.get(num);
        
        if(null == cont)
        {
          elements.put(num, 1);
        }
        else
        {
          elements.put(num, (cont.intValue()+1));
        }
      }
      
      for(Integer num: elements.keySet())
      {
        Integer count = elements.get(num);
        if( (count.intValue() > 1))
        {
          counter = counter +1;
        }
      }
      
      return counter;
    }
    
}
