import java.util.Scanner;

public class Scheduler {
	public static void main(String args[]) {
		// List<Integer> L = new List<>();
		boolean done = false;
		List<String> schedule = new List<String>();
		String choice = "";
		String event = "";
		int increment = 1;

		System.out.println("Welcome to the Scheduler App!");
		System.out.println("\nYou have no upcoming events!\n");

		while (!choice.equals("X") && !choice.equals("x")) {

			System.out.println("Select from the following options:");

			System.out.println("A: Add an event");
			System.out.println("R: Remove an event");
			System.out.println("X: Exit");

			Scanner in = new Scanner(System.in);
			System.out.print("\nEnter your choice: ");
			choice = in.nextLine();

			if (choice.equals("A") || choice.equals("a")) {
				System.out.print("\nPlease enter an event: ");
				event = in.nextLine();
				schedule.addFirst(event);
				// schedule.printNumberedList();
				System.out.println("\nYou just added the following event to your schedule: " + event);
				System.out.println("\nYour Current Schedule: \n");
				schedule.printNumberedList();
				schedule.placeIterator();
				if (schedule.getLength() > 1) {
					System.out.print("\nWould you like to move this event up in your schedule (Y/N): ");
					String choice1 = in.nextLine();
					// while((!choice1.equals("N") || !choice1.equals("n")) || (!choice1.equals("Y")
					// || !choice1.equals("y"))) {
					// System.out.println("Sorry that input is invalid!\n");
					// System.out.print("\nWould you like to move this event up in your schedule
					// (Y/N): ");
					// choice1 = in.nextLine();
					// }
					if ((choice1.equals("N") || choice1.equals("n")) || (choice1.equals("Y") || choice1.equals("y"))) {
						if (choice1.equals("Y") || choice1.equals("y")) {

							System.out.print("Enter the number of places: ");
							int places = in.nextInt();
							while (places >= schedule.getLength()) {
								System.out.println("Sorry that input is invalid!\n");
								System.out.print("Enter the number of places: ");
								places = in.nextInt();
							}
							if (places < schedule.getLength()) {
								for (int i = 0; i < places; i++) {
									schedule.advanceIterator();
								}
							}
						}

					}

					schedule.addIterator(event);
					schedule.removeFirst();
					System.out.println("\nYour Current Schedule: \n");
					schedule.printNumberedList();

				} else {
					// schedule.addFirst(event);
					// System.out.println("\nYour Current Schedule: \n");
					schedule.placeIterator();
					// schedule.printNumberedList();
				}
				System.out.print("\n");

			} else if (choice.equals("R") || choice.equals("r")) {
				schedule.placeIterator();
				System.out.print("Enter the number of the event to remove: ");
				int removalNum = in.nextInt();
				while (removalNum > schedule.getLength()) {
					System.out.println("Sorry that input is invalid!");
					System.out.print("Enter the number of the event to remove: \n");
				}
				for (int i = 0; i < removalNum - 1; i++) {
					schedule.advanceIterator();
				}
				System.out.println("\nRemoving: " + schedule.getIterator());
				schedule.removeIterator();
				System.out.println("\nYour Current Schedule: \n");
				schedule.printNumberedList();
				System.out.println();
			} else if (choice.equals("X") || choice.equals("x")) {
				System.out.print("\nGoodbye!");
			} else {
				System.out.println("\nSorry that input is invalid!\n");
			}

		}

	}
}