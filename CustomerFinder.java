package inlämningsuppgifter.uppgift2.V3_test;
import java.util.List;

// Lista med alla kunder
public class CustomerFinder {
    private List<Customer> customers;

    // Konstruktor som tar emot en lista med kunder
    public CustomerFinder(List<Customer> customers) {
        this.customers = customers;
    }

    // 1. Söker efter kund baserat på inmatning.
    public Customer findCustomer(String input) {
        for (Customer customer : customers) {
            if (customer.getPersonalNumber().equals(input) || customer.getFullName().equalsIgnoreCase(input)) {

                // Returnerar kunden om personnummer eller fullständigt namn matchar.
                return customer;
            }
        }

        return null;
    }
}
