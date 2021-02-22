
/**
* MovieDatabase.java
* @author Zyad Khater
* @author Jason Hammar
* CIS 22C, Lab 5
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MovieDatabase {
	private final int NUM_MOVIES = 26;
	Hash<Movie> ht = new Hash<>(NUM_MOVIES * 2);
	BST<Movie> bst = new BST<>();

	public static void main(String[] args) throws IOException {
		MovieDatabase MD = new MovieDatabase();
		String title = "";
		String director = "";
		int year = 0;
		double grossMillions = 0;
		File file = new File("movies.txt");
		Scanner input = new Scanner(file);
		Scanner inp = new Scanner(System.in);
		System.out.print("Welcome to the Bond Movie Database!\n\n");
		String choice = "";
		Movie M2;
		while (input.hasNextLine()) {

			title = input.nextLine();
			director = input.nextLine();
			year = Integer.parseInt(input.nextLine());
			grossMillions = Double.parseDouble(input.nextLine());

			if (year != 2015) {
				String Dummy = input.nextLine();
			}

			M2 = new Movie(title, director, year, grossMillions);
			MD.ht.insert(M2);
			MD.bst.insert(M2);

		}
		input.close();
		while (!choice.equalsIgnoreCase("x")) {
			choice = "";
			System.out.print("Please select from one of the following options: \n\n");
			System.out.print(
					"A. Add a movie \nD. Display all movies \nR. Remove a movie \nS. Search for a movie \nX. Exit \n\n");
			System.out.print("Enter your choice: " + choice);
			choice = inp.nextLine();

			if (choice.equalsIgnoreCase("A")) {
				System.out.print("\nAdding a movie! \n\n");
				System.out.print("Enter the title: ");
				title = inp.nextLine();
				System.out.print("Enter the director: ");
				director = inp.nextLine();
				System.out.print("Enter the year: ");
				year = inp.nextInt();
				System.out.print("Enter the gross in millions: $");
				grossMillions = inp.nextDouble();
				inp.nextLine();
				M2 = new Movie(title, director, year, grossMillions);
				MD.ht.insert(M2);
				MD.bst.insert(M2);
				System.out.print("\n" + title + " was added!\n\n");

			} else if (choice.equalsIgnoreCase("D")) {

				System.out.print("\nPlease select one of the following options:\n\n");
				System.out.print("S. Sorted \nU. Unsorted \n\n");
				System.out.print("Enter your choice: ");
				String sortOrUnsort = inp.nextLine();
				System.out.print("\n");
				if (sortOrUnsort.equalsIgnoreCase("U")) {
					System.out.print("Displaying Movies:\n\n");
					System.out.println(MD.ht);
				} else {
					System.out.print("Displaying Movies:\n\n");
					MD.bst.inOrderPrint();
				}
			} else if (choice.equalsIgnoreCase("R")) {

				System.out.print("\nRemoving a movie!\n\nEnter the title: ");
				String removing1 = inp.nextLine();
				System.out.print("Enter the director: ");
				String removing2 = inp.nextLine();
				Movie M = new Movie(removing1, removing2, 1, 1);

				if (MD.ht.search(M) == -1) {
					System.out.print("\nI cannot find " + removing2 + "'s " + removing1 + ": " + removing1
							+ " in the database.");
				} else {
					MD.ht.remove(M);
					MD.bst.remove(M);
					System.out.print("\n" + removing2 + "'s " + removing1 + " was removed!\n\n");
				}

			} else if (choice.equalsIgnoreCase("S")) {
				System.out.print("\nSearching a movie!\n");
				System.out.print("\nEnter the title: ");
				String search1 = inp.nextLine();
				System.out.print("Enter the director: ");
				String search2 = inp.nextLine();
				Movie M = new Movie(search1, search2, 1, 1);
				if (MD.ht.search(M) == -1) {
					System.out.print("\n" + search2 + "'s " + search1 + " is not in the database.\n\n");
				} else {
					System.out.print("\n" + search2 + "'s " + search1 + " is in the database.\n\n");
				}
			} else if (!choice.equalsIgnoreCase("X")) {
				System.out.print("\nInvalid Selection!\n\n");
			}
		}
		System.out.print("\nGoodbye!");

		input.close();
	}

}