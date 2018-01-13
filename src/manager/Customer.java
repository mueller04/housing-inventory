package manager;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    public String name;
    public int age;
    public List<Property> properties = new ArrayList<>();
    public double balance;

    public static Customer buildCustomer(PropertySelector propertySelector) {
        Customer mike = new Customer();
        mike.name = "Mike";
        mike.age = 32;
        mike.balance = 350000.0;
        return mike;
    }
}
