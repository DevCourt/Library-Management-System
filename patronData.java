import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	for (int i = 0; i < patronIDs.length; i++) {
		if (patronIDs[i] == patronID) {
			System.out.println("Patron ID: " + patronIDs[i]);
			System.out.println("Patron Name: " + patronNames[i]);
			System.out.println("Amount due: $" + patronAmountsDue[i]);
			return;
		} 
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
		for (int i = 0; i < patronIDs.length; i++) {
			if (patronIDs[i] == removePatronID) {
				remove = i;
				break;
			}
		}
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

	// Upload txt file
	public static void uploadData(String filePath) {
		try {
		File file = new File(filePath);
		Scanner fileScanner = new Scanner(file);

		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();

			String[] data = line.split(",");

			int newPatronID = Integer.parseInt(data[0]);
			String newPatronName = data[1];
			double newPatronAmountDue = Double.parseDouble(data[2]);

			addPatron(newPatronID, newPatronName, newPatronAmountDue);
		}

		fileScanner.close();

		System.out.println("Patrons successfully uploaded.");

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (Exception e) {
			System.out.println("Error reading the file.");
		}
	}
}