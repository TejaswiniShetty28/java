package de.zeroco.stream;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;

public class Transaction {

	 public static List<String> totalMembers(String filePath) {
		 if (filePath.trim().isEmpty() || filePath == null) return new ArrayList<String>();
	        List<String> list = new ArrayList<String>();
	        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
	            String[] line;
	            reader.readNext();
	            while ((line = reader.readNext()) != null) {
	                if (!line[1].isEmpty()) { 
	                    list.add(line[0]);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return list;
	 }
	 
	 // by using conditions - cash in each hand
	 public static String cash(List<Contribution> contributions, List<String> members) {
		    if (contributions == null || members == null) return "";
		    float amount;
		    Map<String, Float> data = new HashMap<String, Float>();
		    for (String member : members) {
		        data.put(member, 0f);
		    }
		    for (String member : members) {
		        amount = 0;
		        for (Contribution entry : contributions) {
		            float money = entry.getAmount();
		            if (!entry.getTransactionMember().trim().isEmpty() && entry.getFamilyMember().trim().isEmpty()) {
		                if (member.equals(entry.getTransactionMember())) {
		                    amount -= money;
		                }
		            }
		            if (entry.getTransactionMember().trim().isEmpty() && !entry.getFamilyMember().trim().isEmpty()) {
		                if (member.equals(entry.getFamilyMember())) {
		                    amount += money;
		                }
		            }
		            if (!entry.getTransactionMember().trim().isEmpty() && !entry.getFamilyMember().trim().isEmpty()) {
		                if (member.equals(entry.getTransactionMember()) && "debit".equals(entry.getCreditOrDebit())) {
		                    amount -= money;
		                }
		            }
		            if (!entry.getTransactionMember().trim().isEmpty() && !entry.getFamilyMember().trim().isEmpty()) {
		                if (member.equals(entry.getTransactionMember()) && "credit".equals(entry.getCreditOrDebit())) {
		                    amount += money;
		                }
		            }
		        }
		        data.put(member, amount);
		    }
		    List<Map.Entry<String, Float>> sortedList = new ArrayList<>(data.entrySet());
		    sortedList.sort((entry1, entry2) -> Float.compare(entry2.getValue(), entry1.getValue()));
		    for (Map.Entry<String, Float> entry : sortedList) {
		        System.out.println(entry.getKey() + ": " + entry.getValue());
		    }
		    if (!sortedList.isEmpty()) {
		        return sortedList.get(0).getKey();
		    }
		    return "";
	 }
	 
	 public static String highestDebit(List<Contribution> contributions, List<String> members) {
		    if (contributions == null || members == null) return "";
		    Map<String, Float> data = members.stream()
		            .collect(Collectors.toMap(member -> member, member -> 0f));
		    Map<String, Float> debitAmounts = contributions.stream()
		            .filter(entry -> !entry.getTransactionMember().trim().isEmpty()) 
		            .filter(entry -> entry.getFamilyMember().trim().isEmpty() || "debit".equals(entry.getCreditOrDebit()))
		            .collect(Collectors.groupingBy(Contribution::getTransactionMember, Collectors.reducing(0f, Contribution::getAmount, Float::sum)));
		    data.replaceAll((member, amount) -> debitAmounts.getOrDefault(member, 0f));
		    data.forEach((member, amount) -> System.out.println(member + ": " + amount));
		    return data.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
		}
	 
	 // who contributed more to father by streams
	 public static String contribution(List<Contribution> contributions) {
		    if (contributions == null) return "";
		    Map<String, Float> data = new HashMap<>();
		    data.put("f2", 0f);
		    data.put("f3", 0f);
		    data.put("f4", 0f);
		    contributions.stream()
		            .filter(entry -> !entry.getTransactionMember().trim().isEmpty() && entry.getFamilyMember().equals("f1") && "debit".equals(entry.getCreditOrDebit()))
		            .forEach(entry -> {
		                String from = entry.getTransactionMember();
		                float amount = entry.getAmount();
		                if (data.containsKey(from)) {
		                    data.put(from, data.get(from) + amount);  
		                }
		            });
		    List<Map.Entry<String, Float>> sortedList = new ArrayList<>(data.entrySet());
		    sortedList.sort((entry1, entry2) -> Float.compare(entry2.getValue(), entry1.getValue()));
		    for (Map.Entry<String, Float> entry : sortedList) {
//		        System.out.println(entry.getKey() + ": " + entry.getValue());
		    }
		    return sortedList.stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
		}
	 
		 public static String highestspend(List<Contribution> contributions) {
		        Map<String, Float> groupedById = contributions.stream()
		            .collect(Collectors.groupingBy(
		                Contribution::getTransactionMember,
		                Collectors.reducing(0f, contribution -> 
		                    contribution.getCreditOrDebit().equals("credit") ? contribution.getAmount() : -contribution.getAmount(),
		                    Float::sum)
		            ));
		        groupedById.forEach((id, balance) -> {
//		            System.out.println("Member: " + id + ", Cash: " + balance);
		        });
		        return groupedById.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
		    }
	 public static void main(String[] args) {
//		 System.out.println(totalMembers(Family.getFilePath()));
//		 System.out.println("i have more cash " + cash(ContributionService.list(), totalMembers(Family.getFilePath())));
//		 System.out.println("i spent more " + highestDebits(ContributionService.list(), totalMembers(Family.getFilePath())));
//		 System.out.println("i contributed more " + contribution(ContributionService.list()));
//		 String highestSpender = (highestspend((ContributionService.list())));
//	        System.out.println("Highest spender ID: " + highestSpender);
//		 System.out.println(highestspend((ContributionService.list())));
//		 groupedById.forEach((id, balance) -> {
//	            System.out.println("ID: " + id + ", Net Balance: " + balance);
//	        });
	 }
}

