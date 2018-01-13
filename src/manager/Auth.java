package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Auth {

    Scanner scanner = new Scanner(System.in);
    List<Customer> customers = new ArrayList<>();

    public Auth(PropertySelector selector) {
        Customer customer1 = Customer.buildCustomer(selector);
        Customer customer2 = Customer.buildCustomer2(selector);
        customers.add(customer1);
        customers.add(customer2);
    }

    public Customer login() {

        boolean keepRunning = true;

        while(keepRunning) {
            Customer customer = getCustomer();

            Customer result = enterPassword(customer);

            if (result != null) {
                return result;
            }
        }
        return null;
    }

    private Customer getCustomer() {
        System.out.println("Select a customer");
        int index = 1;

        for(Customer customer : customers) {
            System.out.println("Press " + index + " " + customer.name);
            index++;
        }

        int selection = scanner.nextInt();
        return customers.get(selection - 1);
    }

    private Customer enterPassword(Customer customer) {

        int retry = 3;

        while(retry > 0) {
            System.out.println("Enter your password");
            String enteredPassword = scanner.next();
            if (enteredPassword.equals(customer.password)) {
                System.out.println("successful");
                return customer;
            } else {
                System.out.println("password does not match");
            }
            retry--;
        }
        return null;
    }

}
