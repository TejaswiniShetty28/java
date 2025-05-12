package de.zeroco.employee.management;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class EmployeeService {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	
	public static boolean validateDetails(Employee emp) {
		if (emp == null) return true;
		if (emp.getEmail().trim().isEmpty() || emp.getEmail() == null || !EMAIL_PATTERN.matcher(emp.getEmail()).matches()) return true;
		if (emp.getGender().trim().isEmpty() || emp.getGender() == null || !(emp.getGender().equalsIgnoreCase("Male") || emp.getGender().equalsIgnoreCase("Female") || emp.getGender().equalsIgnoreCase("Other"))) return true;
		if (emp.getDepartment() == null || emp.getDepartment().trim().isEmpty()) return true;
		if (emp.getSalary() < 0) return true;
		if (emp.getDob() == null || emp.getDob().isAfter(LocalDate.now()) || emp.getDob().isBefore(LocalDate.of(1900, 1, 1))) return true;
		return false;
	}
	
	public static void main(String[] args) {
//		Employee emp = new Employee("Tejaswini", "Shetty", "2004-09-20", "tejaswini@gmail.com", "female", 5000.f, "EEE");
//		Employee empOne = new Employee("Divya", "Kancherla", "2003-12-02", "manasa@gmail.com", "female", 5000.0f, "IT");
//		Employee empTwo = new Employee("Sudha", "Nadirge", "2005-09-09", "divya@gmail.com", "female", 5678.0f, "EC");
//		Employee empFour = new Employee("Susmitha", "Shinde", "2004-10-09", "susmitha@gmail.com", "female", 5678.0f, "CSE");
//		EmployeeService service = new EmployeeService();
//		System.out.println(service.save(emp));
//		System.out.println(service.save(empOne));
//		System.out.println(service.save(empTwo));
//		System.out.println(service.save(empFour));
//		System.out.println(list());
//		System.out.println(delete(3));
//		System.out.println(list());
	}
	
	public String save(Employee emp) {
		if (emp == null || validateDetails(emp)) return "";
		if (Employee.getFilePath() == null || Employee.getFilePath().trim().isEmpty()) return "";
		int index = getNextId();
		emp.setId(index);
		if (checkEmail(emp.getEmail())) {
			try (CSVWriter writer = new CSVWriter(new FileWriter(Employee.getFilePath(), true))) {
				String[] array = emp.toString().split(",");
				writer.writeNext(array);
				return "ID " + index; 
			} catch (IOException e) {
	            e.printStackTrace();
	            return "";
	        }
		}
		return "";
	}
	
	public static boolean checkEmail(String email) {
	    if (Employee.getFilePath().length() == 0) return true;
	    try (CSVReader reader = new CSVReader(new FileReader(Employee.getFilePath()))) {
	        List<String[]> allRows = reader.readAll();
	        for (int i = 1; i < allRows.size(); i++) { 
	            String[] values = allRows.get(i);
	            if (values[4].equalsIgnoreCase(email)) { 
	                return false;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return true; 
	}
	
	public static int getNextId() {
	    int lastId = 0;
	    if (Employee.getFilePath().length() == 0) return 1; 
	    try (CSVReader reader = new CSVReader(new FileReader(Employee.getFilePath()))) {
	        List<String[]> allRows = reader.readAll();
	        if (allRows.size() == 1) return ++lastId;
	        String[] lastRow = allRows.get(allRows.size() - 1);
	            lastId = Integer.parseInt(lastRow[0]);
	        return lastId + 1; 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return 1; 
	}
	
	public static List<Employee> list() {
	    List<Employee> employees = new ArrayList<>();
	    try (CSVReader reader = new CSVReader(new FileReader(Employee.getFilePath()))) {
	        List<String[]> allRows = reader.readAll();
	        for (int i = 1; i < allRows.size(); i++) { 
	            String[] array = allRows.get(i);
	            String csvRow = String.join(",", array); 
	            Employee emp = Employee.toObject(csvRow); 
	            emp.setId(Integer.parseInt(array[0])); 
	            employees.add(emp);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return employees;
	}

	public static String delete(int id) {
		if (id <= 0) return "";
		List<String[]> allRows = new ArrayList<String[]>();
	    boolean isDeleted = false;
	    try (CSVReader reader = new CSVReader(new FileReader(Employee.getFilePath()))) {
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
	        try (CSVWriter writer = new CSVWriter(new FileWriter(Employee.getFilePath()))) {
	            writer.writeAll(updatedRows); 
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "";
	        }
	    }
	    return "ID " + id + " Deleted";
	}
	
}
