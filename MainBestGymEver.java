package inlämningsuppgifter.uppgift2.V3_test;
import java.io.IOException;
import java.util.Scanner;

/*
    1. Importera scanner gör instanser av klasser.
        a. Skapa klassen Customer.
        b. Skapa en CustomerManager, hanterar kunddata.
        c. Skapa en CustomerFinder, hanterar sökning.
        d. Skapa en GymLogger, hanterar skrivning till fil.

    2. Starta en loop som kan söka efter kunder.
        a. Loop tills användaren vill avsluta.
        b. Skapa en fråga till användaren (input).
        c. Använd skapad CustomerFinder för att söka efter kund.

    3. Verifiera medlemskap.
        a. Om kund inte hittas, skriv ut felmeddelande.
        b. Om kund varit en tidigare kund, skriv ut det.
        c. 1. Om kund är nuvarande kund, skriv ut det.
            c. 2. Logga träningsinformationen i GymLogger.

     4. Söka kund. Vill användaren fortsätta köra programmet.
        a. Yes eller No.
            a. 1. Yes. Loop.
            b. 2. No. Avslutningsmeddelande. Programmets stängs.
            c. 3. Felmeddelande om användaren inte skriver något av detta. Loop igen.

     5. Felhantering. Fånga IOException vid filinläsning och loggning.
        a. Try-With-Resources.
        b. Felmeddelande vid fel.

 */


public class MainBestGymEver {
    public static void main(String[] args) {

        // 1abc.
        Scanner scanner = new Scanner(System.in);
        CustomerManager customerManager = new CustomerManager();
        CustomerFinder customerFinder = new CustomerFinder(customerManager.getCustomers());
        GymLogger gymLogger = new GymLogger();

        // 5a. Try-With-Resources.
        try {
            customerManager.loadCustomersFromFile("src/inlämningsuppgifter/uppgift2/V3_test/CustomerList.txt");
            boolean continueRunningProgram = true;

            // 2a. Main-loop för att söka efter flera kunder.
            while (continueRunningProgram) {
                // 2b.
                System.out.print("Enter personal number or name: ");
                String input = scanner.nextLine();

                // 2c.
                Customer customer = customerFinder.findCustomer(input);

                if (customer == null) {
                    // 3a.
                    System.out.println("Unauthorized, person not in the system. Try again.");
                } else if (customer.isCurrentMember()) {

                    // 3c.
                    System.out.println(customer.getFullName() + " is currently a member.");
                    gymLogger.logTraining("src/inlämningsuppgifter/uppgift2/V3_test/GymLog.txt", customer);
                } else {

                    // 3b.
                    System.out.println(customer.getFullName() + " was previously a member.");
                }

                // 4.
                String response;
                do {
                    System.out.print("\nDo you want to search for another customer? (Yes/No): ");
                    response = scanner.nextLine().trim().toLowerCase();

                    // 4abc.
                    if (response.equals("yes")) {
                        break;
                    } else if (response.equals("no")) {
                        continueRunningProgram = false;
                    } else {
                        System.out.println("Wrong input. Please enter 'Yes' to continue or 'No' to close program.");
                    }
                } while (!response.equals("yes") && !response.equals("no"));
            }

            // 4b.
            System.out.println("\nThank you for training with us today. Program closing.");

            // 5b. Try-With-Resources.
        } catch (IOException e) {
            System.out.println("Error occurred when reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
