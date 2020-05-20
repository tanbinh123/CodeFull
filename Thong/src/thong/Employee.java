/**
 * This class describes an employee
 * 
 * @author: Dinh Dat Thong
 * @version: 1.0
 * */

package thong;

import java.io.Serializable;

public class Employee implements Serializable {
	
	/* instance's variables */
	protected String ID;
	protected String fullName;
	protected int age;
	protected String email;
	protected double salary;
	
	/* constructors */
	public Employee(String ID, String fullName, int age, String email, double salary) {
		this.ID = ID;
		this.fullName = fullName;
		this.age = age;
		this.email = email;
		this.salary = salary;
	}
	
	public Employee() {
		
	}
	
	/* getters */
	public String getID() {
		return this.ID;
	}
	
	public String getFullName() {
		return this.fullName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	/* setters */
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
}