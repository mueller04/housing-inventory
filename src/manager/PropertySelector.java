package manager;

import transaction.Transaction;

import java.util.List;
import java.util.Scanner;

public class PropertySelector {

    Transaction transaction;
    private Scanner scanner;

    public PropertySelector(Transaction transaction){
        this.transaction = transaction;
    }

    public void choosePropertyToPurchase(List<Property> availableProperties, Customer customer) {
        scanner = new Scanner(System.in);
        System.out.println("Choose a property\n");
        boolean quit = false;
        while(quit != true) {

            if (displayPropertiesAvailableForPurchase(availableProperties)) {
                return;
            }
            System.out.print("Press 0 to quit\n");

            int selection = scanner.nextInt();

            if (selection != 0) {
                Property property = availableProperties.get(selection - 1);
                purchaseMenu(property, scanner, customer, availableProperties);
            } else {
                quit = true;
            }
        }
    }

    public void manageProperties(List<Property> availableProperties, Customer customer) {
        if (customer.properties.size() == 0) {
            System.out.println("You do not own any properties");
            return;
        }
        System.out.println("\n" + customer.name + "'s properties");

        boolean keepRunning = true;
        while(keepRunning) {
            productSelectionList(customer.properties);
            System.out.print("Press 0 to quit\n");
            int selection = scanner.nextInt();
            if (selection == 0) {
                keepRunning = false;
            } else {
                manageSelectedProperty(availableProperties, customer, selection);
            }
        }
    }

    private void manageSelectedProperty(List<Property> availableProperties, Customer customer, int selection) {
        Property property = customer.properties.get(selection - 1);
        property.printPropertyDetails();

        System.out.println("Press 1 to sell or 2 to cancel");
        selection = scanner.nextInt();
        if (selection == 1) {
            transaction.sellProperty(property, availableProperties, customer);
        }
    }

    private void purchaseMenu(Property property, Scanner scanner, Customer customer, List<Property> availableProperties) {
        property.printPropertyDetails();

        boolean quit = false;
        int selection;

        while(quit != true) {
            System.out.println("\nWould you like to purchase?");
            System.out.println("Press 1 to purchase, 2 to flag as fraudulent, or 3 to cancel");
            selection = scanner.nextInt();

            if (selection == 1) {
                transaction.purchaseProperty(property, customer, availableProperties);
                quit = true;
            } else if (selection == 2) {
                property.isFraudulent = true;
                System.out.println("You marked " + property.name + " fraudulent.");
            } else if (selection == 3) {
                quit = true;
            }
        }
    }

    private void productSelectionList(List<Property> availableProperties) {
        int index = 1;
        for (Property property : availableProperties) {
            System.out.print("Press " + index + " for: ");
            System.out.println(property.name);
            index++;
        }
    }

    private boolean displayPropertiesAvailableForPurchase(List<Property> availableProperties) {
        if (availableProperties.size() != 0) {
            productSelectionList(availableProperties);
            return false;
        }
        System.out.println("\nThere are no more properties to purchase!");
        return true;
    }
}
