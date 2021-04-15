/*
    Author: Daniel Ramirez
    Purpose: create a class of Student
 */
package people;

import contact_information.Address;
import contact_information.PhoneNumber;

import java.util.ArrayList;

public class Student extends Person {
	protected String classStanding;

	public Student() {
		super();
		classStanding = "freshman";
	}

	public Student(String firstName, String lastName, String email, Address address, ArrayList<PhoneNumber> phoneNumber,
			String classStanding) {
		super(firstName, lastName, email, address, phoneNumber);
		this.classStanding = classStanding;
	}


	public String getClassStanding() {
		return classStanding;
	}

	public void setClassStanding(String classStanding) {
		this.classStanding = classStanding;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			return false;
		} else {
			Student temp = (Student) obj;
			if (super.equals(temp) && this.classStanding.equalsIgnoreCase(temp.classStanding)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return super.toString() + "|  Class Standings: " + classStanding + "\r\n";
	}
}
