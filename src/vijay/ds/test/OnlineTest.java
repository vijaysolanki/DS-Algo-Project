package vijay.ds.test;

public class OnlineTest {
  
  public static void main(String[] args) {
    /* String s = "abcd";
    int left = 1;
    int right = 2;
    String leftShiftString = s.substring(left, s.length()) + s.substring(0, left);
    //"bcda" => dabc
    String rightShiftString = leftShiftString.substring(right, leftShiftString.length()) + leftShiftString.substring(0, right);
    System.out.println(rightShiftString);*/
    
    String data[] = {"life", "is", "not", "a", "bed", "of", "roses"};
    for(String string : data) {
      if(string.toCharArray().length % 2 == 0) {
        System.out.print(string + " ");
      }
      else {
        System.out.print(new StringBuffer(string).reverse() + " ");
      }
    }
    //    Arrays.stream(data).forEach(word -> {
    //      if(word.toCharArray().length / 2 == 0) {
    //        System.out.print(new StringBuffer(word).reverse() + " ");
    //      }
    //      else {
    //        System.out.print(word + " ");
    //      }
    //    });
  }
  
}
