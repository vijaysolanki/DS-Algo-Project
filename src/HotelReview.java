import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HotelReview {
  public static void main(String[] args) {
    ArrayList<Integer> id = new ArrayList<>();
    id.add(3);
    id.add(5);
    id.add(19);
    
    ArrayList<String> reviews = new ArrayList<>();
    reviews.add("this hotel is good and nice");
    reviews.add("this hotel is good and nice and near, not");
    reviews.add("not not not, good");
    
    System.out.println(awardTopKHotels("good near nice", "not", id, reviews, 3));
  }
  
  public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds,
                                              List<String> reviews, int k) {
    
    String[] pos = positiveKeywords.toLowerCase().split("\\s+");
    String[] neg = negativeKeywords.toLowerCase().split("\\s+");
   
    Map<Integer, Integer> hoteRatingWithId = new TreeMap<Integer, Integer>();
    for(int i =0 ; i < hotelIds.size();i++) {
      int posComments = 0;
      int negComments = 0;
      
      int posWords = findMatchWords(pos, reviews.get(i).toLowerCase());
      posComments = posComments + posWords;
      
      
      int negWords = findMatchWords(neg, reviews.get(i).toLowerCase());
      negComments = negComments + negWords;
      
       int value = ((3*posComments) - (1*negComments));
      hoteRatingWithId.put(value, hotelIds.get(i));
    }
    List<Integer> list = new ArrayList();
    List<Integer> values = hoteRatingWithId.values().stream().sorted().collect(Collectors.toList());
    
    int i = 1;
    for(Integer integer : values) {
      if(i > k)
      {
        break;
      }
      list.add(integer);
      i++;
    }
    return list;
//    return values.subList(0, k);
  }

  private static int findMatchWords(String[] pos, String review) {
    int count = 0;
    for(String p : pos) {
      Pattern compile = Pattern.compile(p);
      Matcher matcher = compile.matcher(review);
      int groupCount = matcher.groupCount();
      while(matcher.find())
      {
        String group = matcher.group();
        count++;
      }
      
    }
    return count;
  }
}
