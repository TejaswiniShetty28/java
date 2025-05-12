package de.zeroco.employee.management;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class ContributionService {
    
	public static boolean validateDetails(Contribution contribution) {
	    if (contribution == null) return true;
	    if (contribution.getAmount() <= 0) return true;
	    if (contribution.getDate() == null || contribution.getDate().isAfter(LocalDate.now())) return true;
	    if (contribution.getDescription() == null || contribution.getDescription().trim().isEmpty()) return true;
	    List<String> validUsers = Arrays.asList("f1", "f2", "f3", "f4", "");
	    if (!validUsers.contains(contribution.getTransactionMember())) return true;
	    if (!validUsers.contains(contribution.getFamilyMember())) return true;
	    if (!contribution.getCreditOrDebit().equalsIgnoreCase("credit") && !contribution.getCreditOrDebit().equalsIgnoreCase("debit")) return true;
	    return false;
	}
	
	public static void main(String[] args) {
//		Contribution contribution = new Contribution("01-01-2025", "", "f1", 30000.0f, "credit", "salary");
//		ContributionService service = new ContributionService();
//		System.out.println(list());
		
	}

    public String save(Contribution contribution) {
        if (contribution == null || validateDetails(contribution)) return "";
        if (Contribution.getFilePath() == null || Contribution.getFilePath().trim().isEmpty()) return "";
        try (CSVWriter writer = new CSVWriter(new FileWriter(Contribution.getFilePath(), true))) {
            String[] array = contribution.toString().split(",");
            writer.writeNext(array);
            return "Saved Successfully"; 
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static List<Contribution> list() {
        List<Contribution> contributions = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(Contribution.getFilePath()))) {
            List<String[]> allRows = reader.readAll();
            for (int i = 1; i < allRows.size(); i++) { 
                String[] array = allRows.get(i);
                String csvRow = String.join(",", array); 
                Contribution contribution = Contribution.toObject(csvRow); 
                contributions.add(contribution);
//                System.out.println("hi" + contributions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contributions;
    }
    
    public static String delete(String date, String from, String to, float amount) {
        if (date == null || date.trim().isEmpty() || amount <= 0) return "";
        List<String[]> allRows = new ArrayList<>();
        boolean isDeleted = false;
        try (CSVReader reader = new CSVReader(new FileReader(Contribution.getFilePath()))) {
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
                if (row[0].equals(date) && row[1].equals(from) && row[2].equals(to) && Float.parseFloat(row[3]) == amount) {
                    isDeleted = true; 
                } else {
                    updatedRows.add(row);
                }
            }
        }
        if (isDeleted) {
            try (CSVWriter writer = new CSVWriter(new FileWriter(Contribution.getFilePath()))) {
                writer.writeAll(updatedRows); 
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "Deleted Successfully";
    }
    
}
