import java.util.ArrayList;
import java.util.List;

/**
 * The Home class represents a house in the inventory.
 * It includes attributes like square footage, address, city, state, ZIP code, model name, and sale status.
 */
class Home {

    // Attributes for the home's details
    private int squareFeet;         // Home's square footage
    private String address;         // Home's address
    private String city;            // City where the home is located
    private String state;           // State where the home is located
    private int zipCode;            // ZIP code of the home
    private String modelName;       // Model name of the home
    private String saleStatus;      // Sale status of the home (sold, available, under contract)

    // Static list to store all home instances
    private static List<Home> homes = new ArrayList<>();

    /**
     * Parameterized constructor to initialize a new Home object with specific details.
     *
     * @param squareFeet   Home's square footage
     * @param address      Home's address
     * @param city         City where the home is located
     * @param state        State where the home is located
     * @param zipCode      ZIP code of the home
     * @param modelName    Model name of the home
     * @param saleStatus   Sale status of the home (sold, available, under contract)
     */
    public Home(int squareFeet, String address, String city, String state, int zipCode, String modelName, String saleStatus) {
        this.squareFeet = squareFeet;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.modelName = modelName;
        this.saleStatus = saleStatus;
    }

    /**
     * Method to add a new home to the inventory.
     * Validates the input and returns a success or failure message.
     *
     * @param squareFeet   Home's square footage
     * @param address      Home's address
     * @param city         City where the home is located
     * @param state        State where the home is located
     * @param zipCode      ZIP code of the home
     * @param modelName    Model name of the home
     * @param saleStatus   Sale status of the home (sold, available, under contract)
     * @return String indicating the success or failure of the operation
     */
    public static String addHome(int squareFeet, String address, String city, String state, int zipCode, String modelName, String saleStatus) {
        try {
            if (squareFeet > 0 && !address.isEmpty() && !city.isEmpty() && !state.isEmpty() && zipCode > 0 && !modelName.isEmpty() && !saleStatus.isEmpty()) {
                homes.add(new Home(squareFeet, address, city, state, zipCode, modelName, saleStatus));
                return "Home added successfully.";
            } else {
                throw new IllegalArgumentException("Invalid input.");
            }
        } catch (Exception e) {
            return "Failed to add home: " + e.getMessage();
        }
    }

    /**
     * Method to remove a home from the inventory.
     * Searches for the home by address and ZIP code and returns a success or failure message.
     *
     * @param address  Home's address to identify the home to remove
     * @param zipCode  ZIP code of the home to identify the home to remove
     * @return String indicating the success or failure of the operation
     */
    public static String removeHome(String address, int zipCode) {
        try {
            for (Home home : homes) {
                if (home.address.equals(address) && home.zipCode == zipCode) {
                    homes.remove(home);
                    return "Home removed successfully.";
                }
            }
            throw new Exception("Home not found.");
        } catch (Exception e) {
            return "Failed to remove home: " + e.getMessage();
        }
    }

    /**
     * Method to update the sale status of a home.
     * Searches for the home by address and ZIP code and updates the sale status if found.
     *
     * @param address       Home's address to identify the home to update
     * @param zipCode       ZIP code of the home to identify the home to update
     * @param newSaleStatus New sale status to update the home to
     * @return String indicating the success or failure of the operation
     */
    public static String updateHome(String address, int zipCode, String newSaleStatus) {
        try {
            for (Home home : homes) {
                if (home.address.equals(address) && home.zipCode == zipCode) {
                    home.saleStatus = newSaleStatus;
                    return "Home updated successfully.";
                }
            }
            throw new Exception("Home not found.");
        } catch (Exception e) {
            return "Failed to update home: " + e.getMessage();
        }
    }

    /**
     * Method to list all homes in the inventory.
     * Returns a formatted string of all home details or an error message if no homes are available.
     *
     * @return String of home details or failure message
     */
    public static String listHomes() {
        StringBuilder homeDetails = new StringBuilder();
        try {
            if (!homes.isEmpty()) {
                for (Home home : homes) {
                    homeDetails.append(home.toString()).append("\n");
                }
                return homeDetails.toString();
            } else {
                throw new Exception("No homes available.");
            }
        } catch (Exception e) {
            return "Failed to list homes: " + e.getMessage();
        }
    }

    /**
     * Converts the home object into a readable string format for display.
     *
     * @return String representation of the home details
     */
    @Override
    public String toString() {
        return "Home{" +
                "squareFeet=" + squareFeet +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                ", modelName='" + modelName + '\'' +
                ", saleStatus='" + saleStatus + '\'' +
                '}';
    }
}
