package manager;

import transaction.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Transaction transaction = new Transaction();

        PropertySelector selector = new PropertySelector(transaction);

        Customer customer = Customer.buildCustomer(selector);
        List<Property> availableProperties = getProperties();

        boolean quit = false;

        while (quit != true) {
            System.out.println("\nMain Menu");
            System.out.println("Press 1 to select a property");
            System.out.println("Press 2 to manage your properties");
            System.out.println("Press 3 to print your logs");
            System.out.println("Press 4 to exit");

            Scanner scanner = new Scanner(System.in);
            int selection = scanner.nextInt();

            if (selection == 1) {
                selector.choosePropertyToPurchase(availableProperties, customer);
            } else if (selection == 2) {
                selector.manageProperties(availableProperties, customer);
            } else if (selection == 3) {
                transaction.printLogs();
            } else {
                quit = true;
            }
        }
    }
    private static List<Property> getProperties() {
        Property bungalow = Property.buildProperty();
        Property smallHouse = Property.buildProperty2();

        List<Property> properties = new ArrayList<>();
        properties.add(bungalow);
        properties.add(smallHouse);
        return properties;
    }
}
