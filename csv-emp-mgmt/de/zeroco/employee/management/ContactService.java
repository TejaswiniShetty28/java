package de.zeroco.employee.management;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class ContactService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");

    public static boolean validateDetails(Contact contact) {
        if (contact == null) return true;
        if (contact.getEmail().trim().isEmpty() || contact.getEmail() == null || !EMAIL_PATTERN.matcher(contact.getEmail()).matches()) return true;
        if (contact.getPhoneNumber().trim().isEmpty() || contact.getPhoneNumber() == null || !PHONE_PATTERN.matcher(contact.getPhoneNumber()).matches()) return true;
        return false;
    }

    public static void main(String[] args) {
//		Contact contact = new Contact("Tejaswini", "9949895392", "tejaswini@gmail.com");
//		Contact contactTwo = new Contact("Tejaswini", "7671834414", "sai@gmail.com");
//		ContactService  service = new ContactService();
//		System.out.println(list());
	}
    public String save(Contact contact) {
        if (contact == null || validateDetails(contact)) return "";
        if (Contact.getFilePath() == null || Contact.getFilePath().trim().isEmpty()) return "";
        int index = getNextId();
        if (checkEmail(contact.getEmail()) && checkPhoneNumber(contact.getPhoneNumber())) {
            try (CSVWriter writer = new CSVWriter(new FileWriter(Contact.getFilePath(), true))) {
                String[] array = contact.toString().split(",");
                writer.writeNext(array);
                return "ID " + index ;
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static boolean checkEmail(String email) {
        if (Contact.getFilePath().length() == 0) return true;
        try (CSVReader reader = new CSVReader(new FileReader(Contact.getFilePath()))) {
            List<String[]> allRows = reader.readAll();
            for (int i = 1; i < allRows.size(); i++) {
                String[] values = allRows.get(i);
                if (values[2].equalsIgnoreCase(email)) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        if (Contact.getFilePath().length() == 0) return true;
        try (CSVReader reader = new CSVReader(new FileReader(Contact.getFilePath()))) {
            List<String[]> allRows = reader.readAll();
            for (int i = 1; i < allRows.size(); i++) {
                String[] values = allRows.get(i);
                if (values[2].equals(phoneNumber)) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static int getNextId() {
        if (Contact.getFilePath().isEmpty()) return 0; 
        try (CSVReader reader = new CSVReader(new FileReader(Contact.getFilePath()))) {
            List<String[]> allRows = reader.readAll();
            if (allRows.size() == 1) { 
                return 1;
            }
            int lastId = allRows.size() - 1; 
            return lastId + 1; 

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 0; 
    }

    public static List<Contact> list() {
        List<Contact> contacts = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(Contact.getFilePath()))) {
            List<String[]> allRows = reader.readAll();
            for (int i = 1; i < allRows.size(); i++) { 
                String[] array = allRows.get(i);
                if (array.length < 3) continue;
                String csvRow = String.join(",", array); 
                Contact contact = Contact.toObject(csvRow); 
                contacts.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public static String delete(int id) {
        if (id <= 0) return "";
        List<String[]> allRows = new ArrayList<String[]>();
        boolean isDeleted = false;
        try (CSVReader reader = new CSVReader(new FileReader(Contact.getFilePath()))) {
            allRows = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        List<String[]> updatedRows = new ArrayList<>();
        if (allRows.size() > 0) {
            updatedRows.add(allRows.get(0)); 
            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);
                if (Integer.parseInt(row[0]) == id) {
                    isDeleted = true;
                } else {
                    updatedRows.add(row);
                }
            }
        }
        if (isDeleted) {
            try (CSVWriter writer = new CSVWriter(new FileWriter(Contact.getFilePath()))) {
                writer.writeAll(updatedRows); 
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "ID " + id + " Deleted";
    }
}
