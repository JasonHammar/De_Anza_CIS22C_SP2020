import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendNetwork {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.print("Welcome to the Friend Recommender!");
		System.out.print("\n\nEnter the name of a file: ");
		Scanner inp = new Scanner(System.in);
		String fileName = inp.nextLine();
		File file = new File(fileName);
		int vertex = 0;
		String name = "";
		String adjList = "";

		try {
			Scanner input = new Scanner(file);
		} catch (FileNotFoundException e) {

			while (!file.exists()) {
				System.out.print("\nInvalid File Name!");
				System.out.print("\nEnter the name of a file: ");
				fileName = inp.nextLine();
				file = new File(fileName);

				if (inp.equals(file)) {
					break;
				}

			}
		}

		System.out.print("\nEnter Your User Number Below: \n");
		Scanner input = new Scanner(file);

		int i = Integer.parseInt(input.nextLine());

		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> id = new ArrayList<Integer>();
		Graph friends = new Graph(i + 1);

		for (int j = 1; j <= i; j++) {

			vertex = Integer.parseInt(input.nextLine());
			name = input.nextLine();
			adjList = input.nextLine();

			names.add(name);
			id.add(vertex);

			String[] list = adjList.split(", ");

			for (int k = 0; k < list.length; k++) {

				if (list[k].endsWith(",")) {
					list[k] = list[k].substring(0, list[k].length() - 1);
				}

				int num = Integer.parseInt(list[k]);
				friends.addDirectedEdge(j, num);
				// System.out.println(num);
			}

			System.out.println(vertex + ". " + name);

		}
		
		System.out.print("\nEnter your choice: ");
		int choice = inp.nextInt();

		System.out.print("Here are your current friends:\n");
		friends.getAdjacencyList(choice).placeIterator();
		for (int a = 0; a < friends.getAdjacencyList(choice).getLength(); a++) {
			System.out.print(friends.getAdjacencyList(choice).getIterator() + ". "
					+ names.get(friends.getAdjacencyList(choice).getIterator() - 1) + "\n");
			friends.getAdjacencyList(choice).advanceIterator();
		}
		friends.BFS(choice);
		System.out.print("\nHere are your recommended friends.");
		for(int p = 1; p <= vertex; p++) {
			if(friends.getDistance(p) < 0) {
				System.out.print("\n" + p + ". " + names.get(p - 1));
			}
		}
		System.out.print("\n\nEnter the number of a friend to add or -1 to quit.");
		System.out.print("\nEnter your choice: ");
		int addOrQuit = inp.nextInt();
		
		while(addOrQuit != -1) {
			friends.addUndirectedEdge(choice, addOrQuit);
			
			System.out.print("\nHere are your current friends:\n");
			friends.getAdjacencyList(choice).placeIterator();
			for (int a = 0; a < friends.getAdjacencyList(choice).getLength(); a++) {
				System.out.print(friends.getAdjacencyList(choice).getIterator() + ". "
						+ names.get(friends.getAdjacencyList(choice).getIterator() - 1) + "\n");
				friends.getAdjacencyList(choice).advanceIterator();
			}
			System.out.print("\nHere are your recommended friends:\n");
			for(int p = 1; p <= vertex; p++) {
				if(friends.getDistance(p) < 0) {
					System.out.print("\n" + p + ". " + names.get(p - 1));
				}
			}
			System.out.print("\n\nEnter the number of a friend to add or -1 to quit.");
			System.out.print("\nEnter your choice: ");
			addOrQuit = inp.nextInt();
			friends.getAdjacencyList(choice).getLength();
		}
		System.out.print("\nGoodbye!");

	}

}