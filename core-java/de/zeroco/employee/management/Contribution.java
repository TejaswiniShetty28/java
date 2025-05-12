package de.zeroco.employee.management;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contribution {
    
    public final static String FILE_NAME = "Contribution.csv";
    public final static String[] HEADERS = {"date", "from", "to", "amount", "credit/debit", "description"};
    
//    public static void main(String[] args) {
//		System.out.println("hi");
//	}
    
    private LocalDate date;
    private String from;
    private String to;
    private float amount;
    private String creditOrDebit;
    private String description;	
    
    public Contribution(String date, String from, String to, float amount, String creditOrDebit, String description) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = LocalDate.parse(date, formatter); 
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.creditOrDebit = creditOrDebit;
        this.description = description;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public LocalDate setDate(String date) {
        return this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getTransactionMember() {
        return from;
    }

    public String setTransactionMember(String from) {
        return this.from = from;
    }

    public String getFamilyMember() {
        return to;
    }

    public String setFamilyMember(String to) {
        return this.to = to;
    }

    public float getAmount() {
        return amount;
    }

    public float setAmount(float amount) {
        return this.amount = amount;
    }

    public String getCreditOrDebit() {
        return creditOrDebit;
    }

    public String setCreditOrDebit(String creditOrDebit) {
        return this.creditOrDebit = creditOrDebit;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        return this.description = description;
    }
    
    @Override
    public String toString() {
        return getDate() + "," + getTransactionMember() + "," + getFamilyMember() + "," + getAmount() + "," + getCreditOrDebit() + "," + getDescription();
    }
    
    
    public static Contribution toObject(String csvRow) {
        String[] values = csvRow.split(",");
        String date = values[0];
        String from = values[1];
        String to = values[2];
        float amount = Float.parseFloat(values[3].replace(",", ""));
        String creditOrDebit = values[4];
        String description = values[5];
        return new Contribution(date, from, to, amount, creditOrDebit, description);
    }
    
    public static String getFilePath() {
        return Configuration.FILE_DIRECTORY_PATH + FILE_NAME;
    }
    
    static {
        if (!Utility.ifFileExist(getFilePath())) {
            try {
                Utility.writeHeadersInCsv(HEADERS, Configuration.FILE_DIRECTORY_PATH, FILE_NAME);
            } catch (IOException e) {
                e.getMessage();
            }
        } else {
            Utility.validateCSVHeaders(getFilePath(), HEADERS);
        }
    }
    
}
