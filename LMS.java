import java.util.Scanner;

public class LMS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Library Management System");

		int option = 0;

		while (option != 5) {
			// Show menu options
			System.out.println("1. Look up a patron with their ID");
			System.out.println("2. Add a patron");
			System.out.println("3. Remove a patron");
			System.out.println("4. Display all patrons");
			System.out.println("5. Exit the program");
			System.out.println("Please choose a number that matches the option you want to perform: ");

			option = scanner.nextInt();
			while (option < 1 || option > 5) {
				System.out.println("Invalid option. Please choose a number between 1 and 5.");
				option = scanner.nextInt();
			}
			
			// If statements to allow the options to work
			// Look up a patron
			if (option == 1) {
				System.out.println("Please enter their ID: ");
				int patronID = scanner.nextInt();

				if (patronID > 1000000 && patronID <= 9999999) {
					System.out.println("Patron found: " + patronID);
					patronData.getPatronInfo(patronID);
				} else {
					System.out.println("Patron not found.");
				}
			}
			// Add a patron
			else if (option == 2) {
				System.out.println("Please create a 7 digit ID for the new patron: ");
				int newPatronID = scanner.nextInt();
				if (newPatronID > 1000000 && newPatronID <= 9999999) {
					boolean patronExists = false;
					for (int patronID : patronData.patronIDs) {
						if (newPatronID == patronID) {
							patronExists = true;
							break;
						}
					}
					if (patronExists) {
						System.out.println("This ID already exists.");
					} else {
						System.out.println("Enter the patron's name: ");
						String newPatronName = scanner.next();
						System.out.println("Enter the amount due: ");
						double newPatronAmountDue = scanner.nextDouble();
						patronData.addPatron(newPatronID, newPatronName, newPatronAmountDue);
						System.out.println("New patron added.");
					}
				} else {
					System.out.println("Invalid ID. Please enter a 7 digit ID.");
				}
			}
			// Remove a patron
			else if (option == 3) {
				System.out.println("Please enter the ID of the patron you want to remove: ");
				int removePatronID = scanner.nextInt();
				if (removePatronID > 1000000 && removePatronID <= 9999999) {
					System.out.println("Successfully removed the patron!");
					patronData.removePatron(removePatronID);
				}
			}
			// Display all patrons
			else if (option == 4) {
				System.out.println("Displaying all patrons:");
				for (int patronID : patronData.patronIDs) {
					patronData.getPatronInfo(patronID);
				}
			}
			// Exit the program
			else if (option == 5) {
				System.out.println("Exiting the program.");
			} else {
				System.out.println("Please choose a number between 1 and 5.");
			}
		}
	scanner.close();
	}
}