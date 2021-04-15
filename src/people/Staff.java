/*
    Author: Daniel Ramirez
    Purpose: create a staff class
 */
package people;

import contact_information.Address;
import contact_information.PhoneNumber;

import java.util.ArrayList;

public class Staff extends Employee {

	String jobTitle;

	public Staff() {
		super();
		jobTitle = "job title";
	}

	public Staff(String firstName, String lastName, String email, Address address, ArrayList<PhoneNumber> phoneNumber,
			String officeLoc, double salary, String jobTitle) {

		super(firstName, lastName, email, address, phoneNumber, officeLoc, salary);
		this.jobTitle = jobTitle;

	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Staff)) {
			return false;
		} else {
			Staff temp = (Staff) obj;
			if (super.equals(temp) && this.jobTitle.equalsIgnoreCase(temp.jobTitle)) {
				return true;
			}
		}

		return false;
	}

	public String toString() {
		return super.toString() + "|  Job Title:       " + jobTitle + "\r\n";
	}

}
