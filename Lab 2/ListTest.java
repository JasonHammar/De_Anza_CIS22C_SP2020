import java.util.NoSuchElementException;

/**
 * Class to test List.java
 * @author
 */

public class ListTest {
    public static void main(String[] args) {
    	
    	 List<Integer> L = new List<>();
    	 System.out.println("Should print nothing (an empty list): " + L);
    	 
    	 // default constructor method calls if needed
    	 
    	 System.out.println("**Testing Deep Copy Constructor**");
    	 List<String> L7 = new List<>();
    	 L7.addFirst("A");
    	 List L8 = new List (L7);
    	 System.out.print("Should print true: " + L7.equals(L8));
    	 L7.addLast("B");
    	 List L9 = new List (L7);
    	 System.out.print("\nShould print A B: " + L9);
    	 
    
    	 System.out.println("\n**Testing addFirst**");
         L.addFirst(2); //Testing Edge case: length == 0
         System.out.println("Should print 2: " + L);
         L.addFirst(1); //Testing General case: length >= 1
         System.out.println("Should print 1 2: " + L);
         

         System.out.println("**Testing getFirst**");
         System.out.println("Should print 1: " + L.getFirst()); //testing general case
         List<String> L2 = new List<>();
         try { //testing precondition
        	 System.out.println("Should print error: ");
             L2.getFirst();
         } catch (NoSuchElementException e) {
             System.out.println(e.getMessage()); 
         }
       
         List<Integer> P = new List<>();
         System.out.println("\n**Testing addLast**");
         P.addLast(2); //Testing Edge case: length == 0
         System.out.println("Should print 2: " + P);
         P.addLast(1); //Testing General case: length >= 1
         System.out.println("Should print 2 1: " + P);
         
            
         System.out.println("**Testing getLast**");
         System.out.println("Should print 1: " + P.getLast()); //testing general case
         List<String> p2 = new List<>();
         
         try { //testing precondition
        	 System.out.println("Should print error: ");
        	 p2.getLast();
         } catch (NoSuchElementException e) {
             System.out.println(e.getMessage());
         }
         
         
         System.out.println("\n**Testing removeFirst**");
         L.removeFirst(); //Testing General case: length >1
         System.out.println("Should print 2: " + L);
         L.removeFirst(); //Testing Edge case: length == 1
         System.out.println("Should print an empty List: " + L);
         System.out.println("Should print error: ");
         try { //place in a try-catch so program does not end when exception thrown
             L.removeFirst(); //Testing Precondition: length == 0
         } catch(NoSuchElementException e) {
             System.out.println(e.getMessage());
         }     
         
         System.out.println("\n**Testing removeLast**");
         P.removeLast(); //Testing General case: length >1
         System.out.println("Should print 2: " + P);
         P.removeLast(); //Testing Edge case: length == 1
         System.out.println("Should print an empty List: " + P);
         System.out.println("Should print error: ");
         try { //place in a try-catch so program does not end when exception thrown
             L.removeLast(); //Testing Precondition: length == 0
            // System.out.println(L);
         } catch(NoSuchElementException e) {
             System.out.println(e.getMessage());
         }   
         
         
         System.out.println("\n**Testing placeIterator**");
         p2.placeIterator();
         System.out.println("Should print error: ");
         try {
        	 p2.getIterator();
         } catch (NullPointerException e) {
        	 System.out.println("placeIterator(): List is empty");
         }
         p2.addFirst("A");
         p2.placeIterator();
         System.out.print("Should print A: " + p2.getIterator() + "\n");
         
         
         
         System.out.println("\n**Testing advanceIterator**");
         p2.addLast("B");
         p2.addLast("C");
         p2.placeIterator();
         p2.advanceIterator();
         System.out.print("Should print B: " + p2.getIterator() + "\n");
         p2.advanceIterator();
         System.out.print("Should print C: " + p2.getIterator() + "\n");
         
         System.out.println("\n**Testing reverseIterator**");
         p2.reverseIterator();
         System.out.print("Should print B: " + p2.getIterator() + "\n");
         p2.reverseIterator();
         System.out.print("Should print A: " + p2.getIterator() + "\n");
         
         System.out.println("\n**Testing offEnd**");
         L2.addFirst("A");
         L2.placeIterator();  
         System.out.print("Should print false: " + L2.offEnd());
         L2.advanceIterator();
         System.out.print("\nShould print true: " + L2.offEnd());
       
         
         List<String> L3 = new List<>();
         System.out.println("\n\n**Testing addIterator**");
         L3.addFirst("A");
         L3.placeIterator();
         L3.addIterator("B");
         System.out.print("Should print A B: " + L3);
         L3.addIterator("C");
         System.out.print("Should print A C B: " + L3);
         
         
         System.out.println("\n**Testing removeIterator**");
         L3.advanceIterator();
         L3.removeIterator();
         System.out.print("Should print A B: " + L3);
         L3.placeIterator();
         L3.removeIterator();
         System.out.print("Should print B: " + L3);
         
         
         System.out.println("\n**Testing getIterator**");
         L3.addFirst("A");
         L3.placeIterator();
         System.out.print("Should print A: " + L3.getIterator());
         L3.advanceIterator();
         System.out.print("\nShould print B: " + L3.getIterator() + "\n");
         
         System.out.println("Should print error: ");
         try {
        	 L3.advanceIterator();
        	 L3.getIterator();
         } catch (NullPointerException e) {
        	 System.out.print("getIterator(); iterator is off the end of the list\n");
         }
         
         List<String> L4 = new List<>();
         List<String> L5 = new List<>();
         System.out.println("\n**Testing equals**");
         L4.addFirst("A");
         L5.addFirst("A");
         System.out.print("Should print true: " + L4.equals(L5));
         L5.addFirst("X");
         System.out.print("\nShould print false: " + L4.equals(L5) + "\n");
         
         
         System.out.println("\n**Testing toString**");
         System.out.print("Should print A: " + L4.toString());
         System.out.print("Should print X A: " + L5.toString());
         
         
         
         List<String> L6 = new List<>();
         System.out.println("\n**Testing printNumberedList**");
         L6.addLast("B");
         System.out.print("Should print 1. B: ");
         L6.printNumberedList();
         L6.addFirst("A");
         System.out.print("Should print \n1. A\n2. B:\n\n");
         L6.printNumberedList();
         
 
         System.out.println("\n**Testing isEmpty**");

         System.out.println("Should print false: " + L2.isEmpty());
         System.out.println("Should print true: " + !L2.isEmpty()); 
         
         System.out.println("\n**Testing getLength**");
         System.out.println("Should print 1: " + L2.getLength());
         p2.addLast("A");
         System.out.print("Should print 4: " + p2.getLength() + "\n");

    	}
    }