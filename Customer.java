package inlämningsuppgifter.uppgift2.V3_test;

import java.time.LocalDate;
public class Customer {

    // Lagrar kundens personnummer, fullständigt namn och senaste betalningsdatum.
    private String personalNumber;
    private String fullName;
    private LocalDate lastPaymentDate;

    // 2. Konstruktor för att skapa ny kund
    public Customer(String personalNumber, String fullName, LocalDate lastPaymentDate) {
        this.personalNumber = personalNumber;
        this.fullName = fullName;
        this.lastPaymentDate = lastPaymentDate;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    // 3. Kontrollerar om kunden är en nuvarande medlem.
    public boolean isCurrentMember() {
        return lastPaymentDate.isAfter(LocalDate.now().minusYears(1));
    }
}
