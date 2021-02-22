
/**
* QueueTest.java
* @ Zyad Khater
* @ Jason Hammar
*/
import java.util.NoSuchElementException;

public class QueueTest {

	public static void main(String[] args) {
		System.out.println("**Testing default constructor**");
		Queue<String> Q = new Queue<>();
		System.out.println("Should print an empty queue: " + Q);

		System.out.println("**Testing Deep Copy Constructor**");
		Queue<String> Q1 = new Queue<>();
		Q1.enqueue("A");
		Queue Q2 = new Queue(Q1);
		System.out.print("Should print true: " + Q1.equals(Q2));
		Q1.enqueue("B");
		Queue Q3 = new Queue(Q1);
		System.out.print("\nShould print A B: " + Q3);

		System.out.println("\n**Testing getFront**");
		System.out.println("Should print A: " + Q1.getFront());
		Queue<String> Q4 = new Queue<>();
		try {
			System.out.println("Should print error: ");
			Q4.getFront();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n**Testing getLength**");
		System.out.println("Should print 2: " + Q1.getLength());
		Q1.enqueue("A");
		System.out.print("Should print 3: " + Q1.getLength() + "\n");

		System.out.println("\n**Testing isEmpty**");
		System.out.println("Should print false: " + Q1.isEmpty());
		System.out.println("Should print true: " + Q4.isEmpty());

		Queue<String> Q5 = new Queue<>();
		System.out.println("\n**Testing equals**");
		Q4.enqueue("A");
		Q5.enqueue("A");
		System.out.print("Should print true: " + Q4.equals(Q5));
		Q5.enqueue("X");
		System.out.print("\nShould print false: " + Q4.equals(Q5) + "\n");

		System.out.println("\n**Testing enqueue**");
		Q4.enqueue("B");
		System.out.print("Should print A B: " + Q4);
		Q4.enqueue("C");
		System.out.print("Should print A B C: " + Q4);

		System.out.println("\n**Testing dequeue**");
		Q4.dequeue();
		System.out.print("Should print B C: " + Q4);
		Q4.dequeue();
		System.out.print("Should print C: " + Q4);

		System.out.println("\n**Testing toString**");
		System.out.print("Should print C: " + Q4.toString());
		System.out.print("Should print A X: " + Q5.toString());

		System.out.println("\n**Testing printReverse**");
		Q5.enqueue("C");
		System.out.print("Should print C X A: ");
		Q5.printReverse();
		Q5.enqueue("Z");
		System.out.print("\nShould print Z C X A: ");
		Q5.printReverse();

		System.out.println("\n**Testing isSorted**");
		System.out.println("Should print true: " + Q4.isSorted());
		System.out.println("Should print false: " + Q5.isSorted());

		Queue<String> Q8 = new Queue<>();
		Q8.enqueue("A");
		Q8.enqueue("B");
		Q8.enqueue("C");
		System.out.println("\n**Testing linearSearch**");
		System.out.print("Should print 3: " + Q8.linearSearch("C"));
		System.out.print("\nShould print -1: " + Q8.linearSearch("D"));

		System.out.println("\n\n**Testing binarySearch**");
		Queue<String> Q6 = new Queue<>();
		Q6.enqueue("A");
		Q6.enqueue("B");
		System.out.print("Should print 1: " + Q6.binarySearch("A"));

		Queue<String> Q7 = new Queue<>();
		Q7.enqueue("C");
		Q7.enqueue("B");
		System.out.print("\nShould print error message: ");
		try {
			Q7.binarySearch("C");
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
}