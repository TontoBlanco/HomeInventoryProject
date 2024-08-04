import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The HomeInventory class is used to manage the inventory of homes.
 * It includes methods to add, remove, update, list homes, and print the inventory to a file.
 */
public class HomeInventory {

    /**
     * Main method to demonstrate the functionality of the HomeInventory class.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the menu
            System.out.println("\nHome Inventory Menu:");
            System.out.println("1. Add a home");
            System.out.println("2. Remove a home");
            System.out.println("3. Update home status");
            System.out.println("4. Display home inventory");
            System.out.println("5. Exit");

            // Get user selection
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add a home
                    addHomeMenu(scanner);
                    break;
                case 2:
                    // Remove a home
                    removeHomeMenu(scanner);
                    break;
                case 3:
                    // Update home status
                    updateHomeMenu(scanner);
                    break;
                case 4:
                    // Display home inventory
                    System.out.println("Current home inventory:");
                    System.out.println(Home.listHomes());
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Ask if the user wants to make another menu selection
            System.out.print("Do you want to perform another action? (Y/N): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("Y")) {
                // Ask the user if they want to print the inventory to a file
                System.out.print("Do you want to print the information to a file? (Y/N): ");
                response = scanner.nextLine();
                if (response.equalsIgnoreCase("Y")) {
                    printToFile(Home.listHomes(), "C:\\Temp\\Home.txt");
                    System.out.println("Information printed to file.");
                } else {
                    System.out.println("File will not be printed.");
                }

                System.out.println("Exiting program...");
                break;
            }
        }
    }

    /**
     * Method to prompt user for details and add a new home.
     *
     * @param scanner Scanner object for reading user input
     */
    private static void addHomeMenu(Scanner scanner) {
        try {
            System.out.print("Enter square feet: ");
            int squareFeet = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            System.out.print("Enter city: ");
            String city = scanner.nextLine();

            System.out.print("Enter state: ");
            String state = scanner.nextLine();

            System.out.print("Enter ZIP code: ");
            int zipCode = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            System.out.print("Enter model name: ");
            String modelName = scanner.nextLine();

            System.out.print("Enter sale status (sold, available, under contract): ");
            String saleStatus = scanner.nextLine();

            String result = Home.addHome(squareFeet, address, city, state, zipCode, modelName, saleStatus);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error adding home: " + e.getMessage());
        }
    }

    /**
     * Method to prompt user for details and remove a home.
     *
     * @param scanner Scanner object for reading user input
     */
    private static void removeHomeMenu(Scanner scanner) {
        try {
            System.out.print("Enter address of home to remove: ");
            String address = scanner.nextLine();

            System.out.print("Enter ZIP code of home to remove: ");
            int zipCode = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            String result = Home.removeHome(address, zipCode);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error removing home: " + e.getMessage());
        }
    }

    /**
     * Method to prompt user for details and update a home's status.
     *
     * @param scanner Scanner object for reading user input
     */
    private static void updateHomeMenu(Scanner scanner) {
        try {
            System.out.print("Enter address of home to update: ");
            String address = scanner.nextLine();

            System.out.print("Enter ZIP code of home to update: ");
            int zipCode = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            System.out.print("Enter new sale status (sold, available, under contract): ");
            String newSaleStatus = scanner.nextLine();

            String result = Home.updateHome(address, zipCode, newSaleStatus);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error updating home: " + e.getMessage());
        }
    }

    /**
     * Method to print home inventory information to a file.
     *
     * @param data     The data to write to the file
     * @param filePath The path of the file where the data will be written
     */
    public static void printToFile(String data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Failed to print to file: " + e.getMessage());
        }
    }
}
