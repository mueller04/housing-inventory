package transaction;

import manager.Customer;
import manager.Property;

import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {

    List<SingleLog> logs = new ArrayList<>();

    void log(TransactionType transactionType, Customer customer, Property property){

        SingleLog singleLog = new SingleLog();

        logs.add(singleLog);

        singleLog.customer = customer;
        singleLog.property = property;
        singleLog.transactionType = transactionType;

        System.out.println("Logged " +
                property.name + " " +
                customer.name + " " + transactionType);
    }

    public void printLogs(){

        for (SingleLog l: logs){

            System.out.println(l.customer.name + " " +
                l.property.name + " " + l.transactionType);
        }
    }
}
