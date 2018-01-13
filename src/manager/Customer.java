package manager;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    public String name;
    public String password;
    public int age;
    public List<Property> properties = new ArrayList<>();
    public double balance;

    public static Customer buildCustomer(PropertySelector propertySelector) {
        Customer customer = new Customer();
        customer.name = "Mike";
        customer.password = "adi";
        customer.age = 32;
        customer.balance = 350000.0;
        return customer;
    }

    public static Customer buildCustomer2(PropertySelector propertySelector) {
        Customer customer = new Customer();
        customer.name = "Courtnee";
        customer.password = "robin";
        customer.age = 21;
        customer.balance = 540000.0;
        return customer;
    }
}
