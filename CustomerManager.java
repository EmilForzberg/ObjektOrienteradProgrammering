package inlämningsuppgifter.uppgift2.V3_test;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers = new ArrayList<>();

    // 1. Läser in kundlistan från filen.
    public void loadCustomersFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            // 2. Läser in varje rad från filen.
            String line;
            while ((line = reader.readLine()) != null) {

                // 2a. Delar upp informationen i två delar: personnummer och fullständigt namn.
                String[] parts = line.split(", ");
                String personalNumber = parts[0];
                String fullName = parts[1];

                // 2b. Läser in sista betalningsdatumet.
                LocalDate lastPaymentDate = LocalDate.parse(reader.readLine().trim(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                // 2c. Lägger till ny kund i listan.
                customers.add(new Customer(personalNumber, fullName, lastPaymentDate));
            }
        }
    }

    // 3. Hämtar listan.
    public List<Customer> getCustomers() {
        return customers;
    }
}


