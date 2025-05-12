package de.zeroco.employee.management;

//import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.Arrays;
//import com.opencsv.CSVReader;

public class Employee {
	
	public final static String FILE_NAME = "Employee.csv";
	public final static String[] HEADERS = {"id", "firstName", "lastName", "dob", "email", "gender", "salary", "department"};
//	public final static String filePath = Configuration.FILE_DIRECTORY_PATH + FILE_NAME;
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	private String gender;
	private float salary;
	private String department;
	
	public Employee(String firstName, String lastName, String dob, String email, String gender, float salary, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.email = email;
		this.gender = gender;
		this.salary = salary;
		this.department = department;
	}
	
	public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String setFirstName(String firstName) {
        return this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String setLastName(String lastName) {
        return  this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate setDob(String dob) {
        return this.dob = LocalDate.parse(dob);
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        return this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public String setGender(String gender) {
        return this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public String setDepartment(String department) {
        return this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public float setSalary(float salary) {
        return this.salary = salary;
    }
    
    @Override
    public String toString() {
    	return getId() + "," + getFirstName() + "," + getLastName() + "," + getDob() + "," + getEmail() + "," + getGender() + "," + getSalary() + "," + getDepartment();
    }
    
    public static Employee toObject(String csvRow) {
        String[] values = csvRow.split(",");
        String firstName = values[1];
        String lastName = values[2];
        String dob = values[3];  
        String email = values[4];
        String gender = values[5];
        float salary = Float.parseFloat(values[6]);
        String department = values[7];
        return new Employee(firstName, lastName, dob, email, gender, salary, department);
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
