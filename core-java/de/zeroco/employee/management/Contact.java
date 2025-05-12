package de.zeroco.employee.management;

//import java.io.FileReader;
import java.io.IOException;
//import java.util.Arrays;
//import com.opencsv.CSVReader;

public class Contact {

    public final static String FILE_NAME = "contactfile.csv";
    public final static String[] HEADERS = {"name", "phoneNumber", "email"};
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static Contact toObject(String csvRow) {
        String[] values = csvRow.split(",");
        String name = values[0];
        String phoneNumber = values[1];
        String email = values[2];
        return new Contact(name, phoneNumber, email);
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String setPhoneNumber(String phoneNumber) {
        return this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        return this.email = email;
    }

    @Override
    public String toString() {
        return getName() + "," + getPhoneNumber() + "," + getEmail();
    }
    
    public static String getFilePath() {
        return Configuration.FILE_DIRECTORY_PATH + FILE_NAME;
    }
    
    static {
    	if (!Utility.ifFileExist(getFilePath())) {
          try {
        	  System.out.println("hi");
              Utility.writeHeadersInCsv(HEADERS, Configuration.FILE_DIRECTORY_PATH, FILE_NAME);
              System.out.println("file created");
          } catch (IOException e) {
              e.getMessage();
          }
      } else {
    	  Utility.validateCSVHeaders(getFilePath(), HEADERS);
      }
    }
    
}
