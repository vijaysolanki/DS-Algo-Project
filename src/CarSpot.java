import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class CarSpot {
  public static void main(String[] args) {
    List<Long> car = new ArrayList<>();
    car.add(6L);
    car.add(2L);
    car.add(12L);
    car.add(7L);
    System.out.println(carParkingRoof(car, 3));
  }
  
  public static long carParkingRoof(List<Long> cars, int k) {
    /*Write your code here
        2,8,10,17
        8-2 = 6
        10-8 = 2 = 9;
        
        -- 
        10 -8 = 2;
        17 - 10 = 7*/

     List<Long> sortedCars = cars.stream().sorted().collect(Collectors.toList());

     PriorityQueue<Long> queue = new PriorityQueue<>();
     while(sortedCars.size() > 0)
     {
       queue.add(getLenght(sortedCars, k));
       sortedCars.remove(0);
     }
     
     
    return queue.element();
  }

  private static Long getLenght(List<Long> sortedCars, int k) {
    int i = 0;
    Long dis = 1L;
    while(i < k-1 && i+1 <sortedCars.size())
      {
        Long firstCar = sortedCars.get(i);
        Long secondCar = sortedCars.get(i+1);
         dis = dis + (secondCar -firstCar) ;
        
        i++;
      }
    if(i != k-1)
    {
      dis = 9999999999999L;
    }
    return dis;
  }
  
}
