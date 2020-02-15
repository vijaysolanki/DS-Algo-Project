package vijay.ds.test;

import java.util.ArrayList;
import java.util.Arrays;

public class Funcation {
  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
   /* for(int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i));
    }*/
    arrayList.forEach(a -> System.out.println(a));
    Integer integer = arrayList.stream().reduce((a, b) -> a+b).get();
    System.out.println(integer);
    String name  = "Vijay solanki";
    /*for(int i = name.length() -1; i >= 0; i--) {
      char charAt = name.charAt(i);
      System.out.print(charAt);
    }*/
    String[] split = name.split("");
    System.out.println(Arrays.toString(split));
    String string = Arrays.stream(split).reduce((a, b)-> b+a).get();
    System.out.println(string);
  }
  public void test()
  {
    
    
    new Args() {
      
      @Override
      public void add() {
        
      }

//      @Override
//      public void sub() {
//        // TODO Auto-generated method stub
//        
//      }
    };
  }
}

//funcation interface
 interface Args 
{
  int i = 10;
  public abstract void add();
//  public abstract void sub();
  
}

/* class Imp implements Args
 {
   @Override
  public void add() {
    // TODO Auto-generated method stub
    
  }
 }*/