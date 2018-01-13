package transaction;

import java.text.NumberFormat;
import java.util.List;

import manager.Customer;
import manager.Property;

public class Transaction {

    TransactionLogger transactionLogger = new TransactionLogger();

    public void purchaseProperty(Property propertyToPurchase, Customer customer, List<Property> availableProperties) {

        if (customer.balance >= propertyToPurchase.price) {
            completePropertyPurchase(propertyToPurchase, availableProperties, customer);

            transactionLogger.log(TransactionType.BOUGHT, customer, propertyToPurchase);

        } else {
            System.out.println("Your balance is insufficient");
        }
    }

    public void sellProperty(Property property, List<Property> availableProperties, Customer customer) {
        if (!property.isFraudulent) {

            System.out.println("Congratulations on your sale!");
            availableProperties.add(property);
            customer.properties.remove(property);
            displayOldBalance(customer);
            customer.balance += property.price;
            displayNewBalance(customer);
            transactionLogger.log(TransactionType.SOLD, customer, property);
            System.out.println("Congratulations, you sold: " + property.name);

        } else {
            System.out.println(property.name + " marked is fraudulent, you cannot sell\n");
        }
    }

    public void printLogs () {
        transactionLogger.printLogs();
    }

    private void completePropertyPurchase(Property property, List<Property> availableProperties, Customer customer) {
        System.out.println("Congratulations on your purchase!");
        availableProperties.remove(property);
        customer.properties.add(property);
        displayOldBalance(customer);
        customer.balance -= property.price;
        displayNewBalance(customer);
    }

    private void displayOldBalance(Customer customer) {
        String formattedBalance = formatCurrency(customer);
        System.out.println("Your previous balance is: " + formattedBalance);
    }

    private void displayNewBalance(Customer customer) {
        String formattedBalance = formatCurrency(customer);
        System.out.println("Your new balance is: " + formattedBalance);
    }

    private String formatCurrency(Customer customer) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return currencyFormat.format(customer.balance);
    }
}