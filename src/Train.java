import java.util.Hashtable;

public class Train {
    private Hashtable<Integer, Integer> wagons ;

    public Train(int trainSize) {
//      this.wagons = fillWagon;
    	wagons = new Hashtable<Integer, Integer>();
    	for (int i = 0; i < trainSize; i++) {
    		 wagons.put(i, i);
		}
  }
    
    public int peekWagon(int wagonIndex) {
        return this.wagons.get(wagonIndex);
    }
    
    public static void main(String[] args) {
    	int trainSize = 100000000;
    	
        Train train = new Train(trainSize);

        for (int i = 0; i < trainSize; i++) {
            System.out.println("Wagon: " + i + ", cargo: " + train.peekWagon(i));
        }
    }
}