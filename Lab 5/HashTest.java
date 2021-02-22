/**
 * HashTest.java
 * 
 * @Zyad Khater
 * @Jason Hammar CIS 22C, Lab 5
 */

public class HashTest {
	public static void main(String[] args) {
		Hash<Movie> t = new Hash<Movie>(20);
		Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);
		Movie bond2 = new Movie("From Russia with Love", "Terence Young", 1963, 79.0);
		Movie bond3 = new Movie("Goldfinger", "Guy Hamilton", 1964, 125.0);
		Movie bond4 = new Movie("Thunderball", "Kevin McClory", 1965, 141.2);
		Movie bond5 = new Movie("Casino Royale", "Ken Hughes", 1967, 41.7);
		Movie bond6 = new Movie("You Only Live Twice", "Lewis Gilbert", 1967, 111.6);
		Movie bond7 = new Movie("On Her Majesty's Secret Service", "Peter R. Hunt", 1969, 82.0);
		Movie bond8 = new Movie("Diamonds are Forever", "Guy Hamilton", 1971, 116.0);
		Movie bond9 = new Movie("Live and Let Die", "Guy Hamilton", 1973, 161.8);
		Movie bond10 = new Movie("The Man with the Golden Gun", "Guy Hamilton", 1974, 97.6);
		t.insert(bond1);
		t.insert(bond2);
		t.insert(bond3);
		t.insert(bond4);
		t.insert(bond5);
		t.insert(bond6);
		t.insert(bond7);
		t.insert(bond8);
		t.insert(bond9);
		t.insert(bond10);

		System.out.println("***Testing Insert and toString***\n");
		Hash<Movie> t2 = new Hash<Movie>(20);
		Movie bond11 = new Movie("The Tale of Two Cities", "John Richardson", 1994, 89.6);
		t.insert(bond11);

		System.out.print("\nShould print all 11 movies:\n\n");
		System.out.print(t);
		System.out.print("Should print an empty Hash Table:\n\n");
		System.out.print(t2);

		System.out.println("***Testing CountBucket***\n");
		int count = t.countBucket(19);
		System.out.println("There are " + count + " movies at bucket 19\n");
		int count2 = t.countBucket(18);
		System.out.println("There are " + count2 + " movies at bucket 18\n");

		System.out.println("***Testing Search***\n");
		int inTable = t.search(bond9);
		if (inTable != -1) {
			System.out.println(bond9.getTitle() + " is stored in the table");
		} else {
			System.out.println(bond9.getTitle() + " is not stored in the table\n\n");
		}

		int inTable2 = t2.search(bond4);
		if (inTable2 != -1) {
			System.out.println(bond4.getTitle() + " is stored in the table");
		} else {
			System.out.println(bond4.getTitle() + " is not stored in the table");
		}

		System.out.println("\n***Testing PrintBucket for Index 19***\n");

		System.out.print("Should print the movies Thunderball and Live and Let Die: \n\n");
		t.printBucket(19);

		System.out.print("Should print 0 movies:\n\n");
		t.printBucket(18);

		System.out.println("\n***Testing Remove***\n");
		t.remove(bond9);

		System.out.println(bond9.getTitle() + " should be removed from this index: \n");
		t.printBucket(19);

		inTable = t.search(bond9);
		if (inTable != -1) {
			System.out.println(bond9.getTitle() + " is stored in the table");
		} else {
			System.out.println(bond9.getTitle() + " is not stored in the table");
		}

		System.out.println("\n" + bond11.getTitle() + " should be removed from this index: \n");

		t.printBucket(11);
		t.remove(bond11);

		inTable = t.search(bond11);
		if (inTable != -1) {
			System.out.println(bond11.getTitle() + " is stored in the table");
		} else {
			System.out.println(bond11.getTitle() + " is not stored in the table");
		}
	}
}