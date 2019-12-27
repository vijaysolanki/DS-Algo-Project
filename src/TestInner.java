
class A {
	int i  = 10;
	public void print(int i)
	{
		System.out.println("A: " + i);
	}
	
	public int returnValue()
	{
		return i;
	}
}
public class TestInner {
    int i  = 20;
	public static void main(String[] args) {
		TestInner testInner = new TestInner();
		System.out.println("TestInner value of i: " + testInner.i);
		A a = new A(){
			//IIB
			{
				//initializing with another value can be anything.
				//Comment and see the diference
				this.i = testInner.i;
			}

			@Override
			public void print(int i)
			{
				System.out.println("Initialized value of i :" + this.i);
				System.out.println("Passed value of i : " + i);
			}
			
			@Override
			public int returnValue()
			{
				return this.i;
			}
		};
		
		a.print(100);
		int returnValue = a.returnValue();
		System.out.println("Returned value of i from A :" + returnValue);
	}
}
