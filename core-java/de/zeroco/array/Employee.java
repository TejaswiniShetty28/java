package de.zeroco.array;

public class Employee {
	
	private String name;
	private int phoneNumber;
	private int age;
	private float salary;
	public String getName() {
		return name;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public float getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", phoneNumber=" + phoneNumber + ", age=" + age + ", salary=" + salary + "]";
	}
	
}
