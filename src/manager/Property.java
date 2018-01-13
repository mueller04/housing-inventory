package manager;

import java.text.NumberFormat;

public class Property {

    public String name;
    int numBedrooms;
    public double price;
    int squareFootage;
    double numBathrooms;
    String addressLine1;
    String city;
    String state;
    String zip;
    public boolean isFraudulent = false;

    public void printPropertyDetails() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String formattedPrice = currencyFormat.format(this.price);

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String formattedFootage = numberFormat.format(this.squareFootage);

        System.out.println("\nmanager.Property Details:\n");

        if (isFraudulent) {
            System.out.println("WARNING - this property has been marked potentially fraudulent\n");
        }

        System.out.println(this.name);
        System.out.println("price: " + formattedPrice);
        System.out.println("footage: " + formattedFootage);
        System.out.println("number of bedrooms: " + this.numBedrooms);
        System.out.println("nubmer of bathrooms: " + this.numBathrooms);

        System.out.println("Address");
        System.out.println(this.addressLine1);
        System.out.println(this.city);
        System.out.println(this.state);
        System.out.println(this.zip);
    }

    public static Property buildProperty() {
        Property prop = new Property();
        prop.name = "Cozy Abode";
        prop.addressLine1 = "789 Hamlet St";
        prop.city = "Columbus";
        prop.state = "OH";
        prop.zip = "43215";
        prop.price = 245000.21;
        prop.numBathrooms = 2.5;
        prop.numBedrooms = 3;
        prop.squareFootage = 1245;
        return prop;
    }

    public static Property buildProperty2() {
        Property prop = new Property();
        prop.name = "Small House";
        prop.addressLine1 = "4 5th Ave";
        prop.city = "Columbus";
        prop.state = "OH";
        prop.zip = "43215";
        prop.price = 65000.21;
        prop.numBathrooms = 1;
        prop.numBedrooms = 2;
        prop.squareFootage = 649;
        return prop;
    }
}
