/*
    Author: Daniel Ramirez
    Purpose: create a class of Employee's
 */

package people;

import contact_information.Address;
import contact_information.PhoneNumber;

import java.util.ArrayList;

public class Employee extends Person {

	String officeLoc;
	double salary;

	public Employee() {
		super();
		officeLoc = "E&T-220";
		salary = 50000;
	}

	public Employee(String firstName, String lastName, String email, Address address,
			ArrayList<PhoneNumber> phoneNumber, String officeLoc, double salary) {
		super(firstName, lastName, email, address, phoneNumber);
		this.officeLoc = officeLoc;
		this.salary = salary;
	}

	public String getOfficeLoc() {
		return officeLoc;
	}

	public void setOfficeLoc(String officeLoc) {
		this.officeLoc = officeLoc;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Employee)) {
			return false;
		} else {
			Employee temp = (Employee) obj;
			if (super.equals(temp) && this.officeLoc.equalsIgnoreCase(temp.officeLoc) && this.salary == temp.salary) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "|  Office Location: " + officeLoc + "\r\n" + "|  Salary:          " + salary + "\r\n";
	}
}
