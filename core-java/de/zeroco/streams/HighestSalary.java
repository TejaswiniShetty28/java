package de.zeroco.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Alice", 50000), new Employee("Bob", 60000), new Employee("Charlie", 70000), new Employee("David", 55000));
        List<Employee> employeesInDept = Arrays.asList(
            new Employee("Alice", 50000, "IT"),
            new Employee("Bob", 60000, "CSE"),
            new Employee("Charlie", 70000, "EEE"),
            new Employee("David", 80000, "IT"),
            new Employee("Eve", 75000, "CSE"),
            new Employee("Frank", 50000, "EEE"),
            new Employee("Grace", 65000, "MECH"),
            new Employee("Hank", 40000, "ECE"),
            new Employee("Ivy", 45000, "CIVIL")
        );
        Optional<Employee> highestPay = employees.stream().sorted((e1, e2) -> Float.compare(e2.getSalary(), e1.getSalary())).findFirst();
        highestPay.ifPresent(employee -> System.out.println("Highest Salary: " + employee.getSalary()));
        Map<String, Optional<Employee>> highestPayInDept = employeesInDept.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
                highestPayInDept.forEach((department, employee) -> {
                employee.ifPresent(emp -> System.out.println(department + " -> " + emp));
            // If no employee in department, print a custom message
//            if (employee.isEmpty()) {
//                System.out.println(department + " -> No employees in this department");
//            }
        });
    }
    
}
