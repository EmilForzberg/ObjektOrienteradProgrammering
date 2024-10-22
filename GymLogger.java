package inlämningsuppgifter.uppgift2.V3_test;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GymLogger {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH.mm.ss");

    // 1. Loggar träningsinformationen för medlem
    public void logTraining(String gymLogFile, Customer customer) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(gymLogFile, true))) {

            // 2. Hämtar dagens datum och tid.
            String currentDate = LocalDate.now().format(dateFormat);
            String currentTime = LocalTime.now().format(timeFormat);

            // 2a. Skriver ut träningslogg till filen.
            writer.write(
                        customer.getPersonalNumber() + ", " +
                            customer.getFullName() + ", " +
                                currentDate + " –– " +
                                currentTime + "\n");
        }
    }
}

