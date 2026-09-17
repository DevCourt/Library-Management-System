import java.util.ArrayList;

public class patronData {
	static int[] patronIDs = {
		1234567,
		7654321,
		1234568
	};

	static String[] patronNames = {
		"Mark Johnson",
		"Joey Smith",
		"Chris Brown"
	};

	static double[] patronAmountsDue = {
		10.0,
		50.0,
		150.0
	};


	// Find a patron with their ID
	public static void getPatronInfo(int patronID) {
		if (patronID == 1234567) {
			System.out.println("Patron Name: Mark Johnson");
			System.out.println("Amount due: $10");
		} else if (patronID == 7654321) {
			System.out.println("Patron Name: Joey Smith");
			System.out.println("Amount due: $50");
		} else if (patronID == 1234568) {
			System.out.println("Patron Name: Chris Brown");
			System.out.println("Amount due: $150");
		} else {
			System.out.println("Patron not found.");
		}
	}

	// Add a patron to array
	public static void addPatron(int newPatronID, String newPatronName, double newPatronAmountDue) {
		String[] newPatronNames = new String[patronNames.length + 1];
		int[] newPatronIDs = new int[patronIDs.length + 1];
		double[] newPatronAmountsDue = new double[patronAmountsDue.length + 1];

		System.arraycopy(patronIDs, 0, newPatronIDs, 0, patronIDs.length);
		System.arraycopy(patronNames, 0, newPatronNames, 0, patronNames.length);
		System.arraycopy(patronAmountsDue, 0, newPatronAmountsDue, 0, patronAmountsDue.length);
		newPatronIDs[patronIDs.length] = newPatronID;
		newPatronNames[patronNames.length] = newPatronName;
		newPatronAmountsDue[patronAmountsDue.length] = newPatronAmountDue;
		patronIDs = newPatronIDs;
		patronNames = newPatronNames;
		patronAmountsDue = newPatronAmountsDue;

		System.out.println("New patron added with ID: " + newPatronID);
		System.out.println("Patron Name: " + newPatronName);
		System.out.println("Amount due: $" + newPatronAmountDue);
	}

	// Remove a patron from array
	public static void removePatron(int removePatronID) {
		int[] newPatronIDs = new int[patronIDs.length - 1];
		String[] newPatronNames = new String[patronNames.length - 1];
		double[] newPatronAmountsDue = new double[patronAmountsDue.length - 1];

		// Check if the ID is valid
		if (removePatronID < 1000000 || removePatronID > 9999999) {
			System.out.println("Please enter a valid ID.");
			return;
		}

		int remove = -1;
		if (remove == -1) {
			System.out.println("Patron not found.");
			return;
		}

		int newIndex = 0;
		for (int i = 0; i < patronIDs.length; i++) {
			if (i != remove) {
				newPatronIDs[newIndex] = patronIDs[i];
				newPatronNames[newIndex] = patronNames[i];
				newPatronAmountsDue[newIndex] = patronAmountsDue[i];
				newIndex++;
			}
		}
		patronIDs = newPatronIDs;
		patronNames = newPatronNames;
		patronAmountsDue = newPatronAmountsDue;
		System.out.println("Patron has been removed.");
	}

	// Display all patrons
	public static void displayAllPatrons() {
		for (int patronID : patronIDs) {
			getPatronInfo(patronID);
		}
	}
}