/*
    Author: Daniel Ramirez
    Purpose: create a faculty class
 */
package people;

import contact_information.Address;
import contact_information.PhoneNumber;

import java.util.ArrayList;

public class Faculty extends Employee {
	String officeHrs;
	String rank;

	public Faculty() {
		super();
		officeHrs = "10am-2pm";
		rank = "full time";
	}

	public Faculty(String firstName, String lastName, String email, Address address, ArrayList<PhoneNumber> phoneNumber,
			String officeLoc, double salary, String officeHrs, String rank) {

		super(firstName, lastName, email, address, phoneNumber, officeLoc, salary);
		this.officeHrs = officeHrs;
		this.rank = rank;
	}

	public String getOfficeHrs() {
		return officeHrs;
	}

	public void setOfficeHrs(String officeHrs) {
		this.officeHrs = officeHrs;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Faculty)) {
			return false;
		} else {
			Faculty temp = (Faculty) obj;
			if (super.equals(temp) && this.officeHrs.equalsIgnoreCase(temp.officeHrs)
					&& this.rank.equalsIgnoreCase(temp.rank)) {

				return true;
			}
		}
		return false;
	}

	public String toString() {
		return super.toString() + "|  Office Hours:   " + officeHrs + "\r\n" + "|  Rank:           " + rank + "\r\n";
	}
}
