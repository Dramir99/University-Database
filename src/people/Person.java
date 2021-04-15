/*
    Author: Daniel Ramirez
    Purpose: create a person class
 */
package people;

import contact_information.Address;
import contact_information.PhoneNumber;

import java.util.ArrayList;

public class Person {

	String firstName;
	String lastName;
	String email;
	Address address;
	ArrayList<PhoneNumber> phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ArrayList<PhoneNumber> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(ArrayList<PhoneNumber> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Person() {
		firstName = "first";
		lastName = "last";
		email = "email";
		address = new Address();
		phoneNumber = new ArrayList<>();
	}

	public Person(String firstName, String lastName, String email, Address address,
			ArrayList<PhoneNumber> phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		} else {
			Person temp = (Person) obj;
			if ((this.firstName.equalsIgnoreCase(temp.firstName)) && this.lastName.equalsIgnoreCase(temp.lastName)
					&& this.address.equals(temp.address) && this.phoneNumber.equals(temp.phoneNumber)
					&& this.email.equalsIgnoreCase(temp.email)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String output = "";
		output += "|  Name:            " + firstName + " " + lastName + "\r\n" + "|  Email            " + email + "\r\n"
				+ "|  Address:         " + address.toString() + "\r\n" + "|  PhoneNumber";
		output += (phoneNumber.size() > 1 == true) ? "(s):  " : ":     ";

		for (int i = 0; i < phoneNumber.size(); i++) {
			output += phoneNumber.get(i).toString() + "\r\n";
			if ((i + 1) < phoneNumber.size()) {
				output += "|\t\t\t\t\t";
			}
		}
		if (phoneNumber.size() == 0) {
			output += "\r\n";
		}

		return output;
	}
}
