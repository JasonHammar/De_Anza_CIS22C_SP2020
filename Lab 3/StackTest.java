
/**
* StackTest.java
* @ Zyad Khater
* @ Jason Hammar
*/
import java.util.NoSuchElementException;

public class StackTest {
	public static void main(String[] args) {

		System.out.println("**Testing default constructor**");
		Stack<String> S = new Stack<>();
		System.out.println("Should print an empty queue: " + S);

		System.out.println("**Testing Deep Copy Constructor**");
		Stack<String> S1 = new Stack<>();
		S1.push("A");
		Stack S2 = new Stack(S1);
		System.out.print("Should print true: " + S1.equals(S2));
		S1.push("B");
		Stack S3 = new Stack(S1);
		System.out.print("\nShould print A B: " + S3);

		System.out.println("\n**Testing Peek**");
		System.out.println("Should print B: " + S1.peek());
		Stack<String> S4 = new Stack<>();
		try {
			System.out.println("Should print error: ");
			S4.peek();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n**Testing getLength**");
		System.out.println("Should print 1: " + S2.getLength());
		System.out.print("Should print 2: " + S1.getLength() + "\n");

		System.out.println("\n**Testing isEmpty**");

		System.out.println("Should print false: " + !S4.isEmpty());
		System.out.println("Should print true: " + S4.isEmpty());

		Stack<String> S5 = new Stack<>();
		System.out.println("\n**Testing Equals**");
		S4.push("A");
		S5.push("A");
		System.out.print("Should print true: " + S4.equals(S5));
		S5.push("X");
		System.out.print("\nShould print false: " + S4.equals(S5) + "\n");

		System.out.println("\n**Testing Push**");
		S4.push("B");
		System.out.print("Should print B A: " + S4);
		S4.push("C");
		System.out.print("Should print C B A: " + S4);

		System.out.println("\n**Testing Pop**");
		S4.pop();
		System.out.print("Should print B A: " + S4);
		S4.pop();
		System.out.print("Should print A: " + S4);

		System.out.println("\n**Testing toString**");
		System.out.print("Should print A: " + S4.toString());
		System.out.print("Should print X A: " + S5.toString());

		System.out.println("\n**Testing printReverse**");
		S5.push("C");
		System.out.print("Should print A X C: ");
		S5.printReverse();
		S5.push("Z");
		System.out.print("\nShould print A X C Z: ");
		S5.printReverse();

		System.out.println("\n**Testing isSorted**");
		System.out.println("Should print true: " + S4.isSorted());
		System.out.println("Should print false: " + S5.isSorted());

		Stack<String> S8 = new Stack<>();
		S8.push("A");
		S8.push("B");
		S8.push("C");
		System.out.println("\n**Testing linearSearch**");
		System.out.print("Should print 3: " + S8.linearSearch("A"));
		System.out.print("\nShould print -1: " + S8.linearSearch("D"));

		System.out.println("\n\n**Testing binarySearch**");
		Queue<String> S6 = new Queue<>();
		S6.enqueue("A");
		S6.enqueue("B");
		System.out.print("Should print 1: " + S6.binarySearch("A"));

		Queue<String> S7 = new Queue<>();
		S7.enqueue("C");
		S7.enqueue("B");
		System.out.print("\nShould print error message: ");
		try {
			S7.binarySearch("C");
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
}