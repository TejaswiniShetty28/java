package de.zeroco.employee.management;

import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) {
//        EmployeeService service = new EmployeeService();
//        SaveValidEmployee(service);
//        SaveWithInvalidEmail(service);
//        SaveWithNegativeSalary(service);
//        SaveWithInvaliDob(service);
//        SaveWithDuplicateEmail(service);
//        ListEmployees(service);
//        DeleteExistingEmployee(service);
//        DeleteNonExistingEmployee(service);
//        ListEmployeesAfterDeletion(service);
//        System.out.println("age below 18 :");
//        System.out.println("age above 18 :");
//        System.out.println("age is negative :");
    }

    public static void SaveValidEmployee(EmployeeService service) {
        Employee emp = new Employee("Tejaswini", "Shetty", "2004-09-20", "pujari@gmail.com", "Female", 5000.0f, "EEE");
        System.out.println("Test Save Valid Employee: " + service.save(emp));
    }

    public static void SaveWithInvalidEmail(EmployeeService service) {
        Employee emp = new Employee("Divya", "Kancherla", "2003-12-02", "invalid-email", "Female", 5000.0f, "IT");
        System.out.println("Test Save Employee with Invalid Email: " + service.save(emp));
    }

    public static void SaveWithNegativeSalary(EmployeeService service) {
        Employee emp = new Employee("Sudha", "Nadirge", "2005-09-09", "sudha@gmail.com", "Female", -1000.0f, "EC");
        System.out.println("Test Save Employee with Negative Salary: " + service.save(emp));
    }

    public static void SaveWithInvaliDob(EmployeeService service) {
        Employee emp = new Employee("Rohit", "Sharma", "2026-01-01", "rohit@gmail.com", "Male", 7000.0f, "HR");
        System.out.println("Test Save Employee with Future DOB: " + service.save(emp));
    }

    public static void SaveWithDuplicateEmail(EmployeeService service) {
        Employee emp = new Employee("Sneha", "Patil", "2001-08-15", "tejaswini@gmail.com", "Female", 6000.0f, "Finance");
        System.out.println("Test Save Employee with Duplicate Email: " + service.save(emp));
    }

    public static void ListEmployees(EmployeeService service) {
        List<Employee> employees = EmployeeService.list();
        System.out.println("Test List Employees: ");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public static void DeleteExistingEmployee(EmployeeService service) {
        int deleteId = 1; 
        System.out.println("Test Delete Existing Employee with ID " + deleteId + ": " + EmployeeService.delete(deleteId));
    }

    public static void DeleteNonExistingEmployee(EmployeeService service) {
        System.out.println("Test Delete Non-Existing Employee with ID 100: " + EmployeeService.delete(100));
    }

    public static void ListEmployeesAfterDeletion(EmployeeService service) {
        List<Employee> employeesAfterDeletion = EmployeeService.list();
        System.out.println("Test List Employees After Deletion: ");
        for (Employee emp : employeesAfterDeletion) {
            System.out.println(emp);
        }
    }
    
}
