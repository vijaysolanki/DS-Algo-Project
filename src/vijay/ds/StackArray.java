package vijay.ds;

public class StackArray {

	static class Stack {
		private static final int MAX = 5;
		int top = -1;
		int data[];

		public void push(int val) {
			if (null == data) {
				data = new int[MAX];
			}

			if (top >= MAX -1) {
				System.out.println("Stack Over flow");
				return;
			} else {
				data[++top] = val;
			}
		}

		public int pop() {
			if (top < 0) {
				System.out.println("Stack Underflow");
				return top;
			}

			return data[top--];
		}

		public void print() {
			for (int i = 0; i <= top; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Stack arr = new Stack();
		arr.push(1);
		arr.push(2);
		arr.push(3);
		arr.push(4);
		arr.push(5);
		
		arr.print();
		arr.push(6);
		
		int pop = arr.pop();
		System.out.println("Poped : " + pop);
		arr.print();

		pop = arr.pop();
		System.out.println("Poped : " + pop);
		arr.print();
		pop = arr.pop();
		pop = arr.pop();
		pop = arr.pop();
		pop = arr.pop();
	}
}
