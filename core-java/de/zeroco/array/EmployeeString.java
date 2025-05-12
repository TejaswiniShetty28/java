package de.zeroco.array;

import java.lang.reflect.Field;

public class EmployeeString {
	
	private String name;
	private String phoneNumber;
	private String age;
	private String salary;
	
	public EmployeeString(String name, String phoneNumber, String age, String salary) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getSalary() {
		return salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Employee toEmployee() throws Exception {
		Employee e = new Employee();
		for (Field f: e.getClass().getDeclaredFields()) {
			Field sf = getClass().getDeclaredField(f.getName());
			sf.setAccessible(true);
			f.setAccessible(true);
			Object o = sf.get(this);
			switch(f.getType().getName()) {
			     case("java.lang.String") : 
			    	 f.set(e, o);
			    	 break;
			     case ("int") :
			    	 f.set(e, o == null ? 0 : Integer.parseInt(o.toString()));
			    	 break;
			     case ("float") :
			    	 f.set(e, o == null ? 0 : Float.parseFloat(o.toString()));
			    	 break;
			     default :
			}
		}
		return e;
	}
	
	@Override
	public String toString() {
		return "EmployeeString [name=" + name + ", phoneNumber=" + phoneNumber + ", age=" + age + ", salary=" + salary
				+ "]";
	}

	public static void main(String[] args) throws Exception {
		EmployeeString emp = new EmployeeString("Tejaswini", "76718", "21", "5000");
		System.out.println(emp);
		Employee e = emp.toEmployee();
		System.out.println(e);
	}
	
}
