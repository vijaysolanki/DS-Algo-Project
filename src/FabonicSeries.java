
public class FabonicSeries {
	
	public static void main(String[] args) {
		
		int a  = 0,  b = 1, c = 0;
		int len = 10;
		System.out.print("0 1");
		for (int i = 0; i < len; i++) {
			c =  a + b;
			System.out.print(" " + c);
			a = b;
			b = c;
			
		}
	}
}
